
package gameofwar;

import java.util.ArrayList;

/**
 *
 * @author jwright
 */
public class GameOfWar {

    private ArrayList<Card> player1Hand, player2Hand;
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        War game = new War();
        
        while(!game.gameOver())
        {
            game.playHand();
        }
        
        System.out.printf("The winner is %s%n", game.getWinner());
                
        
    }
    
    
    public static void nothingMethod()
    {
        if (1 < 2)
            return;
    }
    
}
