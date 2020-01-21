/* Anton Adamovich
*  Prof. Chuck Herbert - CSCI-112 - Community College of Philadelphia
*  Created: 2-11-2017 - Last Edited: 2-11-2017
*  Assignment 3
*  Description: This computer program plays a rendition of the common "Happy
*   Birthday" song in Piano. The score is publicly availible but I cited the 
*   sheet music I used to create the note code. JFugue is used as the music
*   engine that maps the note code to actual speaker sound recognized by humans
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   JFugue Webpage Examples:
*   http://www.jfugue.org/examples.html
*   Excerpts from The Complete Guide to JFugue 
*   http://www.jfugue.org/book.html
*   Sheet music for "Happy Birthday"
*   https://www.8notes.com/scores/1110.asp
*/

package noteplayer;

import org.jfugue.player.Player;

public class NotePlayer {

    public static void main(String[] args) {

        // Player is responsible for playing any sort of music with JFugue, 
        // I use it in a simple manner to play notes individiually
        Player player = new Player();

        System.out.println("The computer will now play a rendition of "
                + "\"Happy Birthday\". Enjoy! ");
        
        /* For the follwing string: pipes "|" denote measure bars, capital 
        *  letters "CDEFGAB" are note letters, lowercase letters and periods
        *  "his." denote note duration, a lowercase "b" indicates a flat, 
        *  numbers "456" indicate the octave a note is played in 
        *  (no number defaults to octave 5, middle C and up) and 
        *  the plus sign "+" is used to play one or more notes in harmony. 
        *  This information can be found in greater detail in the refrences
        *  comment block at the beggining of the program
        *  Everything after "V0" is what the "right hand" plays
        */
        player.play("V0 I[Piano] Ci. Cs | Dq Cq Fq | Eh Ci. Cs | Dq Cq Gq |"
                + " Fh Ci. Cs | C6q Aq Fq | Eq Dq Bbi. Bbs | Aq Fq Gq | Fh "
                // Everything after "V1" is what the "left hand" plays
                + " V1 I[Piano] Rq | F4h.+A4h. | C4h.+Bb4h. | C4h.+Bb4h. | "
                + " F4h.+A4h. | F4h.+A4h. | F4h.+Bb4h. | F4h+A4h C4q+Bb4q | "
                + " F4h+A4h");  
    } // end main
} // end class