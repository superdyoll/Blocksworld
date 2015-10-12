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
    
    public Board (Integer [][] state) throws Exception{
        if(!setState(state)){
            throw new Exception("Input state not of right format");
        }
    }
    
    public Board (int size){
        this.size = size;
        boardArray = new Integer[size][size];
    }
    
    public boolean setValue (int x, int y, int value){
        boolean isSet = false;
        if (isSquareWithinRange(x, y)){
            if(value >= 0 && value < size * size){
                boardArray[x][y] = value;
                isSet = true;
            }
        }
        return isSet;
    }
    
    public int getValue (int x, int y){
        return boardArray[x][y];
    }
    
    private boolean setState (Integer [][] state){
        boolean isSet = false;
        if (state.length == state[0].length){
            boolean allowSet = true;
            for (Integer[] innerState : state) {
                for (Integer value : innerState) {
                    if (value > size*size || value < 0){
                        allowSet = false;
                    }
                }
            }
            if (allowSet){
                boardArray = state;
                isSet = true;
            }
        }
        return isSet;
    }
    
    public Integer[][] getState (){
        return boardArray;
    }
    
    public boolean isEqual(Board otherBoard){
        return Arrays.equals(otherBoard.getState(), this.getState());
    }
    
    
    public Integer moveAgent (int agentX, int agentY, int squareX, int squareY){
        Integer movedValue = null;
        if (isSquareNextToAgent(agentX,agentY, squareX,squareY)){
            movedValue = boardArray [squareX][squareY];
            boardArray[squareX][squareY] = boardArray[agentX][agentY];
            boardArray[agentX][agentY] = movedValue;
        }
        return movedValue;
    }
    
    private boolean isSquareNextToAgent (int agentX, int agentY, int squareX, int squareY){
        boolean isNextToSquare = false;
        if (isSquareWithinRange (agentX, agentY) && isSquareWithinRange(squareX, squareY)){
            int xDiff = Math.abs(agentX - squareX);
            int yDiff = Math.abs(agentY - squareY);
            if ((xDiff == 0 && yDiff == 1) || (xDiff == 1 && yDiff == 0)){
                isNextToSquare = true;
            }
        }
        return isNextToSquare;
    }
    
    private boolean isSquareWithinRange (int x, int y){
        boolean inSquare = false;
        if (x >= 0 && x < size){
            if (y >= 0 && y < size){
                inSquare = true;
            }
        }
        return inSquare;
    }
}
