/*
Gabriel Aboy
December 4 2014
CS110 Final Project

   This program is the GUI making the card game war!
   The play can play rouds against the computer
   alternativly they may also have the game play itself
   
   Generic cards with rank and suit.
*/

public class Card
{

   public final static int SPADES = 1, CLUBS = 2, HEARTS = 3, DIAMONDS = 4;
   public final static int ACE = 14, JACK = 11, QUEEN = 12, KING = 13;
   private int rank, suit;
   
   
//constructor sets the suit and rank


   public Card (int suit, int rank)
   {
      if (suit < 1 || suit > 4)
      {
         this.suit = 1;
      }
      else
      {
         this.suit = suit;
      }
      if (rank < 2 || rank > 14)
      {
         this.rank = 2;
      }
      else
      {
         this.rank = rank;
      }
   }
   

//@return cards suit
   public int getSuit()
   {
      return suit;
   }

//@return cards rank
   public int getRank()
   {
      return rank;
   }
   

//@return toString() with card suit and ranked
   public String toString()
   {
      String out = "Suit: ";
      switch (suit)
      {
         case SPADES:
            out += "Spades";
            break;
         case CLUBS:
            out += "Clubs";
            break;
         case HEARTS:
            out += "Hearts";
            break;
         case DIAMONDS:
            out += "Diamonds";
      }
      out += "\tRank: ";
      switch (rank)
      {
         case ACE:
            out += "Ace";
            break;
         case 2:
            out += "2";
            break;
         case 3:
            out += "3";
            break;
         case 4:
            out += "4";
            break;
         case 5:
            out += "5";
            break;
         case 6:
            out += "6";
            break;
         case 7:
            out += "7";
            break;
         case 8:
            out += "8";
            break;
         case 9:
            out += "9";
            break;
         case 10:
            out += "10";
            break;
         case JACK:
            out += "Jack";
            break;
         case QUEEN:
            out += "Queen";
            break;
         case KING:
            out += "King";
      }
      return out;
   }
   

//compare ranks of two cards
//check if equal return boolean

   public boolean equals(Card other)
   {
      if (getRank() == other.getRank())
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   

//compares the rank of two cards
//@return 1 if card 1 is greater than card 2
//@return -1 if card 1 is less than card 2
//@return 0 if cards ==
   public int compareTo(Card other)
   {
      if (getRank() > other.getRank())
      {
         return 1;
      }
      else if (getRank() < other.getRank())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
}
