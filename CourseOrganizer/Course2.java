/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 2-21-2017 - Last Edited: 2-22-2017
*  Assignment 5
*  Description:  
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   Charles Herbert's "CopyFileDemoE" - cherbert@ccp.edu
*/
   
package courseorganizer;

import java.io.Serializable;

/*class Course implements Serializable, Comparable<Course>{
    
    // the campus on which the course is offered
    private String campus;
    // the course name, such as CSCI 111
    private String course;
    // the section number
    private String section;
    // the CRN for this section
    private String crn;
    // the number of credits for the course
    private int credits;
    // the time the course is offered, such as 8:00 to 10:00 A.M.
    private String time;
    // the Days the course is offered, suhc as MW
    private String days;
  
    // Constructors
    
    Course() {
        this.campus = "";
        this.course = "";
        this.section = "";
        this.crn = "";
        this.credits = 0;
        this.time = "";
        this.days = "";
    }

    Course(String course, String section, String crn, int credits) {
        this.course = course;
        this.section = section;
        this.crn = crn;
        this.credits = credits;
        this.time = "";
        this.days = "";
    }
    
    Course(String course, String section, String crn, int credits, String time, String days) {
        this.course = course;
        this.section = section;
        this.crn = crn;
        this.credits = credits;
        this.time = time;
        this.days = days;
    }
    
    // Setters
    
    public void setCampus(String cmp) {
        this.campus = cmp;
    } // End setCampus()
    
    public void setCourse(String course) {
        this.course = course;
    } // End setCourse()

    public void setSection(String sect) {
        this.section = sect;
    } // End setSection()

    public void setCRN(String crn) {
        this.crn  = crn;
    } // End setCRN()

    public void setCredits(int cr) {
        this.credits = cr;
    } // End setCredits()

    public void setTime(String tm) {
        this.time = tm;
    } // End setTime()

    public void setDays(String days) {
        this.days = days;
    } // End setDays()
    
    // Getters
    
    public String getCampus() {
        return campus;
    } // End getCampus()

    public String getCourse() {
        return course;
    } // End Course()

    public String getSection() {
        return section;
    } // End getSection()

    public String getCRN() {
        return crn;
    } // End getCRN()

    public int getCredits() {
        return credits;
    } // End getCredits()

    public String getTime() {
        return time;
    } // End getTime()

    public String getDays() {
        return days;
    } // End getDays()

    // Utility Methods
    
    public int compareTo(Course other) {
        // Compares by CRN using the String class compareTo()
        int result1 = this.course.compareToIgnoreCase(other.getCourse());
        
        if(result1 == 0){
            return (this.section.compareToIgnoreCase(other.getSection()));
        }
        else{
            return result1;
        }
    } // End compareTo()

    // Returns properties as a string
    public String toString() {
        return campus + " "
                + course + " "
                + section + " "
                + crn + " "
                + credits + " "
                + time + " "
                + days;  
    } // End toString()

    // Returns properties as a Comma Separated Value (CSV) string
    public String toCSVString() {
        return campus + ","
            + course + ","
            + section + ","
            + crn + ","
            + credits + ","
            + time + ","
            + days + "\n";
    } // End toCSVString()
} // End class*/

class Course implements Serializable {

    
    private String campus;  // the campus on which the course is offered
    private String course;  // the course number, such as CSCI 111
    private String section; // the section number
    private String crn;     // the CRN for this section
    private int credits;    // the number od credits for the course
    private String time;    // the time the course is offered, such as 8:00 to 10:00 A.M.
    private String days;    // the Days the course is offered, suhc as MW

    
    // constructors
    Course() {
    }

    Course(String course, String section, String crn, int credits) {
        this.course = course;
        this.section = section;
        this.crn = crn;
        this.credits = credits;
    }   // end Course() initalizing

    // muatator methods
    public void setCampus(String cmp) {
        this.campus = cmp;
    }// end setCampus()
    
    public void setCourse(String crse) {
        this.course = crse;
    }// end setCourse()

    public void setSection(String sect) {
        this.section = sect;
    }   // end setSection()

    public void setCRN(String crn) {
        this.crn  = crn;
    }   // end setCRN()

    public void setCredits(int cr) {
        this.credits = cr;
    }   // end setCredits()

    public void setTime(String tm) {
        this.time = tm;
    }// end setTime()

    public void setDays(String days) {
        this.days = days;
    }// end setDays()

    
    
    
    // accessor methods
    public String getCampus() {
        return campus;
    }   // end getCampus()

    public String getCourse() {
        return course;
    }   // end Course()

    public String getSection() {
        return section;
    }   // end getSection()

    public String getCRN() {
        return crn;
    }   // end getCRN()

    public int getCredits() {
        return credits;
    }   // end getCredits()

    public String getTime() {
        return time;
    }   // end getTime()

    public String getDays() {
        return days;
    }   // end getDays()


    public int compareTo(Course other) {
        // Compares by CRN using the String class compareTo()
        int result1 = this.course.compareToIgnoreCase(other.getCourse());
        
        if(result1 == 0){
            return (this.section.compareToIgnoreCase(other.getSection()));
        }
        else{
            return result1;
        }
    } // End compareTo()

    // method to return properties as a string
    public String toString() {

        return campus + " "
                + course + " "
                + section + " "
                + crn + " "
                + credits + " "
                + time + " "
                + days;
        
    }    // end toString()
}
    // You will need to add a method to return properties as a CSV string on one line
/*    public String toCSVString() {

 
    }  // end toCSVString()
  */

//}// end class Course