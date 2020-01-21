/* Anton Adamovich
 * KeyFinder.java for Assignment ? - "Count the Occurence of Key Word in a Java Text File"
 * Prof. Craig Nelson - CSCI-211 - Community College of Philadelphia
 * Created: 12-5-2017 - Last Edited: 12-5-2017
 * Description: 
 * Resources:
 *  The Java Platform API Specification
 *  http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package keyfinder;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

public class KeyFinder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException{
        //Scanner fReader = new Scanner(new File("cookies.java"));
        String key = "";
        String example = "Get \"th\\em\\\" // cook\\\"i\"es";
        int hits = 0;
        System.out.println(example);
        // Single Line comment handling
        Pattern comment1 = Pattern.compile("(.*?)//");
        // String Literal handling
        Pattern comment2 = Pattern.compile("[^\\\\]\"(.*?)[^\\\\]\"");
        // Handle multi line comments with on/off switch, just make sure to ignore occurances of "/*" within string literals
        Matcher matcher = comment1.matcher(example);
        System.out.println(matcher.find());
        System.out.println(matcher.group());
        System.out.println(matcher.group(1));
        System.out.print(matcher.start() + " ");
        System.out.print(matcher.end() + " ");
        //while(fReader.hasNext()){
            
        //}
    }
    
}
