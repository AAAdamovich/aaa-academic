/* Anton Adamovich
 * BT.java for Assignment 6 - "Tree Traversal"
 * Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
 *  Originally written for Prof. Meistering's Advanced Topics in CS at HGP
 * Created: 10-OCT-2013 - Last Edited: 22-MAR-2018
 *  Edited 15-NOV-2017 - Changed visibility of "left" and "right" to public
 *  Edited 07-DEC-2017 - Added min/max methods, modified traversal methods
 *  Edited 20-MAR-2018 - Reverted visibility of "left" and "right to private
 * Description: A Binary Search Tree (BST) that uses integers as data in each
 *  of its nodes, specified by "BTNode.java"
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/
package treetraversal;

public class BT {

    // ======================== INSTANCE VARIABLES ========================= //
    
    protected BTNode root;
    private int size;
    private int height;

    // =========================== CONSTRUCTORS ============================ //
    
    // Default "null" constructor
    public BT() {
        root = null;
        size = 0;
        height = 0;
    } // End constructor
    
    // Forms a tree from an array of primitive integers
    public BT(int[] array){
        this();
        // For-each to iterate array, extract elements, and add on to tree
        for(int element : array){
            this.add(new Integer(element));
        }
    } // End constructor
    
    // ============================== METHODS ============================== //
    
    /**
     * Adds a new node to this tree using the data in toBeAdded. 
     *
     * @param toBeAdded The Integer object that is to be inserted into this 
     *  tree as a node
     * 
     * @return True if insertion was successful, false otherwise
     */
    public boolean add(Integer toBeAdded) {
        if (toBeAdded != null) {
            // If the tree is empty, the node to be added becomes the root node
            if (root == null) {
                root = new BTNode(toBeAdded);
                // Size and height need to be updated
                size++;
                height++;
                return true;
            }
            // If the tree is not empty, a traversal is required to place the 
            // new node in its proper place
            else{
                addHelper(toBeAdded, root, 1);
            }
            return true;
        } 
        // Null objects cannot be added to the tree
        else {
            return false;
        }
    } // End method

    /**
     * Recursively traverses this tree to find an appropriate leaf node to attach 
     * toBeAdded onto. 
     * PreCondition: nextNode and toBeAdded are not null
     *
     * @param toBeAdded The node that will be inserted into the tree
     * @param nextNode The root node of the subtree the method is currently
     * exploring
     * @param currentHeight The level (height) of the master (highest parent) tree
     * that this method is currently exploring
     */
    private void addHelper(Integer toBeAdded, BTNode nextNode, int currentHeight){
        // Values LESS THAN the value of the root node go left
        if (nextNode.getValue() > toBeAdded){
            // Add left
            if (nextNode.getLeft() != null) {
                nextNode = nextNode.getLeft();
                // Algorithim is advancing one level down the tree, update currentHeight
                currentHeight++;
                addHelper(toBeAdded, nextNode, currentHeight);
            } 
            else{
                // Leaf node found, insert new node and iterate size
                nextNode.setLeft(new BTNode(toBeAdded));
                size++;
                // If the addition of a new node has increased the height of the 
                // tree, the private variable height must be updated
                if(currentHeight >= height){
                    // Becuase this method only ever adds one new node at a time,
                    // it is safe to iterate height only by 1
                    height++;
                }
            }
        } 
        
        else {
            // Values GREATER THAN the value of the root node go right
            if (nextNode.getValue() < (toBeAdded)) {
                // Add right
                if (nextNode.getRight() != null) {
                    nextNode = nextNode.getRight();
                    // Algorithim is advancing one level down the tree, update currentHeight
                    currentHeight++;
                    addHelper(toBeAdded, nextNode, currentHeight);
                } 
                else {
                    // Leaf node found, insert new node and iterate size
                    nextNode.setRight(new BTNode(toBeAdded));
                    size++;
                    // If the addition of a new node has increased the height of the 
                    // tree, the private variable height must be updated
                    if (currentHeight >= height) {
                        // Becuase this method only ever adds one new node at a time,
                        // it is safe to iterate height only by 1
                        height++;
                    }
                }
            }
            else{
                // This case: (nextNode.getValue() == toBeAdded)
                // hence newNode already exists in tree
                // Currently, this event is not handled
            }
            
        }
    } // End method

    /** Searches the tree for the presence of a key value within one of 
     * the nodes of the tree. 
     * 
     * @param key The query that dictates the search
     * @return True if key exists in the tree, false otherwise
     */
    public boolean find(Integer key){
        if (key != null) {
            // If the tree is empty and the key is not null, it is impossible 
            // for the key to be in this tree
            if (root == null) {
                return false;
            }
            // If the tree is not empty, a traversal is required to find the key
            else{
                return (findHelper(key, root)); 
            }
        } 
        // A null key is assumed to exist in an empty tree, otherwise, it is 
        // impossible for a null key to exist in a non-empty tree
        else {
            return (root == null);
        }    
    } // End method
    
    /**
     * Recursively traverses this tree to determine whether or not a key value
     * exists in one of the nodes of the tree.
     * PreCondition: nextNode is not null
     *
     * @param key The value that is being searched for
     * @param nextNode The root node of the subtree the method is currently
     * exploring
     */
    private boolean findHelper(Integer key, BTNode nextNode){
        // Key value found in tree, return true and exit
        if (nextNode.getValue().equals(key)) {
            return true;
        } 
        else{
            // Values less than the value of the root node go left
            if (nextNode.getValue() > key) {
                // Go left
                if (nextNode.getLeft() != null) {
                    // Advancing one level down the tree, continue search
                    return (findHelper(key, nextNode.getLeft()));
                }
                // If a leaf node (no children) was found, skip to bottom of method
            } 
            // Values greater than the value of the root node go right
            else {
                // Go right
                if (nextNode.getRight() != null) {
                    // Advancing one level down the tree, continue search
                    return (findHelper(key, nextNode.getRight()));
                }
            }
        }
        // If the routine reaches this part of the method, the key was never found
        return false;
    } // End method
    
    // \/ Generic getters and setters for all fields in "BT.java" \/
  
    public int getHeight(){
        return height;
    }
    
    public BTNode getRoot() {
        return root;
    }

    public int getSize(){
        return size;
    }
    
    // /\ Generic getters and setters for all fields in "BT.java" /\

    /** Traverses the tree in the "inOrder" style (LNR) and prints the contents
     * of each node that is visited along the traversal. To traverse an entire
     * tree, initially set "nextNode" to the root of the tree. 
     * 
     * @param nextNode The root node of the subtree the method is currently
     * exploring
     */
    public void inOrder(BTNode nextNode) {
        if (nextNode != null) {
            inOrder(nextNode.getLeft());
            System.out.println(nextNode.getValue());
            inOrder(nextNode.getRight());
        }
    } // End method
    
    /** Finds the largest integer within the value fields of the tree. 
     * 
     * @return The arithmetic maximum of all the integers present within the 
     *  tree. Null is returned if the tree is empty. 
     */
    public Integer max(){
        if (root != null) {
            return maxHelper(root);
        } 
        else {
            // Tree is empty, throw error
            return null;
        }   
    } // End method
    
    /**
     * Recursively traverses this tree to locate the largest integer value within. 
     * PreCondition: currentNode is not null
     *
     * @param currentNode The root node of the subtree the method is currently
     * exploring
     * 
     * @return The "largest" value within the tree. This is determined by 
     * retrieving the rightmost leaf node. 
     */
    private Integer maxHelper(BTNode currentNode){
        if(currentNode.getRight() == null){
            // Rightmost leaf mode was found, this is the maximum value
            return currentNode.getValue();
        }
        else{
            // Leaf node not found yet, continue
            return maxHelper(currentNode.getRight());
        }
    } // End method
    
    /** Finds the smallest integer within the value fields of the tree. 
     * 
     * @return The arithmetic minimum of all the integers present within the 
     *  tree. Null is returned if the tree is empty. 
     */
    public Integer min(){
        if (root != null) {
            return minHelper(root);
        } 
        else {
            // Tree is empty, throw error
            return null;
        }   
    } // End method
    
    /**
     * Recursively traverses this tree to locate the smallest integer value within. 
     * PreCondition: currentNode is not null
     *
     * @param currentNode The root node of the subtree the method is currently
     * exploring
     * 
     * @return The "smallest" value within the tree. This is determined by 
     * retrieving the leftmost leaf node. 
     */
    private Integer minHelper(BTNode currentNode){
        if(currentNode.getLeft() == null){
            // Bottom-leftmost leaf mode was found, this is the minimum value
            return currentNode.getValue();
        }
        else{
            // Leaf node not found yet, continue
            return minHelper(currentNode.getLeft());
        }
    } // End method
    
    /** Traverses the tree in the "postOrder" style (LRN) and prints the contents
     * of each node that is visited along the traversal. To traverse an entire
     * tree, initially set "nextNode" to the root of the tree. 
     * 
     * @param nextNode The root node of the subtree the method is currently
     * exploring
     */
    public void postOrder(BTNode nextNode) {
        if (nextNode != null) {
            postOrder(nextNode.getLeft());
            postOrder(nextNode.getRight());
            System.out.println(nextNode.getValue());
        }
    } // End method
    
    /** Traverses the tree in the "preOrder" style (NLR) and prints the contents
     * of each node that is visited along the traversal. To traverse an entire
     * tree, initially set "nextNode" to the root of the tree. 
     * 
     * @param nextNode The root node of the subtree the method is currently
     * exploring. 
     */
    public void preOrder(BTNode nextNode) {
        if (nextNode != null) {
            System.out.println(nextNode.getValue());
            preOrder(nextNode.getLeft());
            preOrder(nextNode.getRight());
        }
    } // End method
}// End Class