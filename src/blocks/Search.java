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
    protected int nodesExpanded = 0;
    protected int nodesStored = 0;
    protected int depth = 0;
    
    /**
     *
     * @param startState
     * @param endState
     */
    public Search (Board startState, Board endState){
        this.startState = startState;
        this.endState = endState;
    }
    
    public ArrayList<Node> performSearch() throws Exception{
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

    /**
     * @return the nodesExpanded
     */
    public int getNodesExpanded() {
        return nodesExpanded;
    }

    /**
     * @param nodesExpanded the nodesExpanded to set
     */
    public void setNodesExpanded(int nodesExpanded) {
        this.nodesExpanded = nodesExpanded;
    }

    /**
     * @return the nodesStored
     */
    public int getNodesStored() {
        return nodesStored;
    }

    /**
     * @param nodesStored the nodesStored to set
     */
    public void setNodesStored(int nodesStored) {
        this.nodesStored = nodesStored;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }
}
