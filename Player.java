/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */ 

/*Abstract class
 */
public abstract class Player {

   private final char symbol;

   public Player(char symbol) {
      this.symbol = symbol;
   }
   
   public char getSymbol(){
      return symbol;
   }

   @Override
   public String toString() {
      return ""+symbol; 
   }
   
   public abstract void move(Game game);
}
