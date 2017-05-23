/*TicTacToe
 *The TicTacToeGame
 *@author AndiShemsedini
 *@version 1.0
 */ 
import java.awt.BorderLayout;
import java.awt.Container;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class WindowDisplay extends JFrame implements IDisplay
{

   private MessagePanel pnlMessage;
   private BoardPanel pnlBoard;
   private int boxSize = 50;
   
  
   public WindowDisplay()
   {
      setTitle("TicTacToe");
   
      Container content = getContentPane();
      content.setLayout(new BorderLayout());
   
      pnlBoard = new BoardPanel(boxSize);
      content.add(pnlBoard, BorderLayout.NORTH);
   
      pnlMessage = new MessagePanel(boxSize);
      content.add(pnlMessage, BorderLayout.SOUTH);
   
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      pack();
      setLocation(100, 100);
      setVisible(true);
   }

   @Override
   public void showMessage(String s)
   {
      pnlMessage.updateDrawing(s);
   }

   @Override
   public void update(Board board)
   {
      pnlBoard.updateDrawing(board);
   }

   @Override
   public void showResult(Player player)
   {
      if (player != null) {
         showMessage("Fitoi " + player + "\n");
      } 
      else {
         showMessage("Nuk ka fitues kesaj rradhe.");
      }
   }

   @Override
   public Position getNextPosition(Player player)
   {
      String input;
   
      Position position = null;
   
      int oneDimPosition;
      boolean validInput = false;
      do {
         input = JOptionPane.showInputDialog("'" + player + "', sheno poziten ku luan: ");
         try {
            oneDimPosition = Integer.parseInt(input);
            oneDimPosition--;
         
            validInput = oneDimPosition >= 0 && (oneDimPosition <= Board.ROWS * Board.COLS);
            if (validInput) {
               position = new Position();
               position.setCoordinateFromPosition(oneDimPosition);
            }
         } 
         catch (NumberFormatException ex) {
         }
      } while (!validInput);
      return position;
   }

   @Override
   public boolean wantsToPlayMore()
   {
      return JOptionPane.showConfirmDialog(null, "Deshiron te luash prap?", "Zgjedh", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;
   }

}
