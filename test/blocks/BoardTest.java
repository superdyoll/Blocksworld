/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lloyd
 */
public class BoardTest {

    public BoardTest() {
    }

    /**
     * Test of setValue method, of class Board.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int x = 0;
        int y = 0;
        int value = 1;
        Board instance = new Board(3);
        boolean expResult = true;
        boolean result = instance.setValue(x, y, value);
        System.out.println(instance);
        assertEquals(expResult, result);
    }

    /**
     * Test of getValue method, of class Board.
     */
    @Test
    public void testGetValue() {

        try {
            System.out.println("getValue");
            int x = 0;
            int y = 0;
            Board instance = new Board(3);
            Integer[][] state = instance.getState();
            state[0][0] = 1;
            
            int expResult = 1;
            int result = instance.getValue(x, y);
            System.out.println(instance);
            assertEquals(expResult, result);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

    }

    /**
     * Test of getState method, of class Board.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Board instance = new Board(3);
        Integer[][] expResult = new Integer[3][3];
        for (int x = 0; x < expResult[0].length; x++) {
            for (int y = 0; y < expResult.length; y++) {
                expResult[x][y] = 0;
            }
        }
        Integer[][] result = instance.getState();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of isEqual method, of class Board.
     */
    @Test
    public void testequals() {
        try {
            System.out.println("isEqual");
            Board otherBoard = new Board(3);
            Board instance = new Board(3);
            
            Integer[][] state = instance.getState();

            state[0][0] = 9;
            state[0][1] = 1;
            
            state = otherBoard.getState();
            state[0][0] = 9;
            state[0][1] = 1;

            boolean expResult = true;
            boolean result = instance.equals(otherBoard);
            
            System.out.println("Original square");
            System.out.println(instance);
            
            System.out.println("Expected square");
            System.out.println(otherBoard);
            assertEquals(expResult, result);

        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

    /**
     * Test of moveAgent method, of class Board.
     */
    @Test
    public void testMoveAgent() {
        System.out.println("moveAgent");
        int squareX = 1;
        int squareY = 0;

        Board instance = new Board(3);
        
        Integer[][] state = instance.createEmptyState();

        state[0][0] = 9;
        state[0][1] = 1;

        Integer[][] expectedFinalState = instance.createEmptyState();

        expectedFinalState[0][1] = 9;
        expectedFinalState[0][0] = 1;

        try {
            //Test moving to specific square within range
            System.out.println("Test moving to square");
            instance = new Board(state);

            System.out.println(instance);

            Integer expResult = 1;
            Integer result = instance.moveAgent(squareX, squareY);

            System.out.println(instance);

            assertEquals(expResult, result);

            assertArrayEquals(expectedFinalState, instance.getState());

            //test moving to specific square out of range
            System.out.println("Test moving to square out of range");
            instance = new Board(state);

            System.out.println(instance);

            expResult = null;
            result = instance.moveAgent(squareX + 2, squareY + 2);

            System.out.println(instance);

            assertEquals(expResult, result);

            //test moving with direction
            System.out.println("Test moving in direction");

            state = instance.createEmptyState();

            state[0][0] = 9;
            state[0][1] = 1;

            instance = new Board(state);

            System.out.println(instance);

            expResult = 1;
            result = instance.moveAgent(Board.Direction.RIGHT);

            System.out.println(instance);

            assertEquals(expResult, result);

            assertArrayEquals(expectedFinalState, instance.getState());
            
            //test second move
            state = instance.createEmptyState();

            state[0][0] = 9;
            state[0][1] = 1;
            state[1][1] = 2;
            
            expectedFinalState = instance.createEmptyState();
            
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

}
