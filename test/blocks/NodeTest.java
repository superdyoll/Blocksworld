/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

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
     * Test of getContent method, of class Node.
     */
    @Test
    public void testGetContent() {
        System.out.println("getContent");
        Node instance = null;
        Integer expResult = null;
        Integer result = instance.getContent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setContent method, of class Node.
     */
    @Test
    public void testSetContent() {
        System.out.println("setContent");
        Integer content = null;
        Node instance = null;
        instance.setContent(content);
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
     * Test of addChildren method, of class Node.
     */
    @Test
    public void testAddChildren() {
        System.out.println("addChildren");
        Node child = null;
        Node instance = null;
        instance.addChildren(child);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setChildren method, of class Node.
     */
    @Test
    public void testSetChildren() {
        System.out.println("setChildren");
        List<Node> children = null;
        Node instance = null;
        instance.setChildren(children);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
