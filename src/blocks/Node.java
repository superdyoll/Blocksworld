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
public class Node {

    private Board state;
    private Board.Direction direction;
    private ArrayList<Node> children;
    private Boolean visited;
    private int depth;

    public Node(Board currentState, Board.Direction direction, int depth) {
        this.state = currentState;
        this.direction = direction;
        this.depth = depth;
        if (direction != null){
            state.moveAgent(this.direction);
        }
    }

    /**
     * @return the state
     */
    public Board getState() {
        return state;
    }

    /**
     * @return the children
     */
    public ArrayList<Node> getChildren() {
        return children;
    }

    public void addChild(Node child) {
        this.children.add(child);
    }
    
    public int setChildren(){
        return setChildren(this.state);
    }
    
    public int setChildren(Board board){
        ArrayList<Board.Direction> directions = board.findPossibleMoves();
        for (Board.Direction currentDirection : directions) {
            Node newNode = new Node(state, currentDirection, depth + 1);
            this.addChild(newNode);
        }
        return this.children.size();
    }

    /**
     * @return the direction
     */
    public Board.Direction getDirection() {
        return direction;
    }

    /**
     * @return the visited
     */
    public Boolean isVisited() {
        return visited;
    }

    /**
     * @param visited the visited to set
     */
    public void setVisited(Boolean visited) {
        this.visited = visited;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

}
