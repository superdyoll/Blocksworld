/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class BredthFirst extends Search{

    public BredthFirst(Board startState, Board endState) {
        super(startState, endState);
    }

    @Override
    protected ArrayList<Node> performSearch(Node startNode) {
        Queue <Node>output = new LinkedList<>();
        Queue <Node> queue = new LinkedList<>();
        queue.add(startNode);
        
        while(!endState.equals(queue.element().getState())){
            nodesExpanded++;
            nodesStored++;
            depth = queue.element().getDepth();
            try {
                output.add(queue.element());
                for (Node visitedNode : queue.remove().getChildren()) {
                    queue.add(visitedNode);
                }
            } catch (Exception ex) {
                Logger.getLogger(DepthFirst.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ArrayList list = new ArrayList(output);
        return list;
    }
    
}
