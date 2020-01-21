/* City.Java  -- class file
 *  
 * This software package creates a graph of cities in the Unitied States with
 * links between the cities. Each city is a vertex in the graph.
 * Each link between cities is an edge in the graph.   The data for the cities and
 * links are read into arrays from data files, which should be in the project folder.
 * The files are CSV files, which can be read and edited in Excel.
 *
 * The main class for the project is the CityProject class.   Other class include:
 * 
 *   Vertex - clas for each Vertex in a graph.
 *   City extends Vertex - Each City is a Vertex with added properties.  Each City
 *      has a unique name, and X and Y cooordinates for location on a 1500 by 900 Canvas.
 *   Edge - an edge in the graph, with a source, destination, and length.
 *   AjacencyNode - a node for a linked list of cities directly connected to each City.
 *      Each City has a linked list of adjacnt cities, created from the info in the 
 *      data files, with destination City and distance data in the node, and a 
 *      link to the next node. 
 *   CityMap - extends Canvas, a map of the graph on a 1500 by 900 GUI Canvas.
 *      A CityMap object in instantiated in the drawMap method in the CityProject class.
 * 
 * The main method in the CityProject class calls methods to reads City and Edge 
 * data from data files into arrays, set up the adjacency list in each instance 
 * of City, print a list of Vertex cities and their Edges, then draw a map of the graph.
 *
 * created for use by students in CSCI 211 at Community Colle of Philadelphia
 * copyright 2014 by C. herbert.  last edited Nov. 23, 2014 by C. Herbert
 */

package cityproject;

class City extends Vertex {

    // added properties
    private boolean visited = false;
    private int bestDistance = Integer.MAX_VALUE;   //maximum value and integer can have
    private City immediatePredecessor;
    private AdjacencyNode adjacencyListHead;  // link to first node in adjacency list

    
    // city constructor
    City() {}
    
    
//added methods
    public void setVisited(boolean v) {
        this.visited = v;
    } // end setVisited()

    public void setBestDistance(int b) {
        this.bestDistance = b;
    } // end setBestDistance()

    public void setImmediatePredecessor(City c) {
        this.immediatePredecessor = c;
    } // end setImmediatePredecessor()

    public void setAdjacencyListHead(AdjacencyNode a) {
        this.adjacencyListHead = a;
    } // end setAdjacencyListHead()
    
    public boolean getVisited() {
        return this.visited;
    } // end getVisited()

    public int getBestDistance() {
        return this.bestDistance;
    } // end getBestDistance()

    public City getImmediatePredecessor() {
        return this.immediatePredecessor;
    } // end getImmediatePredecessor()

    public AdjacencyNode getAdjacencyListHead()  {
        return this.adjacencyListHead;
    } // end getAdjacencyListHead()
    
    
} // end class MyCity
