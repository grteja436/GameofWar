/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameofwar;

import java.security.SecureRandom;
import java.util.ArrayList;

/**
 *
 * @author jwright
 */
public class DeckOfCards {
    private ArrayList<Card> deck;
    
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        String[] suits = {"hearts", "diamonds", "clubs","spades"};
        String[] faceNames = {"two","three","four","five","six","seven","eight","nine","ten","jack","queen","king","ace"};
        
        for (String suit : suits)
        {
            for (int i = 0; i<faceNames.length; i++)
            {
                Card newCard = new Card(faceNames[i], suit, i+2);
                deck.add(newCard);
            }
        }
    }
    
    /**
     * This method will remove the top card from the deck and return it to the calling function
     */
    public Card dealTopCard()
    {
        if (deck.size()>0)
            return deck.remove(0);
        return null;
    }
    
    /**
     * This returns the size of the Deck of Cards
     */
    public int getSizeOfDeck()
    {
        return deck.size();
    }
    
    /**
     * This method will "shuffle" the deck of cards
     */
    public void shuffle()
    {
        SecureRandom rng = new SecureRandom();
        for (int i=0; i < 52; i++)
        {
            Card swapCard = deck.remove(rng.nextInt(52));
            deck.add(i, swapCard);
        }
    }
    
    /**
     * This method will return the deck of cards as a String
     */
    public String toString()
    {
        String deckAsString = "";
        for (Card card: deck)
        {
            deckAsString = String.format(deckAsString + card.toString() + "%n");
        }
        
        return deckAsString;
    }
    
    public void anotherSillyMethod()
    {
        return;
    }
}
