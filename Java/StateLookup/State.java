/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 9-13-2017 - Last Edited: 9-13-2017
*  Assignment 1
*  Description: The State class hold information about a particular state in 
*   the United States
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package statelookup;

public class State{

    private String name;
    private String capital;
    private int population;

    public State(){
        name = "";
        capital = "";
        population = 0;
    }
    
    public State(String aName, String aCapital, int aPopulation){
        name = aName;
        capital = aCapital;
        population = aPopulation;
    }
    
    public String getInfo(){
        return (name + "\n" + capital + "\n" + (Integer.toString(population)) + "\n");
    }

    public String getName(){
        return name;
    }

    public String getCapital(){
        return capital;
    }

    public int getPopulation(){
        return population;
    }
    
    public void setName(String aName){
        name = aName;
    }

    public void setCapital(String aCapital){
        capital = aCapital;
    }

    public void setPopulation(int aPopulation){
        population = aPopulation;
    }
}
