/* CityProject.java  -- project class file with the project's main method   
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
 *
 * Modified by Anton Adamovich for "City Graph Assignment"
 * Last Edited: 29-APR-2018
 * Edits: 
 * 19-APR-2018 Addition of "getShortestPath" method
 * 24-APR-2018 Modification of "main" method for added shortest path algorithim
 * 29-APR-2018 Removal of "main" method modifications, addition of requestCities method
 */

package cityproject;

import java.awt.*;
import javax.swing.*;
import java.util.*;
import java.io.*;

public class CityProject {

    // main metod for the project
    public static void main(String[] args) {

        City[] cities = new City[200]; //array of cities (Vertices) max = 200
        for (int i = 0; i < cities.length; i++) {
            cities[i] = new City();
        }

        Edge[] links = new Edge[2000];// array of links  (Edges)  max = 2000
        for (int i = 0; i < links.length; i++) {
            links[i] = new Edge();
        }

        int cityCount; //    actual number of cities
        int linkCount; //    actual number of links

        // load cities into an array from a datafile
        cityCount = readCities(cities);

        // load links into an array from a datafile
        linkCount = readLinks(links, cities);

        // create the adjacency list for each city based on the link array
        createAdjacencyLists(cityCount, cities, linkCount, links);

        // print adjacency lists for all cities
        PrintAdjacencyLists(cityCount, cities);

        // draw a map of the cities and links
        drawMap(cityCount, cities,linkCount, links);
        
        // Prompt for user input and shortest path building
        requestCities(cities);
    } // end main
    //************************************************************************
    
    /** Prompts for a start and destination city, then runs a "Shortest Path"
     * algorithm to determine and print the shortest path between the start and 
     * destination. 
     * @author Anton Adamovich
     * @param cityList The list of cities (universe) used for path determination
     */
    private static void requestCities(City[] cityList){
        Scanner reader = new Scanner(System.in);
        String start = "";
        String destination = "";
        
        // Pad output before starting prompt
        System.out.println(); 
        System.out.println(); 
        // Prompt for staring city
        System.out.print("Please enter a start city: ");
        start = reader.nextLine();
        // Prompt for destination city
        System.out.print("Please enter a destination city: ");
        destination = reader.nextLine();
        
        // Build stack that denotes shortest path between start and destination
        Stack<City> route = getShortestPath(start, destination, cityList);
        
        // If getShortestPath returned null, this will never execute
        if(route != null){
            System.out.println("\nThe shortest path from " + start + " to " + destination + " is: \n");
            while(!route.isEmpty()){
            // In reverse order, from start to destination
            System.out.println(route.pop().getName());
            }
        }
    } // End method
    
    /** Finds the shortest path between two cities. 
     * @author Anton Adamovich
     * @param start The name of the starting city
     * @param destination The name of the destination city
     * @param cityList The list of cities that this method will use to build
     * the shortest path
     * @return A stack that specifies the shortest route from the start city
     * to the destination. Null will be returned if either start or destination
     * is not found in cityList
     */
    private static Stack<City> getShortestPath(String start, String destination, City[] cityList){
        City currentVertex = null;
        City destinationCity = null;
        AdjacencyNode nextNode = null;
        int nextDistance = Integer.MAX_VALUE;
        
        // Attempt to find start city in cityList
        try{
            currentVertex = findCity(cityList, start);
            currentVertex.setBestDistance(0);
            currentVertex.setImmediatePredecessor(null);
        }
        // In the event "findCity" does not locate start, a NullPointerException will be thrown
        catch(NullPointerException e){
            System.out.println("Your start city does not exist in the list of cities. Program will now exit. ");
            return null;
        }
        // Attempt to find destination city in cityList
        try{
            destinationCity = findCity(cityList, destination);
        }
        // In the event "findCity" does not locate destination, a NullPointerException will be thrown
        catch(NullPointerException e){
            System.out.println("Your destination city does not exist in the list of cities. Program will now exit. ");
            return null;
        }
        // In the event start and destination are equal, a stack with 
        // the starting City node is returned
        if(start.equalsIgnoreCase(destination)){
            Stack<City> route = new Stack<>();
            route.push(currentVertex);
            return route;
        }
        
        // Beginning of Dijkstra's algorithim
        while(currentVertex != null){
            // Obtain the adjacency list pointer of currentVertex
            nextNode = currentVertex.getAdjacencyListHead();
            // Sentinel loop to iterate through adjacency list
            while(nextNode != null){
                // Find the distance to the nextNode through currentVertex
                nextDistance = nextNode.getcDistance() + currentVertex.getBestDistance();
                // "Relaxation" step
                // If this distance is a new best for the adjacent vertex, update bestDistance
                if(nextDistance < nextNode.getCity().getBestDistance()){
                    nextNode.getCity().setBestDistance(nextDistance);
                    // ImmediatePredecessor is also updated
                    nextNode.getCity().setImmediatePredecessor(currentVertex);
                }
                // Iterate to next node in the adjacency list
                nextNode = nextNode.getNext();
            }
            // Adjacency list exhausted, mark currentVertex as visited
            currentVertex.setVisited(true);
            // Reset variables for next pass of algorithim
            nextDistance = Integer.MAX_VALUE;
            currentVertex = null;
            // Search for non-visited vertex with lowest bestDistance
            for(City city : cityList){
                if(!city.getVisited() && city.getBestDistance() < nextDistance){
                    nextDistance = city.getBestDistance();
                    currentVertex = city;
                }
            }
            // Loop will exit with currentVertex set to the next node in the algorithim
            // path or null in the event every city in cityList was visited
        } // End of node visitation subroutine
        // Build shortest path stack
        Stack<City> route = new Stack<>();
        currentVertex = destinationCity;
        while(currentVertex != null){
            route.push(currentVertex);
            currentVertex = currentVertex.getImmediatePredecessor();
        }
        return route;
    }// End method
    
