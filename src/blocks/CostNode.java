/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

/**
 *
 * @author Lloyd
 */
public class CostNode extends Node implements Comparable{

    protected int cost;
    
    public CostNode(Board currentState, Board.Direction direction, int depth, int cost) throws Exception {
        super(currentState, direction, depth);
        this.cost = cost;
    }
    
    /**
     *
     * @param node
     * @param cost
     * @throws Exception
     */
    public CostNode(Node node, int cost) throws Exception{
        super(node);
        this.cost = cost;
    }

    @Override
    public int compareTo(Object o) {
        CostNode otherNode = (CostNode) o;
        return this.getCost() - otherNode.getCost();
    }

    /**
     * @return the cost
     */
    public int getCost() {
        return cost;
    }

    
}
