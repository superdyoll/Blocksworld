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

    int maxDepth;

    /**
     *
     * @param startState
     * @param endState
     */
    public DepthFirst(Board startState, Board endState) {
        super(startState, endState);
        this.maxDepth = 0;
    }

    /**
     * max depth specifies how deep the search should go
     *
     * @param startState
     * @param endState
     * @param maxDepth
     */
    public DepthFirst(Board startState, Board endState, int maxDepth) {
        super(startState, endState);
        this.maxDepth = maxDepth;
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
            while (!endState.equals(stack.peekFirst().getState()) && stack.size() > 0) {

                // If it isn't we increase the nodes expanded and stored
                nodesExpanded++;
                nodesStored++;
                depth = stack.peekFirst().getDepth();

                // Add it to the output
                output.add(stack.peekFirst());

                Node removedNode = stack.removeFirst();
                
                if (maxDepth == 0 || depth < maxDepth) {
                    // Then add all children to the stack
                    for (Node visitedNode : removedNode.getChildren()) {
                        stack.addFirst(visitedNode);
                    }
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(DepthFirst.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (endState.equals(stack.peekFirst().getState())) {
            ArrayList list = new ArrayList(output);
            return list;
        } else {
            depth = -1;
            return null;
        }
    }
}
