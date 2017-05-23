/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */
 
 /*Checks the directions
  */
public class AllDirectionChecker implements IWinnerCheck {

   private Board board;
   private int homeRow, homeCol;
   private Position homePosition;
   private int currentRow, currentCol;// 0
   
   
  /*The constructor AllDirectionChecker
   *@param board
   *The initialization of field variables
   */
   public AllDirectionChecker(Board board) {
      this.board = board;
      this.homePosition = board.getCurrentPosition();
      homeRow = homePosition.getX();
      homeCol = homePosition.getY();
   }

  /*The validation of rows and columns
   *@return returns the result of the validation of rows and columns
   */
   private boolean currentRowColValid() {
      return currentRow >= 0 && currentRow < Board.ROWS && currentCol >= 0 && currentCol < Board.COLS;
   }
   
   /*Checks the direction of X-Direction and Y-Direction
    *@param dirX is X-Direction
    *@param dirY is Y-Direction
    *@return returns the score
    */                  
   public int check(int dirX, int dirY) { // 0    1
      int score = 1;
      goHome();
      move(dirX, dirY);
      while (currentRowColValid() && samePlayer()) {  //while the score is grown till the validation of 
         score++;                                    // rows and columns and the player are true
         move(dirX, dirY);
      }
      goHome();
      
      move(-dirX, -dirY);
      while (currentRowColValid() && samePlayer()) {
         score++;
         move(-dirX, -dirY);
      }
      return score;
   }
   /*Moves the directions
    *@param dirX
    *@param dirY
    */
   public void move(int dirX, int dirY) {
      currentRow += dirX;//1
      currentCol += dirY;//1
   }
   
   /*Sets the currentrow to homerow
    *Sets the currentcolumn to homecolumn
    */
   public void goHome() {
      currentRow = homeRow;
      currentCol = homeCol;
   }
   /*Checks if the next position is played from the same player
    */
   private boolean samePlayer() {
      return board.getBox(currentRow, currentCol).equals(board.getBox(homePosition));
   }
}