    // method to read city data into an array from a data file
    public static int readCities(City[] cities) {

        int count = 0; // number of cities[] elements with data

        String[][] cityData = new String[123][3]; // holds data from the city file
        String delimiter = ",";                   // the delimiter in a csv file
        String line;                              // a String to hold each line from the file
        
        String fileName = "cities.csv";           // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there is another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();

                // split the line into separate objects and store them in a row in the array
                cityData[count] = line.split(delimiter);
                
                // read data from the 2D array into an array of City objects
                cities[count].setName(cityData[count][0]);
                cities[count].setX(Integer.parseInt(cityData[count][1]));
                cities[count].setY(Integer.parseInt(cityData[count][2]));

                count++;
            }// end while

            infile.close();

        } catch (IOException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;

    } // end loadCities()
    //*************************************************************************

    // method to read link data into an array from a data file
    public static int readLinks(Edge[] links, City[] cities) {
        int count = 0; // number of links[] elements with data

        String[][] CityLinkArray = new String[695][3]; // holds data from the link file
        String delimiter = ",";                       // the delimiter in a csv file
        String line;				      // a String to hold each line from the file

        String fileName = "links.csv";                // the file to be opened  

        try {
            // Create a Scanner to read the input from a file
            Scanner infile = new Scanner(new File(fileName));

            /* This while loop reads lines of text into an array. it uses a Scanner class 
             * boolean function hasNextLine() to see if there another line in the file.
             */
            while (infile.hasNextLine()) {
                // read the line 
                line = infile.nextLine();
                

                // split the line into separate objects and store them in a row in the array
                CityLinkArray[count] = line.split(delimiter);

                // read link data from the 2D array into an array of Edge objects
                // set source to vertex with city name in source column
                links[count].setSource(findCity(cities, CityLinkArray[count][0]));
                // set destination to vertex with city name in destination column
                links[count].setDestination(findCity(cities, CityLinkArray[count][1]));
                //set length to integer valuein length column
                links[count].setLength(Integer.parseInt(CityLinkArray[count][2]));

                count++;

            }// end while

        } catch (IOException e) {
            // error message dialog box with custom title and the error icon
            JOptionPane.showMessageDialog(null, "File I/O error:" + fileName, "File Error", JOptionPane.ERROR_MESSAGE);
        }
        return count;
    } // end loadLinks()
    //*************************************************************************

    // emthod to find the City onject with the given city name
    public static City findCity(City[] cities, String n) {
        int index = 0;  // loop counter
        // go through the cities array until the name is found
        // the name will be in the list

        while (cities[index].getName().compareTo(n) != 0) {

            index++;
        }// end while()
        return cities[index];

    } // end  findCity()

// method to create an adjacency lists for each city
    public static void createAdjacencyLists(int cityCount, City[] cities, int linkCount, Edge[] links) {

        AdjacencyNode temp = new AdjacencyNode();

        // iterate city array
        for (int i = 0; i < cityCount; i++) {

            //iterate link array
            for (int j = 0; j < linkCount; j++) {
                // if the currentl link's source is the current city
                if (links[j].getSource() == cities[i]) {

                    /* create a node for the link and inseert it into the adjancency list
                     * as the new head of the list. 
                     */
                    // temporarily store the current value of the list's head
                    temp = cities[i].getAdjacencyListHead();
                    //create a new node
                    AdjacencyNode newNode = new AdjacencyNode();
                    // add city and distance data
                    newNode.setCity(links[j].getDestination());
                    newNode.setDistance(links[j].getLength());
                    // point newNode to the previous list head
                    newNode.setNext(temp);

                    // set the new head of the list to newNode
                    cities[i].setAdjacencyListHead(newNode);

                }  // end if
            } // end for j
        } // end for i

    } // end createAdjacencyLists()

    // method to print adjacency lists
    public static void PrintAdjacencyLists(int cityCount, City[] cities) {

        System.out.println("List of Edges in the Graph of Cities by Source City");
        // iterate array of cities
        for (int i = 0; i < cityCount; i++) {

            // set current to adjacency list for this city    
            AdjacencyNode current = cities[i].getAdjacencyListHead();

            // print city name
            System.out.println("\nFrom " + cities[i].getName());

            // iterate adjacency list and print each node's data
            while (current != null) {
                System.out.println("\t"+ current.toString());
                current = current.getNext();
            } // end while (current != null) 

        }   // end for i 

    } // end PrintAdjacencyLists()

    
    // method to draw the graph (map of cities and links)
   static void drawMap(int cCount, City[] c, int lCount, Edge[] l)
   {
       CityMap canvas1 = new CityMap(cCount,  c, lCount, l);
       

        int width = 1500; // width of the Canvas
        int height = 900; // heightof the Canvas 
        
        
        // set up a JFrame to hold the canvas
        JFrame frame = new JFrame();
        frame.setTitle("U.S. Cities");
        frame.setSize(width, height);
        frame.setLocation(10, 10);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the canvas to the frame as a content panel
        frame.getContentPane().add(canvas1);
        frame.setVisible(true);

   } // end drawMap() 
    
    
    
} // end class cityProject
