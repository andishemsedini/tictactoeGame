/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */

import java.util.ArrayList;
import java.util.Random;

public class DumbComputerPlayer extends Player {

   public DumbComputerPlayer(char symbol) {
      super(symbol);
   }

   /*@Override
    *@param game
    */
   public void move(Game game) {
      ArrayList<Position> availableToPlay = getAvailablePositions(game);
      if (availableToPlay.size() >= 0) {
         int random = new Random().nextInt(availableToPlay.size());
         game.move(availableToPlay.get(random), this);
      }
   }
     /*
     *@return returns the position
     */
   public ArrayList<Position> getAvailablePositions(Game game) {
      ArrayList<Position> positions = new ArrayList<>();
      Board board = game.getBoard();
      Box[][] boxes = board.getBoxes();
      for (int i = 0; i < boxes.length; i++) {
         for (int j = 0; j < boxes[i].length; j++) {
            if (boxes[i][j].isEmpty()) {
               positions.add(new Position(i, j));
            }
         }
      }
      return positions;
   }
}
