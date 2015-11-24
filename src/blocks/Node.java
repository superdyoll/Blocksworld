/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blocks;

import java.util.List;

/**
 *
 * @author Lloyd
 */
public class Node {
    
    
    private Integer content;
    private List<Node> children;
    
    public Node (Integer content){
        this.content = content;
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
     * @return the children
     */
    public List<Node> getChildren() {
        return children;
    }
    
    public void addChildren(Node child){
        this.children.add(child);
    }

    /**
     * @param children the children to set
     */
    public void setChildren(List<Node> children) {
        this.children = children;
    }
    
    
}
