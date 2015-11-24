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
public abstract class Search {

    protected Board startState;
    protected Board endState;
    
    /**
     *
     * @param startState
     * @param endState
     */
    public Search (Board startState, Board endState){
        this.startState = startState;
        this.endState = endState;
    }
    
    public ArrayList<Node> performSearch(){
        return performSearch(new Node(startState, null, 0));
    }
    
    protected abstract ArrayList<Node> performSearch(Node startNode);
    
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
