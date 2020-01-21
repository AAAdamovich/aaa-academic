/*
 * ArraySerializationDemo.java
 * CSCI 112 - Spring 2014
 * last edited March 8, 2014 by C. Herbert
 * 
 * This code demonstrates the use of the ObjectOutputStream class and its 
 * writeObject() method, along with the ObjectInputStream class and its
 * readObject() method for simplified array I/O in Java. It is an example of the 
 * way in which array serialzation can be used for data persistence.
 * 
 * It creates a hardcoded instance of an Employee array and writes it to a data 
 * file. It then retrieves it from the file into a new array 
 * and displays the new array on the console. 
 * 
 * The Employee class is included in this code.
 * 
 */
package arrayserializationdemo;
import java.io.*;

public class ArraySerializationDemo {

    public static void main(String[] args) throws Exception {

        // create an Employee array for this demo 
        Employee[] empA = new Employee[5];

        // instantiate five Employees in the array 
        empA[0] = new Employee("1111", "Smith", "John");
        empA[1] = new Employee("2222", "Jones", "Mary");
        empA[2] = new Employee("3333", "Ali", "Ben");
        empA[3] = new Employee("1111", "Rodgers", "Fred");
        empA[4] = new Employee("1111", "Rambo", "John");
            
        // set the hours 
        empA[0].setHours(40.0);
        empA[1].setHours(45.0);
        empA[2].setHours(37.5);
        empA[3].setHours(40.0);
        empA[4].setHours(40.0);
        
        // set the pay rates
        empA[0].setRate(12.5);
        empA[1].setRate(12.5);
        empA[2].setRate(11.0);
        empA[3].setRate(15.0);
        empA[4].setRate(15.0);
        
    // instantiate an employee array to receive the data from a data file
        Employee[] empB = new Employee[5];
 
        // show the user the original array using an enhanced for loop (Chapter 18)
        System.out.println( "The original arrays is: ");
        for ( Employee emp : empA)      
            System.out.println( "\t" + emp.toString() );

        // alert the user and write the array to a file
        System.out.println("\nWriting employee array a data to a file.");
        writeToFile(empA);

        // alert the user and read data from a file into the duplicate array
        System.out.println("\nReading employee B data from a file.");
        empB = readFromFile();
        
        // show the user the duplicate array 
        System.out.println( "\nThe duplicate array is: ");
        for ( Employee emp : empB) 
            System.out.println( "\t" + emp.toString() );
        
    } // end main()
    //****************************************************************************

    
    /* This method writes an instance of the Employee class to a binary file.
     * It demonstrates how to serialize an object using ObjectOutputStream  
     */
    public static void writeToFile(Employee[] emp) throws Exception {

        // declare file and stream variables before thr try block
        FileOutputStream empFile = null;
        ObjectOutputStream outfile = null;
        
        try {
            // set up the File and stream objects
            empFile = new FileOutputStream("employees.ser");
            outfile = new ObjectOutputStream(empFile);
            
        // write an Employee object to a file
            outfile.writeObject(emp);
                        
        // use a standard catch block    
        } catch (IOException e) {
            e.printStackTrace();

        // no matter what happens, close the file
        } finally {
            outfile.close();
        }
    }  // end writeToFile(Employee e)
    //****************************************************************************

    
    /* This method reads an instance of the Employee class from a binary file.
     * It demonstrates how to deserialize an object using ObjectInputStream  
     */
    public static Employee[] readFromFile() throws Exception {

        Employee[] emp = null;   // an Employee object to hold data from the file
        
        // declare file and stream variables before thr try block
        FileInputStream empFile= null;
        ObjectInputStream infile = null;

        try {
            // set up the File and stream objects
            empFile = new FileInputStream("employees.ser");
            infile = new ObjectInputStream(empFile);
            
            // read the object from a file
            emp = (Employee[]) infile.readObject();
            
        // use a standard catch block    
        } catch (IOException exc) {
            exc.printStackTrace();
        
        // no matter what happens, close the file
        } finally {
            infile.close();
        }  // end finally
    
        // return the object
        return emp;
    
    } // readFromFile()
    
} // end class ArraySerializationDemo
//****************************************************************************


class Employee implements Serializable {

    private String employeeID;  // key field -- uniquely identifies an employee 
    private String lastName;    // employee's last name
    private String firstName;   // employee's last name
    private double rate;        // hourly pay rate
    private double hours;       // hours worked in the pay period

    // constructors
    Employee() {
    }

    Employee(String employeeID, String lastName, String firstName) {
        this.employeeID = employeeID;
        this.lastName = lastName;
        this.firstName = firstName;
    }   // end Employee() initalizing

    // muatator methods
    public void setEmployeeID(String empID) {
        this.employeeID = empID;
    }// end setEmployeeID()

    public void setName(String fName, String lName) {
        this.firstName = fName;
        this.lastName = lName;
    }   // end setName()

    public void setHours(double hrs) {
        this.hours = hrs;
    }   // end setFirstName()

    public void setRate(double rt) {
        this.rate = rt;
    }   // end setRate()

    // accessor methods
    public String getEmployeeID() {
        return employeeID;
    }   // end getEmployeeID()

    public String getFirstName() {
        return firstName;
    }   // end FirstName()

    public String getLastName() {
        return lastName;
    }   // end getLastName()

    public double getHours() {
        return hours;
    }   // end getHours()

    public double getRate() {
        return rate;
    }   // end getRate()

    // method to calculate and return gross pay
    public double getGross() {
        double gross = hours * rate;       // employee's regular gross psay

        // add overtime if hours >  40   using time and a half rule
        if (hours > 40) {
            gross = gross + (hours - 40) * 0.5 * rate;
        }

        return gross;
    }   // end getGross()

    // method to compare by EmployeeID using the String class compareTo()
    public int compareTo(Employee other) {
        return this.employeeID.compareTo(other.getEmployeeID());
    }   // end compareTO()

    // method to return properties as a string
    public String toString() {

        return employeeID + " "
                + lastName + " "
                + firstName + " "
                + rate + " "
                + hours;
    }    // end toString()

    // method to return properties as a CSV string on one line
    public String toCSVString() {

        return employeeID + ","
                + lastName + ","
                + firstName + ","
                + rate + ","
                + hours + "\n";

    }  // end toCSVString()
}// end class Employee
