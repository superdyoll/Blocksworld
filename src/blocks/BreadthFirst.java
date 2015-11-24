/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.ArrayList;

/**
 *
 * @author Lloyd
 */
public class BreadthFirst {
    private Board startState;
    private Board endState;

    public BreadthFirst(Board startState, Board endState) {
        this.startState = startState;
        this.endState = endState;
    }

    public ArrayList<Board.Direction> performSearch(Node startNode){
        if (startNode.getState().equals(endState)){
            ArrayList<Board.Direction> returnArray = new ArrayList<Board.Direction>();
            returnArray.add(startNode.getDirection());
            return returnArray;
        }
    }
    
    /**
     * @return the startState
     */
    public Board getStartState() {
        return startState;
    }

    /**
     * @return the endState
     */
    public Board getEndState() {
        return endState;
    }
    
    
}
