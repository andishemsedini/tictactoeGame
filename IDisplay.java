 /*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */
 
 /*Interface
  */
public interface IDisplay
{
   /*Shows the result
    *@param player
    */
   public void showResult(Player player);
   
   
    /*Shows the message
    *@param message
    */
   public void showMessage(String message);

    /*Updates the board
     *@param board
     */
   public void update(Board board);

   /*Gets the next position
    *@param player
    */
   public Position getNextPosition(Player player);

   /*Checks if the player/s want to play anymore
    */
   public boolean wantsToPlayMore();

}
