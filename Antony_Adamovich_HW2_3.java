/* Antony Adamovich
*  MinMaxMatrix.java for Homework #2
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 14-OCT-2018 - Last Edited: 14-OCT-2018
*  Description: Program finds the minimum and maximum arithmetic sums possible
*    by combining four adjacent "nodes" from a 4x4 matrix
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   See attached README file
*/

package minmaxmatrix;

import java.util.LinkedList;

public class Antony_Adamovich_HW2_3 {

    /**
     * Acquires all possible adjacent nodes that are valid for a arithmetic 
     * summation. A node cannot be linked to a previously linked node, and the
     * matric does not "wrap around."
     * 
     * @param source The node from which links will be determined. 
     * @param lastNode The node linked to source, this will be excluded from the
     *  list of possible nodes to link. 
     * @return A list of possible nodes that source can be linked to
     */
    private static LinkedList<Coordinate> getMoves(Coordinate source, Coordinate lastNode){
        // The length of rows/columns in the matrix being examined
        int MATRIX_N = 4;
        Coordinate temp;
        // A list of the possible moves to be taken from source
        LinkedList<Coordinate> possibleNodes = new LinkedList<>();

        /* If there is no last move, for example the first node in routine or
        *  lastNode is set to null, all possiblilites are explored. Temp is 
        *  shifted to represent a move, then compared against lastNode. 
        *  If the shifted temp is equal to lastNode, this means the shift
        *  represented by temp is an illegal move, and not to be added to 
        *  possibleNodes. The bounds of the matrix being operated on are also 
        *  checked. It is assumed the matrix is an n x n type. 
        */
        // RIGHT
        temp = source.deepCopy();
        temp.right();
        if ((lastNode == null || !temp.equals(lastNode)) && !temp.isOutOfBounds(MATRIX_N)) {
            possibleNodes.add(temp);
        }
        // LEFT
        temp = source.deepCopy();
        temp.left();
        if ((lastNode == null || !temp.equals(lastNode)) && !temp.isOutOfBounds(MATRIX_N)) {
            possibleNodes.add(temp);
        }
        // UP
        temp = source.deepCopy();
        temp.up();
        if ((lastNode == null || !temp.equals(lastNode)) && !temp.isOutOfBounds(MATRIX_N)) {
            possibleNodes.add(temp);
        }
        // DOWN
        temp = source.deepCopy();
        temp.down();
        if ((lastNode == null || !temp.equals(lastNode)) && !temp.isOutOfBounds(MATRIX_N)) {
            possibleNodes.add(temp);
        }
        return possibleNodes;
    }
    
    public static void main(String[] args) {
        // The grid on which the min/max will be determined
        final int[][] BOARD = { {8, 15, 6, 9}, 
                                {14, 13, 2, 18}, 
                                {20, 19, 18, 5}, 
                                {3, 15, 17, 6}};
        // Default values for min/max
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        // Represents the sum of four nodes in BOARD
        int currentChain = 0;
        Coordinate node0;
        
        // Iterate over entire board
        for(int i = 0; i < BOARD.length; i++){
            for(int j = 0; j < BOARD[i].length; j++){
                // Each node in the board is examined for all possible chains
                // orginiating from that particular node. 
                // Step 0: Node subroutine starts here
                node0 = new Coordinate(i, j);
                for(Coordinate node1 : getMoves(node0, null)){
                   // Step 1
                    for(Coordinate node2 : getMoves(node1, node0)){
                        // Step 2
                        for(Coordinate node3 : getMoves(node2, node1)){
                            // Step 3 : The 4-node chain is summed
                            currentChain = BOARD[node0.getX()][node0.getY()] 
                                    + BOARD[node1.getX()][node1.getY()] 
                                    + BOARD[node2.getX()][node2.getY()] 
                                    + BOARD[node3.getX()][node3.getY()];
                            // This chain is then comparared against min and max
                            // in search of a "new record"
                            if(currentChain > max){
                                max = currentChain;
                            }
                            if(currentChain < min){
                                min = currentChain;
                            }
                        }
                   }
                }
                // End of node subroutine
            }
        }
        // Results are printed
        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        
    } 

    /* SPECIAL CLASS NOTE:
    * This class was designed to be included in this project as a separate
    * file. However, assignment requirements dictate that this project be 
    * handed in as a single file. The author has decided to include this 
    * integral class as a test class in the same file as the main method instead
    * of redesigning the program to run without this class. The author believes
    * this will make the program more readable and extensible without sacrificing
    * the purpose of the assignment. This however, means that scope modifiers in 
    * this class will be set inefficiently. Being included in the main class, 
    * everything here becomes accessible to main, defeating the purpose of 
    * private variables. 
    */
    private static class Coordinate {

        // Instance variables
        
        private int x;
        private int y;

        // COnstructors
        
        public Coordinate() {
            x = 0;
            y = 0;
        }

        public Coordinate(int x1, int y1) {
            x = x1;
            y = y1;
        }

        // Generic getters
        
        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        /** 
         * Evaluates the equality of this object in comparison to another
         * Coordinate. 
         * 
         * @param other the Coordinate being compared to this object. 
         * @return ture if this Coordinate and other have identical x and y
         *  values, false otherwise. 
         */
        public boolean equals(Coordinate other) {
            return (x == other.getX() && y == other.getY());
        }

        /** 
         * Modifies the x parameter of this Coordinate to correspond with a 
         * movement "left" along a matrix indexed by x and y. 
         */
        public void left() {
            x--;
        }

        /** 
         * Modifies the x parameter of this Coordinate to correspond with a 
         * movement "right" along a matrix indexed by x and y. 
         */
        public void right() {
            x++;
        }

        /** 
         * Modifies the y parameter of this Coordinate to correspond with a 
         * movement "up" along a matrix indexed by x and y. 
         */
        public void up() {
            y++;
        }

        /** 
         * Modifies the y parameter of this Coordinate to correspond with a 
         * movement "down" along a matrix indexed by x and y. 
         */
        public void down() {
            y--;
        }

        /**
         * Copies the data in this Coordinate into a new object stored in 
         * memory. Similar to a Java clone method. 
         * 
         * @return A Coordinate with values identical to this object
         */
        public Coordinate deepCopy() {
            return new Coordinate(x, y);
        }

        /**
         * Determines whether or not this coordinate is outside the range of 
         * a matrix with rows and columns denoted by n x n. 
         * 
         * @param n The length of rows and columns of the matrix that this
         *   coordinate will be compared in. 
         * @return true if this coordinate is outside the bounds of an n x n
         *   matrix, false otherwise
         */
        public boolean isOutOfBounds(int n) {
            return (x >= n || x < 0 || y >= n || y < 0);
        }
    }
}