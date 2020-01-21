/* Antony Adamovich
*  BlackjackHand.java for Homework 3
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 08-NOV-2018 - Last Edited: 08-NOV-2018
*  Description: Similar to the Hand class, this implements a few additional
    technicalities to adhere to the rules of Blackjack. 
*  Resources:
*   The Java Platform API Specification
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html 
*   See attached README file
*/

package cardgames;

public class BlackjackHand extends Hand{
    
    private int handValue;
    
    public BlackjackHand(){
        super();
        handValue = 0;
    }
    
    @Override
    /** Adds a single card into this hand. handValue is updated through this
     *  method, and is accordingly updated if an Ace is present in the hand that
     *  will not bring the handValue above 21. 
     * 
     *  @param aCard The card to be added to the hand
     */
    public void addCard(Card aCard){
        super.addCard(aCard);
        // Update hand value with addition of new card
        handValue += aCard.blackjackValue();
        // A card has been added, is it an Ace and the hand value is less than 12?
        if(handValue <= 11 && (aCard.getRank().compareTo(Rank.ACE) == 0)){
            // In this case, add an additional 10 to the handValue to "balance"
            // the value. The Ace is worth 11 in this case but value management
            // is done in this class and not in the Card class, where the value
            // of the Ace is always 1
            handValue += 10;
        }
        // Has the value of the hand gone over 21 and an Ace is present in the hand?
        if(handValue > 21 && hasAce()){
            // If so, recalculate hand value setting all Aces at 1
            handValue = 0;
            for(Card card : getCards()){
                handValue += card.blackjackValue();
            }
        }
    }
    
    // Generic getter
    public int getHandValue(){
        return handValue;
    }
    
    /** Detects the presence of a card with the Rank.ACE property in the hand. 
     * 
     *  @return true if an Ace is present in the hand, false otherwise
     */
    private boolean hasAce(){
        for(Card card : getCards()){
            if(card.getRank().compareTo(Rank.ACE) == 0){
                return true;
            }
        }
        return false;
    }
    
    /** Reports the state of this hand as being a "Blackjack." This means that
     *  One card is an Ace, and the other has a value of 10, bringing the 
     *  handValue to 21 with two cards. 
     * 
     *  @return true if the hand is a blackjack, false otherwise
     */
    public boolean isBlackjack(){
        /*  In order for the hand to be a Blackjack, one card has to be an ace,
         *  and the other a card with a value of 10. In this case, if we check
         *  that only 2 cards are present in the hand and one of them is an ace,
         *  it must be the case that the other card has a value of 10.
         */ 
        return (getCards().size() == 2 && handValue == 21) &&
                ((getCards().get(0).getRank().compareTo(Rank.ACE) == 0) ||
                (getCards().get(1).getRank().compareTo(Rank.ACE) == 0));
    }
}
