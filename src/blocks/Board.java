/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.Arrays;

/**
 *
 * @author Lloyd
 */
public class Board {

    private int size;

    /* On the board 0 is considered to be a blank square and the value
     * of size * size is considered to be the position of the agent
     */
    private Integer[][] boardArray;

    public Board(Integer[][] state) throws Exception {
        if (!setState(state)) {
            throw new Exception("Input state not of right format");
        }

    }

    public Board(int size) {
        this.size = size;
        boardArray = new Integer[size][size];
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

    private boolean setState(Integer[][] state) {
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
                isSet = true;
            }
        }
        return isSet;
    }

    public Integer[][] getState() {
        return boardArray;
    }

    public boolean isEqual(Board otherBoard) {
        return Arrays.equals(otherBoard.getState(), this.getState());
    }

    public String toString() {
        String output = "";
        for (Integer[] innerState : boardArray) {
            for (Integer value : innerState) {
                if (value == null) {
                    output += " #";
                } else if (value == size*size) {
                    output += " @";
                } else {
                    output += " " + value;
                }
            }
            output += "\n";
        }
        return output;
    }

    /**Moves the agent to another location by swapping with the current contents
     * of that square
     *
     * @param agentX
     * @param agentY
     * @param squareX
     * @param squareY
     * @return
     * Returns the number that it has swapped with
     */
    public Integer moveAgent(int agentX, int agentY, int squareX, int squareY) {
        Integer movedValue = null;
        if (isSquareNextToSquare(agentX, agentY, squareX, squareY) 
                && isSquareAgent(agentX,agentY)
                && isSquareMoveableTo(squareX, squareY)) {
            movedValue = boardArray[squareY][squareX];
            boardArray[squareY][squareX] = boardArray[agentX][agentY];
            boardArray[agentY][agentX] = movedValue;
        }
        return movedValue;
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
    
    private boolean isSquareMoveableTo(int x, int y){
        boolean moveableTo = false;
        if (isSquareWithinBounds(x, y)){
            if (boardArray[x][y] != null 
                    && boardArray[x][y] != size * size){
                moveableTo = true;
            }
        }
        return moveableTo;
    }
    
    private boolean isSquareAgent (int x, int y){
        if (boardArray[y][x] == size * size){
            return true;
        }else{
            return false;
        }
    }
}
