/*
 * Included below is the code for the class Course, which
 * was used to create the data file "fall2014.ser".  You should use this 
 * code for assignment 5 at the end of Chapter 19.
 *
 * Also included is the code for the method that was used to write the file.  
 * As part of the assignment, you will need to write the code to read the file.
 *
 * This not a working NetBanes project; it simply cotains code that will help you
 * complete the assignment.
 */
    public static void writeToFile(Course[] courses) throws Exception {

        // declare file and stream variables before thr try block
        FileOutputStream empFile = null;
        ObjectOutputStream outfile = null;
        
        try {
            // set up the File and stream objects
            empFile = new FileOutputStream("fall2014.ser");
            outfile = new ObjectOutputStream(empFile);
            
        // write an Employee object to a file
            outfile.writeObject(courses);
                        
        // use a standard catch block    
        } catch (IOException e) {
            e.printStackTrace();

        // no matter what happens, close the file
        } finally {
            outfile.close();
        }
    }  // end writeToFile(Employee e)
    //****************************************************************************



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


    // method to compare by CRN using the String class compareTo()
    public int compareTo(Course other) {
        return this.crn.compareTo(other.getCRN());
    }   // end compareTO()

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

    // You will need to add a method to return properties as a CSV string on one line
/*    public String toCSVString() {

 
    }  // end toCSVString()
  */

}// end class Course
