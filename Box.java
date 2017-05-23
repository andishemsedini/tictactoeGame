/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */
 
public class Box {

   private Player player;
   private Player noPlayer = new NoPlayer();

  /*Resets the player to the default value
   */
   public void clear() {
      player = null;
   }

  /*Checks if the player is null
   *@return returns the result
   */
   public boolean isEmpty() {
      return player == null;
   }

   /*Checks the player and returns it
    *@return returns the player
    */
   public Player getPlayer() {
      if (player == null) {
         return noPlayer;
      }
      return player;
   }

   /*Sets the player
    *@param player - the player
    */
   public void setPlayer(Player player) {
      this.player = player;
   }

   /*@Override
    *@return returns the (toString) 
    */
   public String toString() {
      return player == null ? "" : player.toString();
   }
   
   /*Compares two objects
    *@param o 
    */
   public boolean equals(Object o) {
      if (o == null) {
         return false;
      }
      if (!this.isEmpty()) {
         if (o instanceof Box) {
            Box other = (Box) o;
            if (!other.isEmpty()) {
               return this.getPlayer().equals(other.getPlayer());
            }
         }
      }
      return false;
   }

}
