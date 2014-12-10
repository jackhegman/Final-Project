/* John Hegman
   CS 110
   Assignment #10
   Card Class
*/
public class Card
{
private final int rank;
private final int suit;

public static enum  Suit{
   SPADES(0),
   CLUBS(1),
   HEARTS(2),
   DIAMONDS(3);
}

public static enum  Suit{
   ACE(14),
   JACK (11), 
   QUEEN (12), 
   KING (13);
}


/**
Default constructor sets rank and suit to null
*/
public Card()
{
suit = 0;
rank = 0;

}

/**
Accepts suit and rank
@param suit suit of card
@param rank rank of card
*/
public Card(int suit, int rank)
{
this.suit = suit;
this.rank = rank;
}

/**
gets the suit of a card
@return suit, returns the suit of card
*/
public int getSuit()
{
return suit;
}

/**
gets the rank of a card
@return rank, returns rank of card
*/
public int getRank()
{
return rank;
}


/**
converts rank and suit to a string
@return r, rank string
@return s, suit string
*/
public String toString()
{
    String r = " ", s = " ";
    if (getRank() <= 10 && getRank() > 1 )//if 2-10 print 2-10
       r = rank +"" ;
       
    else if (getRank() == ACE)//if 1 print Ace
      r = "Ace";
    else if (getRank() == KING)//if 11 print King     
       r = "King";  
    else if (getRank() == QUEEN)//if 12 print Queen     
       r = "Queen";
    else if (getRank() == JACK)//if 13 print Jack
       r = "Jack";
    
    
    if (getSuit() == SPADES)//get suit and set string to suit
      s = "Spades";
    else if (getSuit() == CLUBS)
      s = "Clubs";
    else if (getSuit() == HEARTS)
      s = "Hearts";
    else if (getSuit() == DIAMONDS)
       s = "Diamonds";

    return r + " of " + s;//return string
}    

/**
checks to see if one card equals another
@param otherCard otherCard, card object to compare to
@return status, returns status of true or false
*/
public boolean equals(Card otherCard)
{
boolean status;

   if (rank == otherCard.getRank())
   status = true;
   else
   status = false;

return status;  
}

}
