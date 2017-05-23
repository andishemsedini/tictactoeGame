/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */ 

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class MessagePanel extends JPanel {

   private int width;
   private int height;

   private String message;
   

   public MessagePanel(int boxSize) {
      width = width * Board.ROWS;
      height = 20;
   }
    
    /*@Override
    *Overirdes the method 'getPreferredSize' from the interface
    *@return returns the dimension
    */
   public Dimension getPreferredSize() {
      return new Dimension(width, height);
   }
  
   /*@Override
    *Overirdes the method 'paintComponent' 
     */
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      if (message != null) {
         g.setColor(Color.red);
         g.drawString(message, 10, 10);
      }
   }
  /*Upadets the drawing - repaint
   *@param message - the message
   */
   public void updateDrawing(String message) {
      this.message = message;
      repaint();
   }

}
