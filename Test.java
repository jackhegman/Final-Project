/* John Hegman
   CS 110
   Assignment #10
   War Game Tester
*/
import javax.swing.*;
import java.awt.*;
import java.util.*;
public class Test
{
   public static void main(String[] args) 
   {
   JFrame frame = new WarFrame("Game of War");//create new war game frame
   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   frame.setSize(1200,1000);//set size
   frame.setVisible(true);//set visible
   }
}