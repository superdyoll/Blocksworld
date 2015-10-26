/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

/**
 *
 * @author Lloyd
 */
public class Node {
    
    private Integer content;
    private Node parent;
    private Node[] children;
    
    public Node (Integer content, Node parent){
        this.content = content;
        this.parent = parent;
    }

    /**
     * @return the content
     */
    public Integer getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(Integer content) {
        this.content = content;
    }

    /**
     * @return the parent
     */
    public Node getParent() {
        return parent;
    }

    /**
     * @return the children
     */
    public Node[] getChildren() {
        return children;
    }

    /**
     * @param children the children to set
     */
    public void setChildren(Node[] children) {
        this.children = children;
    }
    
    
}
