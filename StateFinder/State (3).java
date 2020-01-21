/* Anton Adamovich
*  Prof. Chuck Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 1-25-2017 - Last Edited: 1-25-2017
*  Assignment 1
*  Description: The State object holds information about political
*   states such as name, capitol city, and total population
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package statefinder;

public class State {
    
    private String name;
    private String capitol;
    private int population;
    
    // Default constructor with default variable assignments
    public State(){
        name = "";
        capitol = "";
        population = 0;
    } // end constructor
    
    // Constructor for instatiation of every variable in the class
    public State(String inName, String inCapitol, int inPopulation){
        this.name = inName;
        this.capitol = inCapitol;
        this.population = inPopulation;
    } // end constructor
    
    /* Following methods are generic getters and setters auto-generated 
    *  for each varaible in the class.  
    */
	
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapitol() {
        return capitol;
    }

    public void setCapitol(String capitol) {
        this.capitol = capitol;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
    
    /**
    * Creates and returns a String consisting of all the member of this class, 
    *   delimited with carriage returns. Note especially the final carriage 
    *   return. Minimal formatting reflects structure of original data file. 
    *
    * @return A concatenated String of every member of the class, delimited with
    *   carriage returns. 
    */
    @Override
    public String toString(){
        return (name + "\n" + capitol + "\n" + population + "\n");
    } // end method 
	
} // end class