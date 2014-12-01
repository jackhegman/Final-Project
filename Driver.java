/* John Hegman
   CS 110
   Assignment #10
   War Game Driver
*/
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Driver
{
   public static void main(String[] args) 
   {
    
   JFrame frame = new WarFrame("Game of War");
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(800,600);
   frame.setVisible(true);
   
   
   Hand h = new Hand();
   
   while((h.getPlayerOne()).size() != 0 && (h.getPlayerTwo()).size() != 0)
   {
      
      Card player1 = h.showOne();
      Card player2 = h.showTwo();
         if(player1.getRank() > player2.getRank())
         {
         h.addOne();
         }
         else if(player1.getRank() < player2.getRank())
         {
         h.addTwo();
         }
         
         else
         {
         try{
         Card draw = h.showNextOne();
         Card draw1 = h.showNextTwo();
            
            if(draw.getRank() > draw1.getRank())
            {
            h.addOne();
            h.addOne();
            }
            else if(draw.getRank() < draw1.getRank())
            {
            h.addTwo();
            h.addTwo();
            }
            else
            h.shuffleHand();
         }
            catch(IndexOutOfBoundsException e)
            {
            if((h.getPlayerOne()).size() == 1)
               h.addTwo();
            else if((h.getPlayerTwo()).size() == 1)
               h.addOne();
             }
         }
      
   
   }
   
      if((h.getPlayerOne()).size()== 52)
         System.out.println("Player One Wins!");
      else if((h.getPlayerTwo()).size() == 52)
         System.out.println("Player Two Wins!");
   
   
   }
}