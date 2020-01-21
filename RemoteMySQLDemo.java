/* RemoteMySQLDemo.Java     last edited 3/31/2014 by C.Herbert
 * This code connects to a remote MYSQL database on the website CWHerbert.com
 * It connects via a fixed IP address (IPv4) to the database CWHDemo and
 * the table "pet", which is the same as the table used in the MySQL Documentation,
 * Chapter 3 tutorial.  Read only access to the database and table is granted for 
 * the puposes of learning to write java code to connect to and query a database
 * using SQL from within Java.
 *
 * host IP address: 68.178.217.12
 * database:        CWHDemo
 * username:        CWHDemo
 * password:        Access2017!  (Note capital "A" in password and exclamatio pint at the end.)
 
 Table metadata can be retrieved with the query "DESCRIBE pet;"
 name    varchar(20) 
 species varchar(20) 
 sex     char(1) 
 birth   date 
 death   date 
 */

/* The class for the JDBC communications driver for MySQL must be available.
 * It can be included in a locally asccessible library, 
 * by using the import statement    import com.mysql.jdbc.Driver;
 * or by using the Class.forName(com.mysql.jdbc.Driver) within your code 
 */

package remotemysqldemo;
import java.sql.*;

public class RemoteMySQLDemo {

    public static void main(String[] args)
            throws Exception {

        // Connect to a database by  establishing a Connection object
        Connection conn = DriverManager.getConnection("jdbc:mysql://68.178.217.12/CWHDemo", "CWHDemo", "Access2017!");

        System.out.println("Database connection established.\n");

        // Create a statement Object for this  database connection
        Statement st = conn.createStatement();

        // call a method that performs a query using Statement st
        selectAll(st);

        // Close the connection
        conn.close();
    } // end main()
    //*********************************************************************************
    
    
    /* The following method performs an SQL query 
     * The parameter must be a Statement object with an established connection
     * to an SQL database. 
     */
    public static void selectAll(Statement s) throws SQLException, ClassNotFoundException {

        String queryString;     // a String to hold an SQL query 
        ResultSet rs;           // the result set from an SQL query as a table

        // Create an SQL query as as String for this statement
        // this query returns all rows and all columns from the database  
        queryString = "SELECT * FROM pet;";
 
        // Send a statement executing the query and saving the result set 
        rs = s.executeQuery(queryString);

        // print headings for the output
        System.out.println(queryString);
        System.out.printf("%-20s%-20s%-20s%n", "Pet's Name", "Owner", "Species");
        System.out.println("*******************************************************");

        // Iterate through the result set and print name, owner, and species attributes
        while (rs.next())
            System.out.printf("%-20s%-20s%-20s%n", rs.getString(1), rs.getString(2), rs.getString(3));
        
        System.out.println("*******************************************************");

    } // end selectAll()

} // end class

