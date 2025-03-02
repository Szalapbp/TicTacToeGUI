import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private TicTacToeTile[][] board;
    private String currentPlayer;

    public TicTacToeFrame()
    {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.currentPlayer = "X";

        JPanel tttPanel = new JPanel(new GridLayout(ROW,COL));
        board = new TicTacToeTile[ROW][COL];
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                board[row][col] = new TicTacToeTile(row, col);
                board[row][col].setFont(new Font("Arial", Font.BOLD, 35));
                board[row][col].setFocusPainted(false);
                board[row][col].setText(" ");
                board[row][col].addActionListener(new ButtonClickListener());
                tttPanel.add(board[row][col]);
            }
        }

        this.add(tttPanel, BorderLayout.CENTER);

        JButton quitBtn = new JButton("QUIT");

        quitBtn.addActionListener(e -> System.exit(0));
        this.add(quitBtn, BorderLayout.SOUTH);

        this.setSize(800, 600);
        this.setVisible(true);

    }

    private class ButtonClickListener implements ActionListener{
        public void actionPerformed(ActionEvent e)
        {
            TicTacToeTile clickedButton = (TicTacToeTile) e.getSource();
            if(!clickedButton.getText().equals(" "))
            {
                JOptionPane.showMessageDialog(null, "Invalid Move!");

            }
            clickedButton.setText(currentPlayer);
            if(isWin(currentPlayer))
            {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                resetBoard();
            }
            if(isTie())
            {
                JOptionPane.showMessageDialog(null, "It's a tie!!");
                resetBoard();
            }

            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
    }

    private boolean isWin(String player)
    {

        return false;
    }

    private boolean isTie()
    {

        return false;

    }

    private void resetBoard()
    {
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                board[row][col].setText(" ");
            }
        }
        currentPlayer = "X";

    }




}
