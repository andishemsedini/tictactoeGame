/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */
public class HumanPlayer extends Player
{

   public IDisplay display;
 
   /*Initializate the field variable 'display'
    *@param symbol 
    *@param display
    */
   public HumanPlayer(char symbol, IDisplay display)
   {
      super(symbol);
      this.display = display;
   }

   /*@Override
    *@param game
    */
   public void move(Game game)
   {
      Position pos = display.getNextPosition(this);
      game.move(pos, this);
   }

}
