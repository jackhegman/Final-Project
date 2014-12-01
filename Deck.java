/* John Hegman
   CS 110
   Assignment #10
   Deck Class
*/
import java.util.*;
public class Deck extends Card
{
private ArrayList<Card> deck;
   
/**
No-arg constructor
Creates a deck of card objects with 52 different cards
*/
public Deck()
{
deck = new ArrayList<Card>();
   
    for(int i=2;i<=14;i++)
    {
    Card spade = new Card(0,i);
    deck.add(spade);
    Card clubs = new Card(1,i);
    deck.add(clubs);
    Card heart = new Card(2,i);
    deck.add(heart);
    Card diamond = new Card(3,i);
    deck.add(diamond);
    }
    
}

/**
Returns the shuffled deck of 52 cards
@return deck the shuffled deck
*/   
public ArrayList<Card> shuffle()
{
Collections.shuffle(deck);
return deck;
}

/**
returns the deck of 52 cards
@return deck the deck of 52 cards
*/
public ArrayList<Card> getDeck()
{
return deck;
}


}