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
public class IterativeDeepening extends Search {

    public IterativeDeepening(Board startState, Board endState) {
        super(startState, endState);
    }

    @Override
    protected ArrayList<Node> performSearch(Node startNode) {
        Search DFS = new DepthFirst(startState, endState, 1);
        int maxDepth = 1;
        ArrayList<Node> returnedList = null;
        try {
            do {
                returnedList = DFS.performSearch();
                setDepth(DFS.getDepth());
                setNodesExpanded(DFS.getNodesExpanded());
                setNodesStored(DFS.getNodesStored());
                maxDepth++;
                System.out.println("Depth " + maxDepth);
                DFS = new DepthFirst(startState, endState, maxDepth);
            }while(returnedList == null);
        } catch (Exception ex) {
            Logger.getLogger(IterativeDeepening.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnedList;
    }

}
