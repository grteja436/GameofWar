/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofwar;

import java.util.ArrayList;
   
/**
 *
 * @author jwright
 */
public class War {
     private ArrayList<Card> p1Hand, p2Hand;
     private DeckOfCards deck;

     public War()
     {
        p1Hand = new ArrayList<>();
        p2Hand = new ArrayList<>();
         
        deck = new DeckOfCards();
        deck.shuffle();
        
        dealCards();       
     }
     
     
     private void dealCards()
     {
        for (int i=0; i<52; i++)
        {
            if (i%2 == 0)
                p1Hand.add(deck.dealTopCard());
            else
                p2Hand.add(deck.dealTopCard());             
        }
     }
     
     
     /**
      * This method will validate if the game is over
      */
     public boolean gameOver()
     {
         return p1Hand.isEmpty() || p2Hand.isEmpty();
     }
     
     /**
      * This method will simulate playing a hand and display the results to the console
      */
     public void playHand()
     {         
        if (!gameOver())
        {
            Card p1Card = p1Hand.remove(0);
            Card p2Card = p2Hand.remove(0);
         
            System.out.printf("Player 1: %s total cards: %d\t\tPlayer 2: %s total cards: %d%n", p1Card, p1Hand.size()+1, p2Card, p2Hand.size()+1);
            
            if (p1Card.getFaceValue() > p2Card.getFaceValue())
            {
                p1Hand.add(p1Card);
                p1Hand.add(p2Card);
            }
            else if (p2Card.getFaceValue() > p1Card.getFaceValue())
            {
                p2Hand.add(p1Card);
                p2Hand.add(p2Card);            
            }
            else   //must be war
            {
                System.out.printf("%n%n~~~~~~~~~~~~ WAR ~~~~~~~~~~~~~~~ %n%n");
                ArrayList<Card> warPile = new ArrayList<>();
                warPile.add(p1Card);
                warPile.add(p2Card);
                playWarHand(warPile);
            }
        }         
     }
     
     public String getWinner()
     {
         if (p1Hand.isEmpty())
             return "player 2";
         else 
             return "player 1";
     }
     
     
     private void playWarHand(ArrayList<Card> warPile)             
     {
         if (p1Hand.size() < 3)
         {
             p2Hand.addAll(p1Hand);
             p1Hand.removeAll(p1Hand);
         }
         else if (p2Hand.size() < 3)
         {
             p1Hand.addAll(p2Hand);
             p2Hand.removeAll(p2Hand);
         }
         else   //both players have enough cards to play the war hand
         {
             warPile.add(p1Hand.remove(0));
             warPile.add(p1Hand.remove(0));
             warPile.add(p2Hand.remove(0));
             warPile.add(p2Hand.remove(0));
          
             Card p1Card = p1Hand.remove(0);
             Card p2Card = p2Hand.remove(0);
             
             if (p1Card.getFaceValue() > p2Card.getFaceValue())
            {
                p1Hand.add(p1Card);
                p1Hand.add(p2Card);
                p1Hand.addAll(warPile);
            }
            else if (p2Card.getFaceValue() > p1Card.getFaceValue())
            {
                p2Hand.add(p1Card);
                p2Hand.add(p2Card);    
                p2Hand.addAll(warPile);
            }
            else   //must be war
            {
                warPile.add(p1Card);
                warPile.add(p2Card);
                playWarHand(warPile); 
            }
         
        }
     }
}
