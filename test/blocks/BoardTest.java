/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lloyd
 */
public class BoardTest {

    public BoardTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setValue method, of class Board.
     */
    @Test
    public void testSetValue() {
        System.out.println("setValue");
        int x = 0;
        int y = 0;
        int value = 0;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.setValue(x, y, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValue method, of class Board.
     */
    @Test
    public void testGetValue() {
        System.out.println("getValue");
        int x = 0;
        int y = 0;
        Board instance = null;
        int expResult = 0;
        int result = instance.getValue(x, y);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getState method, of class Board.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Board instance = null;
        Integer[][] expResult = null;
        Integer[][] result = instance.getState();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEqual method, of class Board.
     */
    @Test
    public void testIsEqual() {
        System.out.println("isEqual");
        Board otherBoard = null;
        Board instance = null;
        boolean expResult = false;
        boolean result = instance.isEqual(otherBoard);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of moveAgent method, of class Board.
     */
    @Test
    public void testMoveAgent() {
        System.out.println("moveAgent");
        int agentX = 0;
        int agentY = 0;
        int squareX = 1;
        int squareY = 0;
        Integer[][] state = new Integer[3][3];

        for (Integer[] state1 : state) {
            for (Integer state2 : state1) {
                state2 = 0;
            }
        }

        state[0][0] = 9;
        state[0][1] = 1;

        Integer[][] expectedFinalState = state.clone();

        expectedFinalState[0][1] = 9;
        expectedFinalState[0][0] = 1;

        Board instance;
        try {
            instance = new Board(state);

            Integer expResult = 1;
            Integer result = instance.moveAgent(agentX, agentY, squareX, squareY);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
            assertArrayEquals(expectedFinalState, state);
        } catch (Exception ex) {
            Logger.getLogger(BoardTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
