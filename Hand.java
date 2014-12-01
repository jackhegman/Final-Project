/* John Hegman
   CS 110
   Assignment #10
   Deck Class
*/

import java.util.*;
public class Hand extends Deck
{
private ArrayList<Card> deck = new ArrayList<Card>();
private ArrayList<Card> player1;
private ArrayList<Card> player2;
private int HALF = 26;
/**
Splits deck in half and creates 2 hands of cards
*/
public Hand()
{
deck = super.shuffle();
   player1 = new ArrayList<Card>();
   for(int i=0; i<HALF;i++)
   {
   player1.add(deck.get(i));
   }
   
   player2 = new ArrayList<Card>();
   for(int i=HALF; i<deck.size();i++)
   {
   player2.add(deck.get(i));
   }
   
}

/**
Gets the player one arraylist
@return player1 arraylist of player 1 cards
*/
public ArrayList<Card> getPlayerOne()
{
return player1;
}

/**
Gets the player two arraylist
@return player2 arraylist of player 2 cards
*/
public ArrayList<Card> getPlayerTwo()
{
return player2;
}


/**
Returns player 1 top card
@return player1 player 1 top card
*/
public Card showOne()
{
return player1.get(0);
}
              

/**
Returns player 2 top card
@return player2 player 2 top card
*/
public Card showTwo()
{
return player2.get(0);
}

/**
In case of draw gets the second card in hand
@return player1 player 1's second card
*/
public Card showNextOne()
{
return player1.get(1);
}


/**
In case of draw gets the second card in hand
@return player2 player 2's second card
*/
public Card showNextTwo()
{
return player2.get(1);
}


/**
Add player 2 cards to player 1 hand
*/
public void addOne()
{
player1.add(player1.size(),showTwo());//add player two top card to end of player 1 arraylist
player2.remove(0);//remove top card from player 2
Card top = player1.get(0);//get top card from player 1
player1.add(player1.size(),top);//add top card to bottom of player 1 hand
player1.remove(0);//remove top card from top of player1

}

/**
Add player 1 card to player 2 hand
*/
public void addTwo()
{
player2.add(player2.size(),showOne());//add player 1's top card to end of player 2's hand
player1.remove(0);//remove top card of player 1
Card top = player2.get(0);//get top card from player 2
player2.add(player2.size(),top);//add top card to bottom of player 2's hand
player2.remove(0);//remove top card from top of player2's hand
}

/**
If draw after 2nd cards are flipped shuffle each players hand
*/
public void shuffleHand()
{
Collections.shuffle(player1);
Collections.shuffle(player2);
}

/**
Finds card image
@param c card to find image for
@return img string of where image is located
*/
public String find(Card c)
{
int rank = c.getRank();
int suit = c.getSuit();

String r = Integer.toString(rank);

String s;

if(suit == 0)
s = "s";

else if(suit == 1)
s = "c";

else if(suit == 2)
s = "h";

else 
s = "d";

return "cardPics/"+r+s+".jpg";
}

/**
Reset hand to 2 hands of 26 cards
@param h Hand object to be reset
*/
public void reset(Hand h)
{
h.getPlayerOne().clear();
h.getPlayerTwo().clear();

deck = super.shuffle();
   for(int i=0; i<HALF;i++)
   {
   h.getPlayerOne().add(deck.get(i));
   }
   
    
   for(int i=HALF; i<deck.size();i++)
   {
   h.getPlayerTwo().add(deck.get(i));
   }
}


}


