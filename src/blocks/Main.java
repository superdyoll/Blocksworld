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
public class Main {

    public static void main(String[] args) {
        Main mainClass = new Main();
        mainClass.run();
    }

    public void run() {
        try {
            Board startState = new Board(3);
            startState.getState()[2][0] = 1;
            startState.getState()[2][1] = 2;
            startState.getState()[1][1] = 9;

            Board endState = new Board(3);
            endState.getState()[2][0] = 1;
            endState.getState()[1][0] = 2;
            endState.getState()[2][2] = 9;
            Search searchDFS = new DepthFirst(startState, endState);
            outputSearch(searchDFS);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Board startState = new Board(3);
            startState.getState()[2][0] = 1;
            startState.getState()[2][1] = 2;
            startState.getState()[1][1] = 9;

            Board endState = new Board(3);
            endState.getState()[2][0] = 1;
            endState.getState()[1][0] = 2;
            endState.getState()[2][2] = 9;

            Search searchBFS = new BredthFirst(startState, endState);
            outputSearch(searchBFS);

        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            Board startState = new Board(3);
            startState.getState()[2][0] = 1;
            startState.getState()[2][1] = 2;
            startState.getState()[1][1] = 9;

            Board endState = new Board(3);
            endState.getState()[2][0] = 1;
            endState.getState()[1][0] = 2;
            endState.getState()[2][2] = 9;

            Search searchIDS = new IterativeDeepening(startState, endState);
            outputSearch(searchIDS);
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void outputSearch(Search theSearch) throws Exception {
        ArrayList<Node> returnedNodes = theSearch.performSearch();

        //System.out.println("The route is as such");
        //for (Node returnedNode : returnedNodes) {
        //   System.out.println(returnedNode.getDirection());
        //}
        System.out.println("");
        System.out.println("It took " + theSearch.getDepth() + " moves");
        System.out.println("Time Complexity " + theSearch.getNodesExpanded());
        System.out.println("Space Complexity " + theSearch.getNodesStored());
    }
}
