/* Anton Adamovich
*  Prof. Charles Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 2-20-2017 - Last Edited: 2-23-2017
*  Assignment 4
*  Description: Program will copy a file directory and all of its contents to
*   another file directory, as specified by the user
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   Charles Herbert's "CopyFileDemoE" - cherbert@ccp.edu
*/

package filecopier;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class FileCopier {

    public static void main(String[] args) throws IOException{
        // File paths for input/output operations
        String source = "";
        String destination = "";
        // Keyboard input
        Scanner reader = new Scanner(System.in);
        
        System.out.println("This program will copy a specified directory and " 
                + "all of its contents to another chosen directory.");
        System.out.println("This operation will not check for files of the same"
                + " name, so be careful not to overwrite important files! ");
        System.out.println("Please enter a source directory: ");
        source = reader.nextLine();
        System.out.println("Please enter a destination directory: ");
        destination = reader.nextLine();
        
        // Associate user-defined pathnames with objects, to be passed into the 
        // copyDir method
        File sourceFile = new File(source);
        File destFile = new File(destination);

        System.out.println("Copying... ");
        if(copyDir(sourceFile, destFile)){
            System.out.println("Copy operations completed successfully! ");
            System.out.println("The copied (new) directory is located under: ");
            System.out.println("\"" + destFile.getAbsolutePath() + "\"");
        }
    }
    
    /** Method uses similar code and structure to a program called 
     *  "CopyFileDemoE" written by Charles Herbert (cherbert@ccp.edu)
     * 
     *  Method will copy the contents of a file into the contents of another 
     *  using binary data transfer techniques. Operations are buffered to 
     *  improve efficiency. Program does not discriminate between non-existing
     *  and existing files - data will be overwritten during operations on an
     *  identical file name. 
     * 
     * @param source The source file from which data will be copied
     * @param dest The destination file to which data will be copied. 
     * @throws IOException - If either source or dest is not a file, 
     *  (A directory, doesn't exist) executor has insufficient permissions, 
     *  source files are copy-protected, or destination is write-protected
     */
    public static void cloneFile(File source, File dest) throws IOException{
        
        // Defines a buffer size (in bytes) to be used by iStream and oStream
        final int BUFFER_SIZE = 8182;
        // Temporary variable to be used in binary data transfer 
        int transferByte = 0;
        // Declarations to be used in a try block, pointers must be established 
        // to avoid compile-time errors
        BufferedInputStream iStream = null;
        BufferedOutputStream oStream = null;
        
        try{
            // Assigns the input and outpt streams to a file defined by method
            // parameters, both streams will use buffering
            iStream = (new BufferedInputStream((new FileInputStream(source)), BUFFER_SIZE));
            oStream = (new BufferedOutputStream((new FileOutputStream(dest)), BUFFER_SIZE));
        
            // Reads a single byte of information from the source file, repeated
            // in the loop below
            transferByte = iStream.read();
            // Loop ends when a read operation returns a "-1": the EOF 
            // (End Of File) marker
            while(transferByte != -1){
                oStream.write(transferByte);
                transferByte = iStream.read();
            } // End while
        } // End try
        catch(IOException e){
            // A trace is printed in event of a serious error, besides closing
            // file streams, no other error handling takes place
            System.out.println("An unexpected I/O error occured. ");
            System.out.println("Program will now exit. ");
            e.printStackTrace();
        } // End catch
        finally{
            // Checks to see if either stream is open to avoid terminating a 
            // non-existing stream
            if(iStream != null){
                iStream.close();
            } // End if
            if(oStream != null){
                oStream.close();
            } // End if
        } // End finally
    } // End method
    
    /** Method copies the contents of a source directory into a new directory. 
     *  Does not check for duplicates in the destination. Any files with names
     *  identical to the ones in the source will be overwritten. Directories
     *  with identical names will be ignored and treated as if that directory 
     *  has already been copied over. Detects and handles common I/O errors
     *  such as incorrect paths but can still fail on non-handled exceptions. 
     * 
     * @param source A directory from which files will be read to copy into 
     *  the destination directory. A non-directory pathname will cause the
     *  program to quit. 
     * @param dest The destination directory that will contain a copy of the 
     *  source directory once method successfully completes. A non-directory
     *  pathname will cause the program to quit. 
     * @return true if method successfully executes, false otherwise. 
     * @throws IOException - Most likely if executer has insufficient
     *  permissions
     */
    public static boolean copyDir(File source, File dest) throws IOException{
        
        // An index of what the program will be copying
        File[] copyIndex;
        /* A pathname that specifies what the program is currently working on, 
        *   or the next file/directory the program will copy. Pointer begins
        *   inside the dest(destination) directory with the source pathname as
        *   a subdirectory. In the event source is not a directory, currentDir 
        *   will be the pathname of the next copied file. As this method is 
        *   used recursively, currentDir appends each new subdirectory the 
        *   program encounters in the source to the directory pathname in the
        *   destination. 
        */
        File currentDir;
        
        // Prerequisite checks with soft error handling
        // Root checks (If either source/destination is left blank)
        if(source.getName().equals("")){
            source = new File(source.getAbsolutePath(), "./");
        }
        if(dest.getName().equals("")){
            dest = new File(dest.getAbsolutePath(), "./");
        }
        if(!source.exists()){
            System.out.println("The source directory path provided: \"" 
                    + source.getAbsolutePath() + "\" does not exist. ");
            System.out.println("Program will now exit. ");
            return false;
        }
        if(!dest.exists()){
            System.out.println("The destination directory path provided: \"" 
                    + dest.getAbsolutePath() + "\" does not exist. ");
            System.out.println("Program will now exit. ");
            return false;
        }
        if(!source.isDirectory()){
            System.out.println("The source path provided: \"" 
                    + source.getAbsolutePath() + "\" is not a folder/directory. ");
            System.out.println("Program will now exit. ");
            return false;
        }
        if(!dest.isDirectory()){
            System.out.println("The destination path provided: \"" 
                    + dest.getAbsolutePath() + "\" is not a folder/directory. ");
            System.out.println("Program will now exit. ");
            return false;
        }

        // Generate index of files to be copied inside the source directory
        copyIndex = source.listFiles();
        
        try{
            currentDir = new File(dest, source.getName());
            
            // Generate destination directory clone
            if(!currentDir.mkdir()){
                // In the event directory creation fails, check for existing 
                // directory. If OK, proceed, if not, exit
                if(!(currentDir.exists() || currentDir.isDirectory())){
                    System.out.println("Program was unable to create a new folder in the follwing location: \""
                            + currentDir.getAbsolutePath() + "\"");
                    System.out.println("Program will now exit. ");
                    return false;
                }
            } // End if
            
            // The actual copy procedure, iterate through the file index array
            // created earlier and copy directory contents recursively
            for(File pathname : copyIndex){
                if(pathname.isFile()){
                    // Base case - File copy operation
                    cloneFile(pathname, new File(currentDir, pathname.getName()));
                }
                else{
                    if(pathname.isDirectory()){
                        // Recursive case - Directory copy operation
                        copyDir(pathname, currentDir);
                    }
                }
            } // End for
        // If above operations completed successfully, method will exit  
        return true;
 
        } // End try
        catch(IOException e){
            // A trace is printed in event of a serious error
            System.out.println("An unexpected I/O error occured. ");
            System.out.println("Program will now exit. ");
            e.printStackTrace();
        } // End catch
        // If the method is still running at this point, something went wrong
        System.out.println("Copy operations may not have completed successfully or were interrupted. ");
        System.out.println("Program will now exit. ");
        return false;
    } // End method 
} // End class