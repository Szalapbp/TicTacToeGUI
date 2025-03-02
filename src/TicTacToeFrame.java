import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private JButton[][] board;
    private String currentPlayer;

    public TicTacToeFrame()
    {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.currentPlayer = "X";

        JPanel tttPanel = new JPanel(new GridLayout(ROW, COL));
        board = new JButton[ROW][COL];

        for (int row = 0; row < ROW; row++) {
            for (int col = 0; col < COL; col++) {
                JButton button = new JButton(" ");
                button.setFont(new Font("Arial", Font.BOLD, 35));
                button.setFocusPainted(false);

                button.putClientProperty("row", row);
                button.putClientProperty("col", col);

                button.addActionListener(new ButtonClickListener());
                board[row][col] = button;
                tttPanel.add(button);
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
        @Override
        public void actionPerformed(ActionEvent e)
        {
            JButton clickedButton = (JButton) e.getSource();
            if (!clickedButton.getText().equals(" ")) {
                JOptionPane.showMessageDialog(null, "Invalid move! Try again.");
                return;
            }
            clickedButton.setText(currentPlayer);
            if (isWin(currentPlayer)) {
                JOptionPane.showMessageDialog(null, "Player " + currentPlayer + " wins!");
                resetBoard();
                return;
            }
            if (isTie()) {
                JOptionPane.showMessageDialog(null, "It's a tie!");
                resetBoard();
                return;
            }
            currentPlayer = currentPlayer.equals("X") ? "O" : "X";
        }
    }

    private boolean isWin(String player)
    {
        for (int row = 0; row < 3; row++) {
            if (board[row][0].getText().equals(player) &&
                    board[row][1].getText().equals(player) &&
                    board[row][2].getText().equals(player)) {
                return true;
            }
        }

        for (int col = 0; col < 3; col++) {
            if (board[0][col].getText().equals(player) &&
                    board[1][col].getText().equals(player) &&
                    board[2][col].getText().equals(player)) {
                return true;
            }
        }

        if (board[0][0].getText().equals(player) &&
                board[1][1].getText().equals(player) &&
                board[2][2].getText().equals(player)) {
            return true;
        }
        return board[0][2].getText().equals(player) &&
                board[1][1].getText().equals(player) &&
                board[2][0].getText().equals(player);
    }

    private boolean isTie()
    {
        for (int row = 0; row < 3; row++)
        {
            for (int col = 0; col < 3; col++)
            {
                if (board[row][col].getText().equals(" ")) {
                    return false;
                }
            }
        }
        return true;

    }

    private void resetBoard()
    {
        int response = JOptionPane.showConfirmDialog(null, "Play another game?", "Game Over", JOptionPane.YES_NO_OPTION);
        if (response == JOptionPane.NO_OPTION)
        {
            System.exit(0);
        }
        for (int row = 0; row < ROW; row++)
        {
            for (int col = 0; col < COL; col++)
            {
                board[row][col].setText(" ");
            }
        }
        currentPlayer = "X";

    }




}
