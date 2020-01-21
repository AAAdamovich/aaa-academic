/* Antony Adamovich
*  Hand.java for Homework 3
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 06-NOV-2018 - Last Edited: 08-NOV-2018
*   Edited 08-NOV-2018: Added displayHand() method
*  Description: A implementation of a "hand" or list of playing cards that
    a player would hold in a myraid of games. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   See attached README file
*/

package cardgames;

import java.util.ArrayList;

public class Hand {
    
    private ArrayList<Card> myCards;
    
    public Hand(){
        myCards = new ArrayList<>();
    }
    
    /** Adds a single card into this hand. The ordering of the cards in the hand
     *  is maintained by always inserting a new card into its sorted location in
     *  hand, much like an Insertion Sort. 
     *  Precondition: myCards is sorted
     * 
     *  @param aCard The card to be added to the hand
     */
    public void addCard(Card aCard){
        boolean cardAdded = false;
        // The size of myCards before adding operations
        int startingSize = myCards.size();
        // The locations where the new card will be inserted
        int index = 0;
        
        // Loop stops if the new card is added to the hand or the card has the 
        // largest value compared to the hand
        while(!cardAdded && index < startingSize){
            if(myCards.get(index).compareTo(aCard) > 0){
                myCards.add(index, aCard);
                // If a card has been added, the loop will terminate
                cardAdded = true;
            }
            // Too big, go to next card in the hand
            index++;
        }
        // In the event the card to be added is larger than all the other cards
        // in the hand, the new card is added to the end of the list
        if(!cardAdded){
            myCards.add(aCard);
        }
    }
    
    /** Empties the contents of this hand, putting them into a list that is 
     *  returned. This is done mainly to complement the way Deck.java is coded. 
     *  The idea is to return all of the cards taken from the deck back. 
     * 
     *  @return ArrayList The list of cards formerly in this hand.  
     */
    public ArrayList<Card> discardAll(){
        ArrayList<Card> discarded = new ArrayList<>();
        for(int i = (myCards.size() - 1); i >= 0; i--) {
            discarded.add(myCards.remove(i));
        }
        return discarded;
    }

    /** Prints the contents of this hand using the image representation of the
     *  cards themselves. The images are provided by the Card class. 
     */
    public void displayHand(){
        // Instantiate a list of the card images, which are themsleves String arrays
        String[][] hand = new String[myCards.size()][Card.IMAGE_SIZE];
        // Populate the array with the card images 
        for(int i = 0; i < myCards.size(); i++){
            hand[i] = myCards.get(i).getImage();
        }
        // Iterate across the String array image and then the cards themselves
        // This is done because output is printed horizontally, so the tops
        // of every card have to be printed first, then the next line of every 
        // card, etc.
        for(int i = 0; i < Card.IMAGE_SIZE; i++){
            for(int j = 0; j < myCards.size(); j++){
                System.out.print(hand[j][i]);
            }
            System.out.println();
        }
    }
    
    // Generic getter
    public ArrayList<Card> getCards(){
        return myCards;
    }
    
    @Override
    /** Provides a readable list of all the cards in this hand. 
     *
     * @return A string representation of all the cards in this hand
     */
    public String toString(){
        String result = "";
        for(Card card : myCards){
            result += (card.toString() + "\n");
        }
        return result;
    } 
}