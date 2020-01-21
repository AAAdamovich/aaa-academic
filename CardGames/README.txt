Antony Adamovich
README for Homework #3
Prof. Afrand Agah - CSC 240 - West Chester University
08-NOV-2018

I got a bit carried away coding this project. I had this silly idea of implement a graphics interface for
the appearance of the playing cards. Of course, I did not have enough time to do this, but the idea stuck
with me. Instead, I found some ASCII character art to represent the playing cards in the two games. The 
aesthetic of the two games was rather important to me, so even though I coded toString() methods for the 
cards as I'm sure was originally intended by the specifications, printing these statements was omitted
as I think the ASCII art images do a good job of representing the cards in the program. I included the 
author and a legend here for disambiguation:

	  Hearts  Diamonds Spades   Clubs
        ____    ____    ____    ____
       |2   |  |A   |  |Q   |  |K   |
       |(\/)|  | /\ |  | /\ |  | &  |
       | \/ |  | \/ |  |(__)|  |&|& |     
       |   2|  |   A|  | /\Q|  | | K|     en Bukkems
       `----`  `----'  `----'  `----'  

Sadly, most of my time went into representing the cards in this visual representation as I wanted to automate
the generation of these images instead of hard-coding all 52 possibilities into the program. My experiment
was purpose-built, but a success. What helped me out the most during this project was my usage of 
enumerated types for the suit and rank (pip) of the playing cards. On my first day of coding the project,
I was able to generate a iterable and search-able deck of 52 cards using 3 lines of code. The power of
enums was impressive and I am happy to finally learn them and incorporate them into a project. 

See line 134 of the driver class (CardGames.java) for a fixed way to generate a Blackjack in the event
that the random number generator does not provide one in a timely fashion. 

10:50 PM on the due date, and I ran the program one extra time to verify everything worked correctly. 
Ace, Jack, but no blackjack. Spent the next half hour tracking down the problem in a program that
has gotten quite big. Found it in the BlackjackHand handValue calculation subroutine, hopefully
that was the last bug in the program. One of the rare cases where seeding the random number generator 
with a fixed value was extremely helpful. Seeding both random number generators in the driver class
(CardGames.java) and Deck.java with the integer 10 will also produce a blackjack hand. 

Highlight of this project was the random number generator crashing the program after over 50 test runs. 
The generator exposed an out-of-bounds exception that I had neglected to cover in the addCard method of 
Deck. It was comical to see the program suddenly crash after 20 straight successful runs with no code
changed. I hope the professor enjoys the presentation of my program as I had a lot of fun making it. 
Definitely the highlight of this semester. 