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

    private Integer[][] createEmptyState(int size) {
        Integer[][] state = new Integer[3][3];

        for (int y = 0; y < size; y++) {
            for (int x = 0; x < size; x++) {
                state[y][x] = 0;
            }
        }

        return state;
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
            Integer[][] state = createEmptyState(3);
            state[0][0] = 1;
            Board instance = new Board(state);
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
        Integer[][] result = instance.getState();

        assertArrayEquals(expResult, result);
    }

    /**
     * Test of isEqual method, of class Board.
     */
    @Test
    public void testIsEqual() {
        try {
            System.out.println("isEqual");
            Integer[][] state = createEmptyState(3);

            state[0][0] = 9;
            state[0][1] = 1;

            Board otherBoard = new Board(state);
            Board instance = new Board(state);

            boolean expResult = true;
            boolean result = instance.isEqual(otherBoard);
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

        Integer[][] state = createEmptyState(3);

        state[0][0] = 9;
        state[0][1] = 1;

        Integer[][] expectedFinalState = createEmptyState(3);

        expectedFinalState[0][1] = 9;
        expectedFinalState[0][0] = 1;

        Board instance;
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

            state = createEmptyState(3);

            state[0][0] = 9;
            state[0][1] = 1;

            instance = new Board(state);

            System.out.println(instance);

            expResult = 1;
            result = instance.moveAgent(Board.Direction.RIGHT);

            System.out.println(instance);

            assertEquals(expResult, result);

            assertArrayEquals(expectedFinalState, instance.getState());
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }

}
