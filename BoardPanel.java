/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JPanel;

public class BoardPanel extends JPanel {

   private Board board;
   private int width;
   private int height;

   private int boxWidth;
   private int boxHeight;

  /*Sets the sizes of width, height, boxWidth, boxHeight
   *@param boxSize - the size of box
   *initinialization of the field variables
   */
   public BoardPanel(int boxSize) {
      width = boxSize * Board.ROWS + 20;
      height = boxSize * Board.COLS + 20;
   
      boxWidth = width / Board.ROWS;
      boxHeight = height / Board.COLS;
   }

   /*@Override
    *@return returns the dimension
    */
   public Dimension getPreferredSize() {
      return new Dimension(width, height);
   }

   /*@Override
    *Overrides the paintComponent method
    */
   protected void paintComponent(Graphics g) {
      super.paintComponent(g);
      g.setColor(Color.white);
      g.fillRect(0, 0, getWidth(), getHeight());
      g.setColor(Color.black);
      
      int position = 1;
      for (int i = 0; i < Board.ROWS; i++) {
         for (int j = 0; j < Board.COLS; j++) {
            int boxX = i * boxWidth;
            int boxY = j * boxHeight;
            g.setColor(Color.black);
            g.drawRect(boxX, boxY, boxWidth, boxHeight);
            g.setColor(Color.gray);
            g.drawString("" + position, boxY+5,boxX+15);
            position++;
            if (board != null) {
               
               g.setColor(Color.red);
               g.drawString(board.getBox(i, j).toString(), boxY + boxHeight / 2, boxX + boxWidth / 2);
               
            }
         }
      }
   }
    /*Updates the drawing - repaint
     *@param board
     */
   public void updateDrawing(Board board) {
      this.board = board;
      repaint();
   }

}
