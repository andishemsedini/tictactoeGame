/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */

public class ComputerPlayer extends Player {

   Game game;
   Position[][] pos = new Position[3][3];
  
   /*The Computerplayer
    *@param symbol - the symbol 
    */
   public ComputerPlayer(char symbol) {
      super(symbol);
   }

   /*@Override
    *Overrides the 'move' method from the Interface
    *@param game
    */
   public void move(Game game) {
   
   }
  
    /*Gets the availible position and returns them
     *@return returns the availible positions
     */
   public Position[][] getAvailablePositions() {
   
      Board board = game.getBoard();
      Box[][] boxes = board.getBoxes();
      for (int i = 0; i < boxes.length; i++) {
         for (int j = 0; j < boxes[i].length; j++) {
            if (boxes[i][j].isEmpty()) {
               pos[i][j] = new Position(i, j);
            }
         }
      }
   
      return null;
   }

}
