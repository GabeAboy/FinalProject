/*
Gabriel Aboy
December 4 2014
CS110 Final Project

   This program is the GUI making the card game war!
   The play can play rouds against the computer
   alternativly they may also have the game play itself
   
   War class adds functionality to make the game
 
*/

import java.util.ArrayList;


public class War
{

   Deck player, computer;
   int roundCount;
   
/**
      Default constructor
*/
   public War()
   {
      player = new Deck();
      computer = player.splitDeck();
      roundCount = 0;
   }
   
//Simulates a round of war @return array of cards used in the round.
   public Card[] round()
   {
      Card[] out;
      if (checkForWinner() == 0)
      {
         ArrayList<Card> playerCard, computerCard;
         playerCard = new ArrayList<Card>();
         computerCard = new ArrayList<Card>();
         boolean isWar = true;
         while (isWar)
         {
            playerCard.add(0, player.dealCard());
            computerCard.add(0, computer.dealCard());
            if (playerCard.get(0).compareTo(computerCard.get(0)) > 0)
            {
//Winner
               player.addCard(computerCard);
               player.addCard(playerCard);
               isWar = false;

            }
            else if (playerCard.get(0).compareTo(computerCard.get(0)) < 0)
            {
//loser
               computer.addCard(playerCard);
               computer.addCard(computerCard);
               isWar = false;
               
            }
            else
            {
//tie making war

               if (player.cardsRemaining() < 2)
               {
//player loses war to computer
                  if (!player.isEmpty())
                  {
                     playerCard.add(0, player.dealCard());
                     computerCard.add(0, computer.dealCard());
                  }
                  computer.addCard(playerCard);
                  computer.addCard(computerCard);
                  isWar = false;
               }
               else if (computer.cardsRemaining() < 2)
               {
//computer loses war to player
                  if (!computer.isEmpty())
                  {
                     playerCard.add(0, player.dealCard());
                     computerCard.add(0, computer.dealCard());
                  }
                  player.addCard(computerCard);
                  player.addCard(playerCard);
                  isWar = false;
               }
               else
               {
                  playerCard.add(0, player.dealCard());
                  computerCard.add(0, computer.dealCard());
               }
            }
         }
         roundCount++;
         out = new Card[playerCard.size() + computerCard.size()];
         int j = 0;
         for (int i = out.length/2-1; i >= 0; i--)
         {
            out[i*2] = playerCard.get(j);
            out[i*2+1] = computerCard.get(j);
            j++;
         }
         return out;
      }
      else
      {
         out = new Card[0];
         return out;
      }
   }
   

//Checks for winner @return 1 for a win and - 1 for computer win 0 = no winner
   public int checkForWinner()
   {
      if (computer.isEmpty())
      {
         return 1;
      }
      else if (player.isEmpty())
      {
         return -1;
      }
      else
      {
         return 0;
      }
   }
   

   
//@return cards remaining
   public int[] getCardSpread()
   {
      int[] spread = new int[2];
      spread[0] = player.cardsRemaining();
      spread[1] = computer.cardsRemaining();
      return spread;
   }
   

//@return round count
   public int getRoundCount()
   {
      return roundCount;
   }
   

//@return toString showing card spead + num of rounds played
   public String toString()
   {
      return "Player: " + getCardSpread()[0] + " Computer: " + getCardSpread()[1] +
         "\nRounds played: " + getRoundCount() + "\n";
   }
}
