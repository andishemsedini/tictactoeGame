 /*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class DialogDisplay extends JFrame implements IDisplay {
 
   /*Sets the title
    */
   public DialogDisplay() {
      setTitle("TicTacToe");
   }

   /*@Override
    */
   public void showMessage(String s) {
      JOptionPane.showMessageDialog(this, s);
   }

   /*@Override
    *Overirdes the method 'update' from the interface
    *@param board
    */
   public void update(Board board) {
      int currRow = 0;
      int currCol = 0;
      StringBuilder sb = new StringBuilder();
      Box[][] boxes = board.getBoxes();
      for (Box[] boxRow : boxes) {
         for (Box box : boxRow) {
            if (box.isEmpty()) {
               sb.append("   ");
            } 
            else {
               sb.append(" ");
               sb.append(box);
               sb.append(" ");
            }
            // nese eshte kolona e fundit mos e shtyp
            if (currCol < boxRow.length - 1) {
               sb.append(" | ");
            }
            currCol++;
         }
         currCol = 0;
         sb.append("\n");
         if (currRow < boxes.length - 1) {
            for (Box box : boxRow) {
               sb.append(" -- ");
            }
            sb.append("\n");
         }
         currRow++;
      }
      sb.append("\n");
      showMessage(sb.toString());
   }

   /*@Override
    *Overrides the method 'showResult' from the interface 
    *@param player
    */
   public void showResult(Player player) {
      if (player != null) {
         showMessage("Fitoi " + player + "\n");
      } 
      else {
         showMessage("Nuk ka fitues kesaj rradhe.");
      }
   }

   /*@Override
    *Overrides the method 'getNextPosition' from the interface 
    *@param player
    *@return returns the position
    */
   public Position getNextPosition(Player player) {
      String input;
   
      Position position = null;
   
      int xPosition;
      int yPosition;
      boolean validInput = false;
      do {
         input = JOptionPane.showInputDialog("'" + player + "', sheno poziten ku luan: ");
         try {
            String[] split = input.split("\\s");
            xPosition = Integer.parseInt(split[0]);
            xPosition--;
         
            yPosition = Integer.parseInt(split[1]);
            yPosition--;
         
            validInput = xPosition >= 0 && xPosition <= Board.ROWS && yPosition >= 0 && yPosition <= Board.COLS;
            if (validInput) {
               position = new Position(xPosition, yPosition);
            }
         } 
         catch (Exception ex) {
         }
      } while (!validInput);
      return position;
   }

  /*@Override
    *Overrides the method 'wantsToPlayMore' from the interface 
    *@return returns the Confirm Dialog  
    */
   public boolean wantsToPlayMore() {
      return JOptionPane.showConfirmDialog(this, "Deshiron te luash prap?", "Zgjedh", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
   }

}
