/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lloyd
 */
public class NodeTest {
    
    public NodeTest() {
    }

    /**
     * Test of getState method, of class Node.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Node instance = null;
        Board expResult = null;
        Board result = instance.getState();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getChildren method, of class Node.
     */
    @Test
    public void testGetChildren() {
        System.out.println("getChildren");
        Node instance = null;
        List<Node> expResult = null;
        List<Node> result = instance.getChildren();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addChild method, of class Node.
     */
    @Test
    public void testAddChild() {
        System.out.println("addChildren");
        Node child = null;
        Node instance = null;
        instance.addChild(child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChildren method, of class Node.
     */
    @Test
    public void testSetChildren() {
        System.out.println("setChildren");
        ArrayList<Node> children = null;
        Node instance = null;
        instance.setChildren(children);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDirection method, of class Node.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        Node instance = null;
        Board.Direction expResult = null;
        Board.Direction result = instance.getDirection();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
