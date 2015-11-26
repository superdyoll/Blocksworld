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
public class ProblemFactory {

    public Board[] getProblem(int difficulty) throws Exception {
        Board startState = new Board(4);
        Board endState = new Board(4);

        startState.getState()[1][1] = 3;
        startState.getState()[2][1] = 2;
        startState.getState()[3][2] = 1;

        startState.getState()[3][1] = 16;

        endState = doSomeMoves(startState, difficulty);

        Board[] boardArray = new Board[2];
        boardArray[0] = startState;
        boardArray[1] = endState;
        return boardArray;
    }

    protected Board doSomeMoves(Board startBoard, int noMoves) throws Exception {
        Search searchAStar;
        Board returnBoard;
        do {
            returnBoard = startBoard.clone();
            for (int i = 0; i < noMoves; i++) {
                Board.Direction randomDirection;
                ArrayList<Board.Direction> moves = returnBoard.findPossibleMoves();
                boolean isAllowed = false;
                do {
                    randomDirection = Board.Direction.randomDirection();
                    isAllowed = !moves.contains(randomDirection);
                } while (isAllowed);
                returnBoard.moveAgent(randomDirection);
            }
            searchAStar = new AStar(startBoard, returnBoard);
            searchAStar.performSearch();
        } while (searchAStar.getDepth() != noMoves);
        //System.out.println(noMoves + " PROBLEM GENERATED");
        return returnBoard;
    }

}
