/* @author Anton Adamovich
*  Prof. Charles Herbert - CSCI-211 - Community College of Philadelphia
*  Created: 1-25-2017 - Last Edited: 1-23-2018
*       Edited 1-23-2018 Variable names modifed to fit "zipcodes.txt" test file
*  Assignment 1 - ZipCode.java
*  Description: The ZipCode object holds information about various
*       postal Zip COdes in the Philadelphia area and their respective towns
*       and counties. 
*  Resources:
*       The Java Platform API Specification
*       http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package zipcodefinder;

public class ZipCode {
    
    private String zipCode;
    private String town;
    private String county;
    
    // Default constructor with default variable assignments
    public ZipCode(){
        zipCode = "";
        town = "";
        county = "";
    } // end constructor
    
    // Constructor for instatiation of every variable in the class
    public ZipCode(String inZip, String inTown, String inCounty){
        this.zipCode = inZip;
        this.town = inTown;
        this.county = inCounty;
    } // end constructor
    
    /* Following methods are generic getters and setters auto-generated 
    *  for each varaible in the class.  
    */
	
    public String getZip() {
        return zipCode;
    }

    public void setZip(String zip) {
        this.zipCode = zip;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
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
        return (zipCode + "\n" + town + "\n" + county + "\n");
    } // end method 
	
} // end class