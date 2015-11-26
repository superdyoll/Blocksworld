/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class Board implements Comparable<Board> {

    private int size;
    private int agentX = 0;
    private int agentY = 0;
    private int agentValue = 0;

    public enum Direction {

        LEFT, RIGHT, UP, DOWN;

        private static final List<Direction> values = Collections.unmodifiableList(Arrays.asList(values()));

        private static final int size = values.size();
        private static final Random randomGen = new Random();

        public static Direction randomDirection() {
            return values.get(randomGen.nextInt(size));
        }
    }

    /* On the board 0 is considered to be a blank square and the value
     * of size * size is considered to be the position of the agent
     * First array is y
     * Second array is X
     */
    private Integer[][] boardArray;

    public Board(Integer[][] state) throws Exception {
        if (!setState(state)) {
            throw new Exception("Input state not of right format");
        }

    }

    public Board(int size) {
        this.size = size;
        this.agentValue = size * size;
        boardArray = createEmptyState();
    }

    protected Integer[][] createEmptyState() {
        Integer[][] state = new Integer[size][size];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                state[y][x] = 0;
            }
        }

        return state;
    }

    public boolean setValue(int x, int y, int value) {
        boolean isSet = false;
        if (isSquareWithinBounds(x, y)) {
            if (value >= 0 && value < size * size) {
                boardArray[y][x] = value;
                isSet = true;
            }
        }
        return isSet;
    }

    public int getValue(int x, int y) {
        return boardArray[y][x];
    }

    private boolean setState(Integer[][] state) throws Exception {
        boolean isSet = false;
        if (state.length == state[0].length) {
            int stateSize = state.length;
            boolean allowSet = true;
            for (Integer[] innerState : state) {
                for (Integer value : innerState) {
                    if (value != null) {
                        if (value > stateSize * stateSize || value < 0) {
                            allowSet = false;
                            System.out.println("Setting false as value = " + value);
                        }
                    }
                }
            }
            if (allowSet) {
                boardArray = state;
                this.size = state.length;
                this.agentValue = size * size;
                if (findAgent()) {
                    isSet = true;
                }
            }
        }
        return isSet;
    }

    public Integer[][] getState() {
        return boardArray;
    }

    public boolean equals(Board otherBoard) {
        boolean areEqual = true;
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                if (!Objects.equals(otherBoard.getState()[y][x], this.getState()[y][x])) {
                    areEqual = false;
                }
            }
        }
        return areEqual;
        //return Arrays.equals(otherBoard.getState(), this.getState());
    }

    public String toString() {
        String output = "";
        for (Integer[] innerState : boardArray) {
            for (Integer value : innerState) {
                if (value == null) {
                    output += " #";
                } else if (value == size * size) {
                    output += " @";
                } else {
                    output += " " + value;
                }
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Moves the agent to another location by swapping with the current contents
     * of that square
     *
     *
     * @param squareX
     * @param squareY
     * @return Returns the number that it has swapped with
     */
    public Integer moveAgent(int squareX, int squareY) throws Exception {

        Integer movedValue = null;
        if (isSquareNextToSquare(agentX, agentY, squareX, squareY)
                && isSquareAgent(agentX, agentY)
                && isSquareMoveableTo(squareX, squareY)
                && findAgent()) {
            //System.out.println("Current agent (x,y): (" + agentX + "," + agentY + ")");
            //System.out.println("Passed all tests");
            movedValue = boardArray[squareY][squareX];
            //System.out.println("Moved val: " + movedValue);
            boardArray[squareY][squareX] = boardArray[agentY][agentX];
            boardArray[agentY][agentX] = movedValue;
            agentX = squareX;
            agentY = squareY;
            //System.out.println("New Agent (x,y): (" + agentX + "," + agentY + ")");
        } else {
            throw new Exception("Unable to move agent");
        }
        //System.out.println("The grid space now");
        //System.out.println(this);
        //System.out.println("Finished");
        return movedValue;
    }

    public Integer moveAgent(Direction direction) throws Exception {
        switch (direction) {
            case LEFT:
                return moveAgent(agentX - 1, agentY);
            case RIGHT:
                return moveAgent(agentX + 1, agentY);
            case UP:
                return moveAgent(agentX, agentY - 1);
            case DOWN:
                return moveAgent(agentX, agentY + 1);
        }

        return null;
    }

    private boolean isSquareNextToSquare(int firstX, int firstY, int secondX, int secondY) {
        boolean isNextToSquare = false;
        if (isSquareWithinBounds(firstX, firstY)
                && isSquareWithinBounds(secondX, secondY)) {
            int xDiff = Math.abs(firstX - secondX);
            int yDiff = Math.abs(firstY - secondY);
            if ((xDiff == 0 && yDiff == 1) || (xDiff == 1 && yDiff == 0)) {
                isNextToSquare = true;
            }
        }
        return isNextToSquare;
    }

    private boolean isSquareWithinBounds(int x, int y) {
        boolean inSquare = false;
        if (x >= 0 && x < size) {
            if (y >= 0 && y < size) {
                inSquare = true;
            }
        }
        return inSquare;
    }

    private boolean isSquareMoveableTo(int x, int y) {
        boolean moveableTo = false;
        if (isSquareWithinBounds(x, y)) {
            if (boardArray[y][x] != null
                    && boardArray[y][x] != size * size) {
                moveableTo = true;
            }
        }
        return moveableTo;
    }

    private boolean isSquareAgent(int x, int y) {
        return boardArray[y][x] == size * size;
    }

    public boolean findAgent() throws Exception {
        boolean agentFound = isSquareAgent(agentX, agentY);
        if (!agentFound) {
            int[] agentPosition = findAgent(boardArray);
            agentX = agentPosition[0];
            agentY = agentPosition[1];
            agentFound = true;
        }
        return agentFound;
    }

    private int[] findAgent(Integer[][] board) throws Exception {
        int[] agentLocation = new int[2];
        boolean isSet = false;
        for (int y = 0; y < board.length; y++) {
            for (int x = 0; x < board[y].length; x++) {
                if (board[y][x] == size * size) {
                    agentLocation[0] = x;
                    agentLocation[1] = y;
                    isSet = true;
                }
            }
        }
        if (isSet) {
            return agentLocation;
        } else {
            throw new Exception("Agent not found");
        }
    }

    public ArrayList<Direction> findPossibleMoves() throws Exception {
        if (findAgent()) {
            ArrayList<Direction> directions = new ArrayList<>();
            if (agentX > 0 && agentX < size) {
                directions.add(Direction.LEFT);
            }
            if (agentX >= 0 && agentX < size - 1) {
                directions.add(Direction.RIGHT);
            }
            if (agentY > 0 && agentY < size) {
                directions.add(Direction.UP);
            }
            if (agentY >= 0 && agentY < size - 1) {
                directions.add(Direction.DOWN);
            }
            // Add some randomness into the order of directions
            Collections.shuffle(directions);
            return directions;
        } else {
            return null;
        }
    }

    public Board clone() {
        Integer[][] clone = new Integer[size][size];
        for (int y = 0; y < size; y++) {
            clone[y] = boardArray[y].clone();
        }
        Board returnBoard = null;
        try {
            returnBoard = new Board(clone);

        } catch (Exception ex) {
            Logger.getLogger(Board.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return returnBoard;
    }

    @Override
    public int compareTo(Board otherBoard) {
        if (this.equals(otherBoard)) {
            return 0;
        } else {
            HashMap<Integer, Integer[]> thisBoardHash = getBlockLocations();
            HashMap<Integer, Integer[]> otherBoardHash = otherBoard.getBlockLocations();

            Iterator thisBoardIt = thisBoardHash.entrySet().iterator();
            Iterator otherBoardIt = otherBoardHash.entrySet().iterator();

            int offset = 0;

            while (thisBoardIt.hasNext() && otherBoardIt.hasNext()) {
                Map.Entry<Integer, Integer[]> pair = (Map.Entry<Integer, Integer[]>) thisBoardIt.next();
                Integer[] otherBoardValue = otherBoardHash.get(pair.getKey());
                if (otherBoardValue != null) {
                    if (!Arrays.equals(pair.getValue(), otherBoardValue)) {
                        //Calculate the manhatten distance
                        //System.out.println("The don't equal");
                        int xDiff = Math.abs(pair.getValue()[0] - otherBoardValue[0]);
                        //System.out.println("xDiff " + xDiff);
                        int yDiff = Math.abs(pair.getValue()[1] - otherBoardValue[1]);
                        //System.out.println("yDiff " + yDiff);
                        int manDistance = xDiff + yDiff;
                        offset += manDistance;
                    }
                }
            }

            return offset;

        }

    }

    /**
     * Gets the location of all the non-zero objects
     *
     * @return Returns a hash map of the value and it's location in array [x,y]
     */
    protected HashMap<Integer, Integer[]> getBlockLocations() {
        HashMap<Integer, Integer[]> returnHash = new HashMap<>();
        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                if (boardArray[y][x] != 0) {
                    Integer[] coordinates = new Integer[2];
                    coordinates[0] = x;
                    coordinates[1] = y;
                    returnHash.put(boardArray[y][x], coordinates);
                }
            }
        }
        return returnHash;
    }
}
