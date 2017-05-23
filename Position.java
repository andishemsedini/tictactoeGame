/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */ 

public class Position {

   private int x;
   private int y;

   public Position() {
   }
   /*Initilizate the field variables 'x' and 'y'
    *@param x
    *@param y
    */
   public Position(int x, int y) {
      this.x = x;
      this.y = y;
   }
    
    /*Returns the value of 'x'
     *@return returns 'x'
     */
   public int getX() {
      return x;
   }

   /*Initilizate the field variable 'x'
    *@param x
    */
   public void setX(int x) {
      this.x = x;
   }

  /*Returns the value of 'y'
    *@return returns 'y'
    */
   public int getY() {
      return y;
   }
   
    /*Initilizate the field variable 'y'
    *@param y
    */
   public void setY(int y) {
      this.y = y;
   }
   
    /*Sets the coordinate from the position
     *@param position
     */
   public void setCoordinateFromPosition(int position) {
      this.x = position / Board.ROWS;
      this.y = position % Board.COLS;
   }
}
