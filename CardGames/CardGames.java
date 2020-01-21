/* Antony Adamovich
*  CardGames.java for Homework 3
*  Prof. Afrand Agah - CSC 240 - West Chester University
*  Created: 05-NOV-2018 - Last Edited: 08-NOV-2018
*  Description: An implementation of the playing card games poker and Blackjack.
*   Poker is included as a separate method while Blackjack is incorporated into
*   the main method. 
*  Resources:
*   The Java Platform API Specification:
*   http://docs.oracle.com/javase/8/docs/api/overview-summary.html
*   https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html 
*   ASCII art for playing cards courtesy of "en Bukkems"
*   retrieved from: http://ascii.co.uk/art/cards
*   See attached README file
*  Definitions:
*   RNG := Random Number Generator
*/
package cardgames;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class CardGames {

    private static void poker(Deck pokerDeck, int n){
        
        // Cards in each hand of poker
        final int CARDS_PER_HAND = 5;
        
        ArrayList<Hand> hands = new ArrayList<>();
        Hand nextHand = null;
        
        // Generate all of the poker hands
        // ! No deck index protection is implemented, meaning entering values that
        // cause the hands to draw more than all the cards out of the deck will
        // crash the program !
        for(int i = 0; i < n; i++){
            nextHand = new Hand();
            // Draw cards from the deck until the hand is full
            for(int j = 0; j < CARDS_PER_HAND; j++){
                nextHand.addCard(pokerDeck.draw());
            }
            // Add generated poker hand to list of hands
            hands.add(nextHand);
        }
        // Print all poker hands
        for(Hand pokerHand : hands){
            pokerHand.displayHand();
            // For spacing
            System.out.println();
            // Discard hands back into deck
            pokerDeck.addCards(pokerHand.discardAll());
        }
        // Shuffle the deck for future games
        pokerDeck.shuffle();
    }
    
    public static void main(String[] args) {
        
        // ---=== CONSTANTS ===---
        
        // Set poker hands here:
        final int POKER_HANDS = 3;
        // Guaranteed Blackjack test hand
        final BlackjackHand ALWAYS_BJ = new BlackjackHand();
        ALWAYS_BJ.addCard(new Card(Rank.ACE, Suit.SPADES));
        ALWAYS_BJ.addCard(new Card(Rank.KING, Suit.SPADES));
        
        // ---=== OBJECTS AND VARIABLES ===---
        
        Deck mainDeck = new Deck();
        // Card hands for Blackjack
        BlackjackHand player = new BlackjackHand();
        BlackjackHand dealer = new BlackjackHand();
        // Input from keyboard
        Scanner reader = new Scanner(System.in);
        // This is set to at least 1 character to avoid out-of-bounds in sentinel loop
        String input = " ";
        Random generator = new Random();
        // This is the card value total the dealer is trying to go for
        // The dealer will keep picking cards until its card total is at least this number
        int dealerGoal = (generator.nextInt(6) + 16);
        
        // ---=== DECK GENERATION ===---
        
        // These two loops generate a standard 52-card deck
        for(Rank r : Rank.values()){
            for(Suit s : Suit.values()){
                mainDeck.addCard(new Card(r, s));
            }
        }
        
        // ---=== GAMING BEGINS ===---
        
        System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");
        System.out.println("Homework 3 Part 1: Poker: ");
        System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");
        poker(mainDeck, POKER_HANDS);
        
        System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");
        System.out.println("Homework 3 Part 2: Blackjack: ");
        System.out.println("=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=~=");
        
        // ---=== DEALER OPERATIONS ===---
        
        // Dealer draws cards until it reaches its goal
        while (dealer.getHandValue() <= dealerGoal){
            dealer.addCard(mainDeck.draw());
        }
        // Dealer information is printed:
        System.out.println("DEALER: ");
        // First dealer card is revealed, all others are face-down
        String[] firstCardImage = dealer.getCards().get(0).getImage();
        for(int i = 0; i < Card.IMAGE_SIZE; i++){
            System.out.print(firstCardImage[i]);
            // Cards to show face-down are based on the dealer's hand, minus
            // the one card that was revealed
            for(int j = 0; j < (dealer.getCards().size() - 1); j++){
                System.out.print(Card.FACE_DOWN[i]);
            }
            // Advance line in String array
            System.out.println();
        }
        
        // ---=== PLAYER OPERATIONS ===---
                
        // Player draws first two cards
        player.addCard(mainDeck.draw());
        player.addCard(mainDeck.draw());
        // !!! FOR PROFESSOR !!! 
        // Un-comment the following line to rig the player to always have a 
        // blackjack hand in the event the RNG is being picky
        //player = ALWAYS_BJ;
        
        // The value of the player's hand, whether or not a hit is desired,
        // and blackjack status are all tracked in this loop
        while((input.charAt(0) != 's' && player.getHandValue() <= 21) && !player.isBlackjack()){
            // Print player hand
            System.out.println("YOUR HAND: ");
            player.displayHand();
            // User prompt
            System.out.println("Your hand total so far: " + player.getHandValue());
            System.out.println("h for hit, s to stand. Press Return after choice is entered. ");
            input = reader.nextLine();
            input = input.toLowerCase();
            // Only a single character is checked, meaning everything but 
            // exactly 's' advances the game 
            if(input.charAt(0) != 's'){
                player.addCard(mainDeck.draw());
            }
        }
        
        // ---=== POST-GAME RESULTS ===---
        
        // Game terminates, some stats are printed
        System.out.println("---=== GAME OVER ===---");
        if(player.getHandValue() > 21){
            // Player loses by default if his/her total is greater than 21
            System.out.println("Your Hand: ");
            player.displayHand();
            System.out.println("Bust!");
        }
        if(player.isBlackjack()){
            // In the event of a blackjack, hand is displayed here as it is skipped in the loop
            System.out.println("Your Hand: ");
            player.displayHand();
            System.out.println("BLACKJACK!");
        }
        // Reveal dealer cards:
        System.out.println("Dealer cards: ");
        dealer.displayHand();
        // Print card totals
        System.out.println("Dealer total: " + dealer.getHandValue());
        System.out.println("Your total: " + player.getHandValue());
    }
}