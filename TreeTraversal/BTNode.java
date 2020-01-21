/* Anton Adamovich
 * BTNode.java for Assignment 6 - "Tree Traversal"
 * Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
 *  Originally written for Prof. Meistering's Advanced Topics in CS at HGP
 * Created: 10-OCT-2013 - Last Edited: 20-MAR-2018
 *  Edited 15-NOV-2017 - Changed visibility of "left" and "right" to public
 *  Edited 20-MAR-2018 - Reverted visibility of "left" and "right to private
 * Description: Forms the node structure for the "BT.java" class, which is a 
 *  Binary Search Tree (BST) that uses integers as data. 
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package treetraversal;

public class BTNode {

    private Integer value;
    private BTNode left;
    private BTNode right;

    // "Full" constructor when all fields are specified
    public BTNode(Integer value, BTNode left, BTNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
    
    // Used for root or leaf nodes where no children are specified
    public BTNode(Integer value) {
        this(value, null, null);
    }
    
    // Default "null" constructor
    public BTNode(){
        this(null, null, null);
    }
    
    // \/ Generic getters and setters for all private fields in BTNode \/
    
    public BTNode getLeft() {
        return left;
    }

    public void setLeft(BTNode left) {
        this.left = left;
    }

    public BTNode getRight() {
        return right;
    }

    public void setRight(BTNode right) {
        this.right = right;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
} // End class