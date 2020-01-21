/* Antony Adamovich
*  Card.java for Homework 3
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 05-NOV-2018 - Last Edited: 08-NOV-2018
*   Edited 08-NOV-2018: Added ASCII art to card representations
*  Description: The Card class contains information about playing cards,
*   the rank (pip) and suit of cards is declared via enumerated types to 
*   ease programming of various methods. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   ASCII art for playing cards courtesy of "en Bukkems"
*   retrieved from: http://ascii.co.uk/art/cards
*   See attached README file
*/
package cardgames;

public class Card implements Comparable<Card>{
    
    // Private instance variables
    
    private Rank rank;
    private Suit suit;
    private String[] image;
    
    // Constants
    
    // Identical to FACE_DOWN.length or the length of the String array that holds card images
    public static final int IMAGE_SIZE = 6;
    // Represents the back of a playing card, the art for this is my own
    public static final String[] FACE_DOWN = { 
        " ____ ", 
        "|/  \\|", 
        "|[{}]|", 
        "|[{}]|", 
        "|\\  /|",
        "`----'"};
    
    // Constructors
    
    public Card(Rank aRank, Suit aSuit, String[] aImage){
        rank = aRank;
        suit = aSuit;
        image = aImage;
    }
    
    public Card(Rank aRank, Suit aSuit){
        rank = aRank;
        suit = aSuit;
        generateImage();
    }
    
    public Card(){
        rank = null;
        suit = null;
        image = null;
    }
    
    /** Reports the value of this card according to the rules of Blackjack. 
     *  Note that this method always treats Aces as having a value of 1. The
     *  management of an Ace's value when it is 11 is done elsewhere. 
     *
     *  @return A positive integer representing the Blackjack value of this instance
     */
    public int blackjackValue(){
        if((rank.ordinal() + 1) > 10){
            return 10;
        }
        return (rank.ordinal() + 1);
    }
    
    @Override
    /** Compares two classes based on the ordering of the enumerated types Suit
     *  and Rank. This is supposed to represent a "standard" way of ordering 
     *  playing cards, where the ordering, from least to greatest is: Clubs, 
     *  Diamonds, Hearts, and Spades. The Ordering of rank assumes Aces have a
     *  value of 1. Suit ordering takes precedence over rank
     * 
     *  @param aCard The Card that is being compared against this instance of Card
     * 
     *  @return 0 if the two cards are equal, less than 0 if the parameter card
     *  is larger than the instance and > 0 if the parameter card is smaller 
     *  than the instance
     */
    public int compareTo(Card aCard){
        int myValue = (this.suit.ordinal() * Rank.values().length) + (this.rank.ordinal() + 1);
        int aCardValue = (aCard.suit.ordinal() * Rank.values().length) + (aCard.rank.ordinal() + 1);
        return myValue - aCardValue;
    }
    
    /** Generates the String array that represents the art for a particular 
     *  playing card. The nature of this method is final and art was automated 
     *  from the following blueprint. A String array of length 6 is assumed
     *  with member Strings also of length 6. Output is printed directly. 
     *   ____    ____    ____    ____
     *  |2   |  |A   |  |Q   |  |K   |
     *  |(\/)|  | /\ |  | /\ |  | &  |
     *  | \/ |  | \/ |  |(__)|  |&|& |     
     *  |   2|  |   A|  | /\Q|  | | K|     en Bukkems
     *  `----`  `----'  `----'  `----'
     * 
     */
    private void generateImage(){
        image = new String[IMAGE_SIZE];
        // These two lines are the same for every card
        image[0] = " ____ ";
        image[5] = "`----'";
        // Lines 2 and 3 only change if the suit changes
        switch(suit){
            case SPADES:
                // Line includes escape backslash
                image[2] = "| /\\ |";
                image[3] = "|(__)|";
                break;
            case HEARTS:
                // Lines include escape backslash
                image[2] = "|(\\/)|";
                image[3] = "| \\/ |";
                break;
            case CLUBS:
                image[2] = "| &  |";
                image[3] = "|&|& |";
                break;
            case DIAMONDS:
                // Lines include escape backslash
                image[2] = "| /\\ |";
                image[3] = "| \\/ |";
                break;
        }
        // Line 1 changes based on the rank
        switch (rank) {
            case ACE:
            case JACK:
            case QUEEN:
            case KING:
                // All suits have the same line 1
                image[1] = "|" + (rank.name().charAt(0)) + "   |";
                // Line 4, however, is different for clubs and spades
                if(suit.compareTo(Suit.SPADES) == 0){
                    // Line includes escape backslash
                    image[4] = "| /\\" + (rank.name().charAt(0)) + "|";
                }
                else{
                    if(suit.compareTo(Suit.CLUBS) == 0){
                        image[4] = "| | " + (rank.name().charAt(0)) + "|";
                    }
                    else{
                        // Hearts and diamonds do not have a different line 4
                        // based on suit
                        image[4] = "|   " + (rank.name().charAt(0)) + "|";
                    }
                }
                break;
            case TWO:
            case THREE:
            case FOUR:
            case FIVE:
            case SIX:
            case SEVEN:
            case EIGHT:
            case NINE:
                // All suits have the same line 1
                image[1] = "|" + (rank.ordinal() + 1) + "   |";
                // Line 4, however, is different for clubs and spades
                if(suit.compareTo(Suit.SPADES) == 0){
                    // Line includes escape backslash
                    image[4] = "| /\\" + (rank.ordinal() + 1) + "|";
                }
                else{
                    if(suit.compareTo(Suit.CLUBS) == 0){
                        image[4] = "| | " + (rank.ordinal() + 1) + "|";
                    }
                    else{
                        // Hearts and diamonds do not have a different line 4
                        // based on suit
                        image[4] = "|   " + (rank.ordinal() + 1) + "|";
                    }
                }
                break;
            case TEN:
                // All suits have the same line 1
                image[1] = "|10  |";
                // Line 4, however, is different for clubs and spades
                if(suit.compareTo(Suit.SPADES) == 0){
                    image[4] = "| /10|";
                }
                else{
                    if(suit.compareTo(Suit.CLUBS) == 0){
                        image[4] = "| |10|";
                    }
                    else{
                        // Hearts and diamonds do not have a different line 4
                        // based on suit
                        image[4] = "|  10|";
                    }
                }
                break;
        }
        // Default case is not included as all types in Rank.java were covered
    }

    // Generic getters
    
    public String[] getImage(){
        return image;
    }
    
    public Rank getRank(){
        return rank;
    }
    
    @Override
    /** Provides a familiar phrase to represent a playing card, such as the 
     *  "ace of spades." The term is entirely lowercase. 
     *
     *  @return A lowercase representation of this instance
     */
    public String toString(){
        return ((rank.toString().toLowerCase()) + " of " + (suit.toString().toLowerCase()));
    }
}