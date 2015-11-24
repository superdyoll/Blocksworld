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
public class DepthFirst extends Search{
    
    /**
     *
     * @param startState
     * @param endState
     */
    public DepthFirst(Board startState, Board endState) {
        super(startState, endState);
    }

    /**
     *
     * @param startNode
     * @return
     */
    protected ArrayList<Node> performSearch(Node startNode){
        System.out.println("This node is going " + startNode.getDirection());
        ArrayList<Node> returnArray = new ArrayList<>();
        if (startNode.getState().equals(endState)){
            returnArray.add(startNode);
        }else{
            if (startNode.setChildren() > 0){
                for (Node nextNode : startNode.getChildren()) {
                    ArrayList <Node> searchResults = performSearch(nextNode);
                    if (searchResults != null){
                        returnArray.addAll(searchResults);
                        break;
                    }
                }
            }else{
                return null;
            }
        }
        return returnArray;
    }
    

    
    
}
