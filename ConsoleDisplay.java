/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */

import java.util.Scanner;

public class ConsoleDisplay implements IDisplay {

   private Scanner in;
   
   /*Initinializate the 'in' field variable
    */
   public ConsoleDisplay() {
      in = new Scanner(System.in);
   }

   /*@Override
    *Overrides the 'showMessage' method from the Interface
    *@param s 
    */
   public void showMessage(String s) {
      System.out.print(s);
   }

  /*@Override
    *Overrides the 'update' method from the Interface
    *@param board
    */
   public void update(Board board) {
      int currRow = 0;
      int currCol = 0;
      StringBuilder sb = new StringBuilder();
      Box[][] boxes = board.getBoxes();
      int index = 1;
      for (Box[] boxRow : boxes) {
         for (Box box : boxRow) {
            if (box.isEmpty()) {
               sb.append(" ");
               sb.append(index);
               sb.append(" ");
            } 
            else {
               sb.append(" ");
               sb.append(box);
               sb.append(" ");
            }
            index++;
            
            if (currCol < boxRow.length - 1) {
               sb.append("|");
            }
            currCol++;
         }
         currCol = 0;
         sb.append("\n");
         if (currRow < boxes.length - 1) {
            sb.append("-----------");
            sb.append("\n");
         }
         currRow++;
      }
      sb.append("\n");
      showMessage(sb.toString());
   }

   /*@Override
    *Overrides the 'showResult' method from the Interface
    *@param player
    */
   public void showResult(Player player) {
      if (player != null) {
         showMessage("Fitoi " + player + "\n");
      } 
      else {
         showMessage("Nuk ka fitues kesaj rradhe.");
      }
      showMessage("=======================================\n");
   }

   /*@Override
    *Overrides the 'getNextPosition' method from the Interface
    *@param player
    *@return returns the position
    */
   public Position getNextPosition(Player player) {
      showMessage("'" + player + "', sheno poziten ku luan: ");
      Position position = null;
   
      int oneDimPosition;
      boolean validInput;
      do {
         oneDimPosition = in.nextInt();
         oneDimPosition--;
      
         in.nextLine();
         validInput = oneDimPosition >= 0 && (oneDimPosition <= Board.ROWS * Board.COLS);
         if (validInput) {
            position = new Position();
            position.setCoordinateFromPosition(oneDimPosition);
         }
         else{
            showMessage("Pozite jo valide! Sheno edhe nje here.");
         }
      } while (!validInput);
      return position;
   }

   /*@Override
    *Overrides the 'wantsToPlayMore' method from the Interface
    *@return returns the answer
    */
   public boolean wantsToPlayMore() {
      boolean vazhdo = true;
      String line;
      do {
         showMessage("Deshiron te luash prap (Y/N)?\n");
         line = in.nextLine();
         if (line.length() > 0) {
            line = line.substring(0, 1);
            if (line.equalsIgnoreCase("Y") || line.equalsIgnoreCase("N")) {
               vazhdo = false;
            } 
            else {
               showMessage("Hyrja eshte gabim sheno Y ose N!!\n");
            }
         }
      } while (vazhdo);
      return line.equalsIgnoreCase("Y");
   }
}
