/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lloyd
 */
public class Main {

    FileWriter writer;
    int MAX_DIFFICULTY = 20;
    
    public static void main(String[] args) {
        Main mainClass = new Main();
        mainClass.run();
    }

    public void run() {
        try {
            writer = new FileWriter("to"+MAX_DIFFICULTY+".csv");
            writer.append("NoNodes, BFS (Depth) , BFS (Time), BFS (Space),"
                    + "DFS (Depth) , DFS (Time), DFS (Space),"
                    + "IDS (Depth) , IDS (Time), IDS (Space),"
                    + "A*S (Depth) , A*S (Time), A*S (Space)\n");
            try {
                for (int difficulty = 1; difficulty <= MAX_DIFFICULTY; difficulty++) {
                    
                    System.out.println("Current Difficulty " + difficulty);
                    
                    ProblemFactory problems = new ProblemFactory();
                    Board[] level1 = problems.getProblem(difficulty);
                    Board startState = level1[0];
                    Board endState = level1[1];
                    writer.append("" + difficulty);
                    
                    try {
                        Search searchBFS = new BredthFirst(startState, endState);
                        outputSearch(searchBFS);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try {
                        Search searchDFS = new DepthFirst(startState, endState);
                        
                        outputSearch(searchDFS);
                        
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try {
                        Search searchIDS = new IterativeDeepening(startState, endState);
                        outputSearch(searchIDS);
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    try {
                        Search searchAStar = new AStar(startState, endState);
                        outputSearch(searchAStar);
                    } catch (Exception ex) {
                        Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    
                    writer.append("\n");
                    writer.flush();
                }
            } catch (Exception ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            writer.flush();
	    writer.close();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void outputSearch(Search theSearch) throws Exception {
        int sumSearch = 0, sumExpand = 0 , sumStored = 0, totalSearches = 0;
        for (int i = 0; i <= 50; i++) {
            theSearch.performSearch();
            sumSearch += theSearch.getDepth();
            sumExpand += theSearch.getNodesExpanded();
            sumStored += theSearch.getNodesStored();
            totalSearches ++;
        }
        int avgSearch = sumSearch / totalSearches;
        int avgExpand = sumExpand / totalSearches;
        int avgStored = sumStored / totalSearches;
        
        writer.append("," + avgSearch);
        writer.append("," + avgExpand);
        writer.append("," + avgStored);
    }
}
