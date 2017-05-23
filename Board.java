/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */
public class Board
{

   private Box[][] boxes;
   public static int ROWS;
   public static int COLS;
   private Position currentPosition;
   private int winningScore;
   
   /*The constructor Board 
    *@param rows - rows of the board
    *@param cols - columns of the board
    *@param winningScore - the score set to win
    */
   public Board(int rows, int cols, int winningScore)
   {
      ROWS = rows;
      COLS = cols;
      this.winningScore = winningScore;
      boxes = new Box[ROWS][COLS];
      for (int row = 0; row < ROWS; row++) {
         for (int col = 0; col < COLS; col++) {
            boxes[row][col] = new Box();
         }
      }
   }
  
  /*Checks if there are empty boxes
   *@return returns false
   */
   public boolean hasEmptyBoxes()
   {
      for (Box[] rowBox : boxes) {
         for (Box box : rowBox) {
            if (box.isEmpty()) {
               return true;
            }
         }
      }
      return false;
   }

  /*Checks if the position is a valid position
   *@param position checks the validition of that position
   *@return returns the result of the validation of the position
   */
   public boolean isValidPosition(Position position)
   {
      return getBox(position).isEmpty();
   }
    
   /*Checks if there is any winner in each position (all directions)
    *@return returns the result of the existence of the winner
    */
   public boolean checkWinner()
   {
      AllDirectionChecker checker = new AllDirectionChecker(this);
   
      int score = checker.check(0, 1);
      if (score >= winningScore) {
         return true;
      }
   
      score = checker.check(1, 0);
      if (score >= winningScore) {
         return true;
      }
   
      score = checker.check(1, 1);
      if (score >= winningScore) {
         return true;
      }
   
      score = checker.check(-1, -1);
      if (score >= winningScore) {
         return true;
      }
   
      score = checker.check(-1, 1);
      if (score >= winningScore) {
         return true;
      }
      return false;
   }
    /*Rests rows and columns
     */
   public void reset()
   {
      for (int row = 0; row < ROWS; row++) {
         for (int column = 0; column < COLS; column++) {
            boxes[row][column].clear();
         }
      }
   }
  
   /*Sets the current position
    *@param currentPosition is the current position
    */
   public void setCurrentPosition(Position currentPosition)
   {
      this.currentPosition = currentPosition;
   }

   /*Gets the current position
    *@return returns the current position
    */
   public Position getCurrentPosition()
   {
      return currentPosition;
   }
   
   /*Gets the position of the box and returns it
    *@param position sets the position of the box
    *@return returns the position of the box
    */
   public Box getBox(Position position)
   {
      return boxes[position.getX()][position.getY()];
   }
   /*Accepts a positon and returns a corresponding box
    *@param x
    *@param y
    *@return returns the position
    */
   public Box getBox(int x, int y)
   {
      Position temp = new Position(x, y);
      return getBox(temp);
   }
   
   /* Updates the position
    *@param player - the player
    *@param position - the position
    */
   public void updatePosition(Player player, Position position)
   {
      getBox(position).setPlayer(player);
      setCurrentPosition(position);
   }
   
    /*Gets the boxes and returns them
     *@return returns the boxes
     */
   public Box[][] getBoxes()
   {
      return boxes;
   }
}
