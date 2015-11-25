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
public class DepthFirst extends Search {

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
    @Override
    protected ArrayList<Node> performSearch(Node startNode) {
        // Make a queue for the output commands
        Queue output = new LinkedList();

        // The stack will hold the nodes still to be visited
        Deque<Node> stack = new ArrayDeque<>();

        // Add the start node
        stack.addFirst(startNode);
        try {
            // As we visit each state we check it's not the goal state
            while (!endState.equals(stack.peekFirst().getState())) {
                
                // If it isn't we increase the nodes expanded and stored
                nodesExpanded++;
                nodesStored++;
                depth = stack.peekFirst().getDepth();

                // Add it to the output
                output.add(stack.peekFirst());
                
                // Then add all children to the stack
                for (Node visitedNode : stack.removeFirst().getChildren()) {
                    stack.addFirst(visitedNode);
                }

            }
        } catch (Exception ex) {
            Logger.getLogger(DepthFirst.class.getName()).log(Level.SEVERE, null, ex);
        }
        ArrayList list = new ArrayList(output);
        return list;
    }
}
