/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author Lloyd
 */
public class AStar extends Search{

    public AStar(Board startState, Board endState) {
        super(startState, endState);
    }

    @Override
    protected ArrayList<Node> performSearch(Node startNode) throws Exception {
        
        Comparator<CostNode> comparator = new CostNodeComparator();
        PriorityQueue<CostNode> nodeQueue = new PriorityQueue<>(comparator);
        
        CostNode node = new CostNode(startNode, totalCost(startNode));
        
        nodeQueue.add(node);
        
        
        while(nodeQueue.peek() != null && !nodeQueue.peek().getState().equals(endState)){
            nodesExpanded++;
           
            CostNode removedNode = nodeQueue.poll();
            
            for (Node visitedNode : removedNode.getChildren()) {
                nodesStored++;
                CostNode newNode = new CostNode(visitedNode, totalCost(visitedNode));
                nodeQueue.add(newNode);
            }
            
        }
        
        depth = nodeQueue.peek().getDepth();
        return null;
    }
    
    protected int totalCost(Node currentNode){
        int totalCost = costSoFar(currentNode) + estimatedCost(currentNode);
        //System.out.println("Total cost: " + totalCost);
        return totalCost;
    }
    
    protected int costSoFar(Node currentNode){
        return currentNode.getDepth();
    }
    
    protected int estimatedCost(Node currentNode){
        return currentNode.getState().compareTo(endState);
    }
    
}
