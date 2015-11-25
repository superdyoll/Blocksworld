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
    protected ArrayList<Node> performSearch(Node startNode) throws Exception {
        // Make a queue for the output commands
        Queue<Node> output = new LinkedList<>();

        // The stack will hold the nodes still to be visited
        Deque<Node> stack = new ArrayDeque<>();

        // Add the start node
        stack.addFirst(startNode);

        Node currentNode = startNode;

        // As we visit each state we check it's not the goal state
        while (currentNode != null  && stack.size() > 0 && !endState.equals(currentNode.getState())) {

            // If it isn't we increase the nodes expanded and stored
            nodesExpanded++;
            
            depth = stack.peekFirst().getDepth();

            if (output.size() < depth) {
                // Add it to the output
                output.add(stack.peekFirst());
                nodesStored++;
            } else if (output.size() > 0) {
                output.remove();
                nodesStored--;
            }

            Node removedNode = stack.removeFirst();

            if (maxDepth == 0 || depth < maxDepth) {
                // Then add all children to the stack
                for (Node visitedNode : removedNode.getChildren()) {
                    stack.addFirst(visitedNode);
                }
            }
            
            currentNode = stack.peekFirst();

        }

        if (stack.peekFirst() == null){
            depth = -1;
            return null;
        } else if (endState.equals(stack.peekFirst().getState())) {
            ArrayList list = new ArrayList(output);
            return list;
        } else {
            depth = -1;
            return null;
        }
    }
}
