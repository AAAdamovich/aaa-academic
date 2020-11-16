/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 2-21-2017 - Last Edited: 2-23-2017
*  Assignment 5
*  Description:  
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   Charles Herbert's "ArraySerializationDemo" - cherbert@ccp.edu
*/


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class CourseOrganizer{
    private static Course[] doSelectionSort(Course[] courseArray){
        
        int minIndex = 0;
        Course temp = null;
        
        for(int i = 0; i < courseArray.length; i++){
            minIndex = i;
            for(int j = (i + 1); j < courseArray.length; j++){
                // Z - A returns a positive integer, A - Z is a negative one
                if((courseArray[j].compareTo(courseArray[minIndex])) < 0){
                    minIndex = j;
                }
            }
            // Swap operations, if minimum is already in the correct location, no swap neccessary
            if(minIndex != i){
                temp = courseArray[i];
                courseArray[i] = courseArray[minIndex];
                courseArray[minIndex] = temp;
            } 
        }
        return courseArray;
    }
    
    private static boolean exportCourseList(File exportFile, Course[] courseArray) throws IOException{
        ObjectOutputStream oStream = null;
        System.out.println(exportFile.getAbsolutePath());
        try{
            oStream = new ObjectOutputStream(new FileOutputStream(exportFile.getName()));
            oStream.writeObject(courseArray);
        }
        catch(IOException e){
            // A trace is printed in event of a serious error, besides closing
            // file streams, no other error handling takes place
            System.out.println("An unexpected I/O error occured. ");
            System.out.println("Program will now exit. ");
            e.printStackTrace();
        }
        finally{
            if(oStream != null){
                oStream.close();
            }
        }
        return true;
    }
    
    private static Course[] importCourseList(File importFile) throws IOException{
        Course[] courseArray = null;
        ObjectInputStream iStream = null;
        System.out.println(importFile.getAbsolutePath());
        try{
            iStream = new ObjectInputStream(new FileInputStream(importFile.getName()));
            courseArray = (Course[])(iStream.readObject());
        }
        catch(ClassNotFoundException e){
            System.out.println("The provided file's formatting is invalid. ");
            System.out.println("Program will now exit. ");
            e.printStackTrace();
        }
        catch(IOException e){
            // A trace is printed in event of a serious error, besides closing
            // file streams, no other error handling takes place
            System.out.println("An unexpected I/O error occured. ");
            System.out.println("Program will now exit. ");
            e.printStackTrace();
        }
        finally{
            if(iStream != null){
                iStream.close();
            }
        }
        return courseArray;
    }
    
    public static void main(String[] args) throws IOException{
        Course A = new Course("a", "b", "c", 5);
        Course B = new Course("A", "B", "C", 6);
        Course C = new Course("Z", "x", "Y", 7);
        System.out.println(C.compareTo(B));
        System.out.println(A.compareTo(B));
        System.out.println(B.compareTo(B));
        Course[] courseArray;
        Course[] courseArray2 = null;
        File courseFile = new File("fall2014.ser");
        courseArray = importCourseList(courseFile);
        //doSelectionSort(courseArray2);
        for(Course aCourse : courseArray){
            System.out.println(aCourse.getCourse() + " " + aCourse.getSection());
        }
    }
}