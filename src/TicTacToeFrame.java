import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToeFrame extends JFrame
{
    private static final int ROW = 3;
    private static final int COL = 3;
    private TTTGame game;
    private TTTTiles[][] boardButtons;
    JPanel tttPanel;
    JButton quitBtn;
    boolean gameOver;

    public TicTacToeFrame()
    {
        super("Tic Tac Toe");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.game = new TTTGame();
        this.boardButtons = new TTTTiles[ROW][COL];

        tttPanel = new JPanel(new GridLayout(ROW, COL));

        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                TTTTiles button = new TTTTiles(row, col);
                button.setFont(new Font("Arial", Font.BOLD, 35));
                button.setFocusPainted(false);

                button.addActionListener(new ButtonClickListener(row, col));
                boardButtons[row][col] = button;
                tttPanel.add(button);

            }
        }
        this.add(tttPanel, BorderLayout.CENTER);

        quitBtn = new JButton ("Quit");
        quitBtn.addActionListener(e -> System.exit(0));
        this.add(quitBtn, BorderLayout.SOUTH);

        this.setSize(800, 600);
        this.setVisible(true);


    }

    private class ButtonClickListener implements ActionListener
    {
        private final int row;
        private final int col;

        public ButtonClickListener(int row, int col)
        {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            boardButtons[row][col].setText(game.getCurrentPlayer());
            boardButtons[row][col].setEnabled(false);

            gameOver = game.makeMove(row, col);

            if (gameOver) {
                int response = JOptionPane.showConfirmDialog(null, "Play Again?", "Game Over", JOptionPane.YES_NO_OPTION);
                if (response == JOptionPane.YES_OPTION) {
                    game.resetGame();
                    resetBoardUI();
                } else {
                    System.exit(0);
                }
            }
        }
    }
    private void resetBoardUI(){
        for(int row = 0; row < ROW; row++){
            for(int col = 0; col < COL; col++){
                boardButtons[row][col].setText(" ");
                boardButtons[row][col].setEnabled(true);
            }
        }
    }

}
