/*
Gabriel Aboy
December 4 2014
CS110 Final Project

   This program is the GUI making the card game war!
   The play can play rouds against the computer
   alternativly they may also have the game play itself
   
   Creats a deck of 52 cards
*/
import java.util.Random;
import java.util.ArrayList;


public class Deck 
{

   private final int CARDS_IN_DECK = 52;
   private ArrayList<Card> deck;
   
 
//Default constructor

   public Deck()
   {
      freshDeck();
      shuffle();
   }
   


//makes a clean 52 card deck
   public void freshDeck()
   {
      deck = new ArrayList<Card>(CARDS_IN_DECK);
      for (int r = 2; r <= Card.ACE; r++)
      {
         for (int s = Card.SPADES; s <= Card.DIAMONDS; s++)
         {
           deck.add(new Card(s,r));
         }
      }
   }
   

//@returns the top card of the deck
   public Card dealCard()
   {
      Card c = deck.remove(0);
      return c;
   }
   

//adds a card to bottom of deck
   public void addCard(Card other)
   {
      deck.add(other);
   }

//cards to be added back to the deck
   public void addCard(ArrayList<Card> cards)
   {
      for (Card c : cards)
      {
         deck.add(c);
      }
   }

//@return deck.size();
   public int cardsRemaining()
   {  
      return deck.size();
   }
   

//Shuffle deck 
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   

//boolean isempty() returns true 
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   
 
//Makes two decks of 26 from the 52 card deck and @returns other 
   public Deck splitDeck()
   {
      Deck other = new Deck();
      for (int i = 1; i <= CARDS_IN_DECK; i++)
      {
         other.dealCard();
      }
      for (int i = 0; i < (CARDS_IN_DECK/2); i++)
      {
         other.addCard(deck.remove(0));
      }
      return other;
   }
   

//@return toString() returning cards in the deck
   public String toString()
   {
      String out = "";
      for (Card c : deck)
      {
         out += c.toString() + "\n";
      }
      return out;
   }
}
 
