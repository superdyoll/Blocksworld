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
public class Main {
    public static void main(String[] args) {
        Board startState = new Board(3);
        startState.getState()[2][0] = 1;
        startState.getState()[2][1] = 2;
        startState.getState()[2][2] = 9;
        
        Board endState = new Board(3);
        endState.getState()[2][0] = 1;
        endState.getState()[1][0] = 2;
        endState.getState()[2][2] = 9;
        DepthFirst searchDFS = new DepthFirst(startState, endState);
        
        ArrayList<Node> returnedNodes = searchDFS.performSearch();
        
        int finalDepth = 0;
        int timeComplexity = 0;
        int spaceComplexity = 0;
        for (Node returnedNode : returnedNodes) {
            System.out.print(returnedNode.getDirection());
            if (returnedNode.getDepth() > finalDepth){
                finalDepth = returnedNode.getDepth();
            }
        }
        System.out.println("The deepest depth was " + finalDepth);
    }
}
