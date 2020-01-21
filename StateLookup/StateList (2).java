/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 9-13-2017 - Last Edited: 9-13-2017
*  Assignment 1
*  Description: The StateList class holds an array of State objects
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package statelookup;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class StateList{

    private State[] stateArray;
    private int size;

    public StateList(){
        stateArray = new State[0];
        size = 0;
    }

    public StateList(int initialLength){
        stateArray = new State[initialLength];
        size = 0;
    }
    
    public boolean buildList(File stateData) throws FileNotFoundException{
        try{
            Scanner fileReader = new Scanner(stateData);
            while(fileReader.hasNext()){
                stateArray[size] = new State();
                stateArray[size].setName(fileReader.nextLine());
                stateArray[size].setCapital(fileReader.nextLine());
                stateArray[size].setPopulation(Integer.parseInt(fileReader.nextLine()));
                size++;
            }
            return true;
        }
        catch(FileNotFoundException e){
            return false;
        }  
    }
    
    public void printList(){
        for(State state : stateArray){
            state.getInfo();
            System.out.println();
        }
    }
    
    public boolean findState(String query){
        int iterator = 0;
        while(iterator < size){
            if((stateArray[iterator].getName()).equalsIgnoreCase(query)){
                System.out.println("A match has been found: ");
                stateArray[iterator].getInfo();
                return true;
            }
            iterator++;
        }
        System.out.println("No match was found for the following query: ");
        System.out.println("\"" + query + "\"");
        return false;
    }
}