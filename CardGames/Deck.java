/* Antony Adamovich
*  Deck.java for Homework 3
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 05-NOV-2018 - Last Edited: 08-NOV-2018
*   Edited 08-NOV-2018: Reverted access of cardList to private from protected
*  Description: The Deck class represents a deck of playing cards. This class
*   essentially wraps a pre-built ArrayList and incorporates a getter that allows
*   direct access to this list. One interesting feature of this deck is that,
*   much like its real-life counterpart, it does not keep a list of all possible
*   cards in the deck. Drawing cards from the deck remove them permanently. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   See attached README file
*/
package cardgames;

import java.util.ArrayList;
import java.util.Random;

public class Deck {
    
    private ArrayList<Card> cardList;
    
    // Constructors
    
    public Deck(Card[] aCardList){
        cardList = new ArrayList<Card>();
        for(Card aCard : aCardList){
            cardList.add(aCard);
        }
    }
    
    public Deck(){
        cardList = new ArrayList<Card>();
    }
    
    /** Adds a single card into this deck. 
     * 
     *  @param aCard The card to be added to the deck
     */
    public void addCard(Card aCard){
        cardList.add(aCard);
    }
        
    /** Adds the contents of cards into this deck. 
     * 
     *  @param cards The list of cards to be added into the deck
     */
    public void addCards(ArrayList<Card> cards){
        for(Card aCard : cards){
            cardList.add(aCard);
        }
    }
    
    /** Removes a Card from the top of this deck and returns it.
     * 
     *  @return The card that was removed from this instance of Deck
     */
    public Card draw(){
        return cardList.remove(cardList.size() - 1);
    }
    
    /** Randomizes the contents of this deck. This is done in-place, without the
     *  use of a buffer array. The idea of this method is to mimic the action
     *  of shuffling a deck of cards. 
     */
    public void shuffle(){
        Random generator = new Random();
        // nextIndex tracks the index of the next random card to be picked
        int nextIndex = 0;
        // Used for swapping operations
        Card temp = null;
        // i keeps track of all elements of the list, from 0 to i, that have not
        // been shuffled yet. 
        for(int i = cardList.size(); i > 1; i--){
            nextIndex = generator.nextInt(i);
            // In the event randomly selected index is at the end of list, do nothing
            if (nextIndex != (i - 1)) {
                // Removing from the end of the list
                temp = cardList.remove(i - 1);
                // Moving selected element to new position at end of list
                cardList.add(cardList.get(nextIndex));
                // Putting non-selected number back into "rotation" for selection
                cardList.set(nextIndex, temp);
            
            }   
        }      
    }   
}