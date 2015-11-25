/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            nodesExpanded++;
            nodesStored++;
        }else{
            try {
                if (startNode.setChildren() > 0){
                    ArrayList<Node> children = startNode.getChildren();
                    for (Node nextNode : children) {
                        ArrayList <Node> searchResults = performSearch(nextNode);
                        if (searchResults != null){
                            returnArray.add(startNode);
                            returnArray.addAll(searchResults);
                            nodesExpanded++;
                            nodesStored++;
                            break;
                        }
                    }
                }else{
                    return null;
                }
            } catch (Exception ex) {
                Logger.getLogger(DepthFirst.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return returnArray;
    }
    

    
    
}
