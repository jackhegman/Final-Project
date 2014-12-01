/* John Hegman
   CS 110
   Assignment #10
   WarFrame class
*/
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class WarFrame extends JFrame
{
//declare panels
private JPanel buttonPanel, Player1, Player2, title, info, centerPanel;
   
//declare buttons
private JButton flip, startOver, endGame;
//declare labels for title, info, and card icons
private JLabel draw1,draw2,info1, info2, winner, pic, pic2, welcome, picBack, pic2Back;
//declare image icons
private ImageIcon drawPic1, drawPic2, front, back, back2, front2;

/**
Creates game of war frame
@param s name of frame
*/
public WarFrame(String s) 
  {
    //inherit s from JFrame
    super(s);
      
    
      
   //set initial layout
    setLayout(new BorderLayout());
      
   //create instance of buttons
    flip = new JButton("Flip");
    startOver = new JButton("Start Over");
    endGame = new JButton("End Game");  
      
    //create and add panels 
    centerPanel = new JPanel(new FlowLayout());
    add(centerPanel,BorderLayout.CENTER);
      
    buttonPanel = new JPanel(new GridLayout(3,1));
	 add(buttonPanel,BorderLayout.EAST);
      
	 Player1 = new JPanel(new FlowLayout());
	 centerPanel.add(Player1);
      
	 Player2 = new JPanel(new FlowLayout());
	 centerPanel.add(Player2);
      
	 title = new JPanel(new FlowLayout());
	 add(title,BorderLayout.NORTH);
      
	 info = new JPanel(new GridLayout(3,1));
	 add(info,BorderLayout.SOUTH);
      
    //set panel colors
    buttonPanel.setBackground(Color.RED);
	 Player1.setBackground(Color.GREEN);
	 Player2.setBackground(Color.BLUE);
	 title.setBackground(Color.WHITE);
	 info.setBackground(Color.WHITE);
      
      //display labels
    welcome = new JLabel("Welcome to Jack's Java War Game!");
	 welcome.setHorizontalAlignment(JLabel.CENTER);
	 welcome.setForeground(Color.BLACK);
    title.add(welcome);

    //create button listeners
    flip.addActionListener(new ButtonListener());
    startOver.addActionListener(new ButtonListener());
    endGame.addActionListener(new ButtonListener());

      
    //add buttons to panels
    buttonPanel.add(flip);
    buttonPanel.add(startOver);
    buttonPanel.add(endGame);  
      
      
    //create image icons
    back = new ImageIcon("cardPics/back.jpg");
    back2 = new ImageIcon("cardPics/back.jpg");
    
    
    info1 = new JLabel();//new label for info panel
    info1.setHorizontalAlignment(JLabel.CENTER);//cetner text
    info1.setForeground(Color.BLUE);////set color to blue
    
    info2 = new JLabel();//new label for info panel
    info2.setHorizontalAlignment(JLabel.CENTER);
    info2.setForeground(Color.BLUE);
    
    draw1 = new JLabel();//new label for a draw
    draw2 = new JLabel();//new label for a draw
    
    winner = new JLabel();//new label to display when someone wins
    winner.setHorizontalAlignment(JLabel.CENTER);
    winner.setForeground(Color.BLUE);
      
    pic = new JLabel();//new label for pics of cards
    picBack = new JLabel(back);
      
    pic2 = new JLabel();//new label for pics of cards
    pic2Back = new JLabel(back2);
      
      
    Player1.add(pic);        //print back card
    Player1.add(picBack);   //print first card in hand
      
    Player2.add(pic2Back);  //print first card in hand
    Player2.add(pic2);       //print back card
   }


Hand h = new Hand();
class ButtonListener implements ActionListener{
   public void actionPerformed (ActionEvent e) 
      {
    if(e.getSource()== flip){
      
      drawPic1 = new ImageIcon();//set draw card to blank
      draw1.setIcon(drawPic1);
      Player1.add(draw1);//add to player1 panel
      
      drawPic2 = new ImageIcon();//set draw card to blank
      draw2.setIcon(drawPic2);
      Player2.add(draw2);//set to player2 panel
       
      Card player1 = h.showOne();//get the top card on deck
      front = new ImageIcon(getClass().getResource(h.find(player1)));//find the image of card
      pic.setIcon(front);//set icon to label
      Player1.add(pic);//add to player1 panel
      
      
      Card player2 = h.showTwo();//get player 2 card
      front2 = new ImageIcon(getClass().getResource(h.find(player2)));//find player 2 image
      pic2.setIcon(front2);//set icon to label
      Player2.add(pic2);//add to player2 panel
      
         
         if(player1.getRank() > player2.getRank())
         {
         h.addOne();//add card to p1 deck if p1 card is bigger
         winner.setText("Player One Wins Hand");//set text 
         info.add(winner);//add label to info panel
         }
         else if(player1.getRank() < player2.getRank())
         {
         h.addTwo();//add card to p2 deck if p2 card is bigger
         winner.setText("Player Two Wins Hand");
         info.add(winner);//add to info panel
         }
         
         else //if it is a draw
         {
         try{
         Card draw = h.showNextOne();//get next card in deck
         drawPic1 = new ImageIcon(getClass().getResource(h.find(draw)));//find image of card
         draw1.setIcon(drawPic1);
         Player1.add(draw1);//add card to player 1 panel
         
         
         Card draw1 = h.showNextTwo();//get next card in deck
         drawPic2 = new ImageIcon(getClass().getResource(h.find(draw1)));//find image
         draw2.setIcon(drawPic2);
         Player2.add(draw2);//add card image to player2 panel
         
            
            if(draw.getRank() > draw1.getRank())
            {
            h.addOne();//add card to p1
            h.addOne();//add card to p1
            winner.setText("Tie, Player One Wins Hand on Second Card");
            info.add(winner);//add label
            }
            else if(draw.getRank() < draw1.getRank())
            {
            h.addTwo();//add card to p2
            h.addTwo();//add card to p2
            winner.setText("Tie, Player Two Wins Hand on Second Card");
            info.add(winner);//add label
            }
            
            else
            {
            h.shuffleHand();//if tie on second card shufle each person's deck
            winner.setText("Tie On Both Cards, Shuffle Each Person's Deck");
            info.add(winner);
            }
         }
            catch(IndexOutOfBoundsException i)//catch exception out of bounds
            {                                 //if getNext method is called and a 
                                              //player only has 1 card in their, catch exception and give their one card to the other player
            
            if((h.getPlayerOne()).size() == 1)//if only one card left
               h.addTwo();
            else if((h.getPlayerTwo()).size() == 1)//if only one card left
               h.addOne();
             }
         }
      
      info1.setText("Player One has "+(h.getPlayerOne()).size()+" cards");
      info.add(info1);//add label to info panel
      
      info2.setText("Player Two has "+(h.getPlayerTwo()).size()+" cards");
      info.add(info2);//add label to info panel
   
      if((h.getPlayerOne()).size()== 52)
      {
      winner.setText("Player Two Out Of Cards! Player One Wins Game!");
      info.add(winner);//add winner label
      disableAll();//disable flip button
      }
      
      else if((h.getPlayerTwo()).size() == 52)
      {
      winner.setText("Player One Out Of Cards! Player Two Wins Game!");
      info.add(winner);//add winner label 
      disableAll();//disable flip button
      }
    }
    else if(e.getSource() == startOver){ //if start over pushed
    flip.setEnabled(true);//set flip button enabled
    h.reset(h);//reset hand
    front = new ImageIcon();//set front to blank
    pic.setIcon(front);
    
    front2 = new ImageIcon(); //set front to blank 
    pic2.setIcon(front2);
    
    drawPic1 = new ImageIcon();//set draw card to blank
    draw1.setIcon(drawPic1);
    Player1.add(draw1);//add to player1 panel
      
    drawPic2 = new ImageIcon();//set draw card to blank
    draw2.setIcon(drawPic2);
    Player2.add(draw2);//set to player2 panel
    
    info1.setText("");//set labels to blank
    info2.setText("");
    winner.setText("");
      
    Player1.add(pic);//add blank for front
    info.add(info1);//add blank labels
    info.add(info2);
    info.add(winner);  
    Player2.add(pic2);//add blank for front
    }
    else if(e.getSource() == endGame)
    {
    disableAll();//disable flip button
    info1.setText("Game Over. Click Start Over to play again");
    info2.setText("");//set blank label
    winner.setText("");
    
    info.add(info1);//add label
    info.add(info2);//blank
    info.add(winner);//blank
    }
  }
}
    /**
    Disable flip button when someone wins
    */
    private void disableAll()
    {
    flip.setEnabled(false);//disable flip button
    }

}