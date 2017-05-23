/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */
 
import java.util.LinkedList;
import java.util.Queue;
 
 /*Game class
  */
public class Game
{

   private final Board board;
   private final IDisplay ui;
   private Queue<Player> players = new LinkedList<>();
   private Player currentPlayer;
   private Player winner;
   
   
  /*The initialization of the field variables
   *@param board
   *@param players
   *@param ui
   */
   public Game(Board board, Queue<Player> players, IDisplay ui)
   {
      this.board = board;
      this.ui = ui;
      ui.update(board);
      this.players = players;
   }
   
  /*Moving the positions
   *@param position
   *@param player
   */
   public void move(Position position, Player player)
   {
      if (board.isValidPosition(position)) {
         board.updatePosition(currentPlayer, position);
         ui.update(board);
         if (board.checkWinner()) {
            winner = currentPlayer;
         }
         switchTurn(); // Switches the turn of the player 
      } 
      else {
         ui.showMessage("Pozite jo valide!!!"); // Otherwise the position is not valid
      }
   }

   /*The attendance of the game
    */
   public void play()
   {
      boolean wantsToPlay = true; // If the players want to play another round
      while (wantsToPlay) {
         do {
            currentPlayer = currentPlayer();
            currentPlayer.move(this);
         } while (notOver());
         ui.showResult(winner);
         wantsToPlay = ui.wantsToPlayMore();
         if (wantsToPlay) {     
            reset(); 
            winner = null;          // The game is reseted if the players want to play
         }
         if (wantsToPlay == false) {
            System.exit(0);    // If the players do not want to play anymore windows close
         } 
      }
   }

  /*Resets the game
   */
   public void reset()
   {
      board.reset();
      ui.update(board);
      ui.showMessage(""); 
   }
  
   /*@return returns boolean value
    */
   public boolean notOver()
   {
      return winner == null && board.hasEmptyBoxes(); 
                                                      // If the game is not over yet
   }
   /*switchTurn
    *Switches the turn of the players
    */
   private void switchTurn()
   {
      Player current = players.remove();
      players.add(current);
   }

  /*@return returns the player
   */
   private Player currentPlayer()
   {
      return players.peek();
   }
  /*Main method
  */
   public static void main(String[] args)
   {
      int boardSize = 3;  // The size of board
      int winningScore = 3; // The score to win
      Board board = new Board(boardSize, boardSize, winningScore);
      IDisplay display = new WindowDisplay();
   
      Queue<Player> players = new LinkedList<>();
      players.add(new HumanPlayer('X', display)); // First player: HumanPlayer or DumbComputerPlayer
      players.add(new DumbComputerPlayer('O'));   // Second player: HumanPlayer or DumbComputerPlayer
    //players.add(new HumanPlayer('O', display));
   
      Game tictactoe = new Game(board, players, display);
      tictactoe.play();
   }
   
    /*Board
     *@return returns the board
     */
   public Board getBoard()
   {
      return board;
   }
}
