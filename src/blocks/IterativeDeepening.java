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
public class IterativeDeepening extends Search {

    public IterativeDeepening(Board startState, Board endState) {
        super(startState, endState);
    }

    @Override
    protected ArrayList<Node> performSearch(Node startNode) throws Exception {
        Search DFS = new DepthFirst(startState, endState, 1);
        int maxDepth = 1;
        ArrayList<Node> returnedList = null;

        do {
            returnedList = DFS.performSearch();
            setDepth(DFS.getDepth());
            setNodesExpanded(DFS.getNodesExpanded()  + getNodesExpanded());
            setNodesStored(DFS.getNodesStored());
            maxDepth++;
            DFS = new DepthFirst(startState, endState, maxDepth);
        } while (returnedList == null);

        return returnedList;
    }

}
