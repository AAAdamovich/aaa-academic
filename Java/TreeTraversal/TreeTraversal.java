/* Anton Adamovich
 * TreeTraversal.java for Assignment 6 - "Tree Traversal"
 * Prof. Chuck Herbert - CSCI-211 - Community College of Philadelphia
 * Created: 07-DEC-2017 - Last Edited: 22-MAR-2017
 * Description: 
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/
package treetraversal;

public class TreeTraversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        BT mainTree = new BT();
        mainTree.add(new Integer(10));
        mainTree.add(new Integer(5));
        mainTree.add(new Integer(0));
        mainTree.add(new Integer(12));
        mainTree.add(new Integer(4));
        
        System.out.println("Tree size is: " + mainTree.getSize());
        
        System.out.println("\nTree height is: " + mainTree.getHeight());
        
        System.out.println("\nPre-Order Traversal: ");
        mainTree.preOrder(mainTree.getRoot());
        
        System.out.println("\nIn-Order Traversal: ");
        mainTree.inOrder(mainTree.getRoot());
        
        System.out.println("\nPost-Order Traversal: ");
        mainTree.postOrder(mainTree.getRoot());
        
        System.out.println("\nIs \"-1\" in the tree? ");
        System.out.println(mainTree.find(-1));
        
        System.out.println("\nIs \"0\" in the tree? ");
        System.out.println(mainTree.find(0));
        
        System.out.println("\nThe maximum value in the tree is " + (mainTree.max().toString()));
        
        System.out.println("\nThe minimum value in the tree is " + (mainTree.min().toString()));
             
    } 
}