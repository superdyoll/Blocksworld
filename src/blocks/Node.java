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

    public Node(Board currentState, Board.Direction direction) {
        this.state = currentState;
        this.direction = direction;
        state.moveAgent(this.direction);
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
    
    public void setChildren(Board board){
        ArrayList<Board.Direction> directions = board.findPossibleMoves();
        for (Board.Direction currentDirection : directions) {
            Node newNode = new Node(state, currentDirection);
            this.addChild(newNode);
        }
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

}
