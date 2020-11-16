/* Anton Adamovich
*  Prof. Chuck Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 1-25-2017 - Last Edited: 1-25-2017
*  Assignment 1
*  Description: Program creates a list of states form a pre-fedined data
*	file and then promtpts the user to search for a specific state by name. 
*	Information about said state, such as population and capitol city, is
*	then printed out. 
*  Resources:
*	The Java Platform API Specification
*	http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*/

package stringpalindromes;

public class StringPalindromes {
	
	/**
        *   Recursive function that determines if a word (in String form) is
        *    a palindrome, which is defined as a String that is identical
        *    written both forwards and backwards
        * 
	*   @param word A String to be identified as a palindrome or not
        *   @return true if word is a palindrome, false otherwise
	*/
	private static boolean isPalindrome(String word){
		
                // Function should not care about case sensitivity
		word = word.toLowerCase();

		// A word with a length less than 2 is alwasy a Palindome
		if(word.length() <= 1){
                    return true;
		} // end if
		// Check first and last chacaters of word for equality
		if(word.charAt(0) != word.charAt(word.length() - 1)){
                    // If this check fails, the word was not a Palindrome
                    return false;
		} // end if
                /* Next recursive step if Palindrome qaulities were satisfied so far.
                *   Next word is shortened by first and last characters since
                *   those were already checked above
                */
                return (isPalindrome(word.substring(1, word.length() - 1)));
	} // end method

	public static void main(String[] args){
		
            // Test String array of possible palindromes
            String[] wordList = {"abababa", "cookies", "R", "yx", "XYZzyx"};

            System.out.println("This program identifies if a given word is a palindrome or not. "
                    + "\nA Palindrome is a word that is the same writeen both backwards and forwards."
                    + " The list of test words is provided within the program. ");
            
            for(String word : wordList){
                // Since this is a for-each, wanted to include a null check
                // in case of bad values since every index in the array is checked
                if(word != null){
                    if(isPalindrome(word)){
                       System.out.println("\"" + word + "\"" + " is a Palindrome. ");
                    }
                    else{
                       System.out.println("\"" + word + "\"" + " is not a Palindrome. ");			
                    }
                } // end if	
            } // end for-each
	} // end main
} // end class
