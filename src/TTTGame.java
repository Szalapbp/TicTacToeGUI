public class TTTGame {
    private TTTBoard board;
    private String currentPlayer;

    public TTTGame() {
        this.board = new TTTBoard(3, 3);
        this.currentPlayer = "X";
    }

    public String getCurrentPlayer() {
        return currentPlayer;

    }

    public void switchPlayer(){
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";

    }

    public boolean makeMove(int row, int col) {
        if (board.setTile(row, col, currentPlayer)) {
            if (board.isWin(currentPlayer)) {
                System.out.println("Player " + currentPlayer + " has won!");
                return true;
            }
            if (board.isTie()) {
                System.out.println("It's a tie!");
                return true;
            }
            switchPlayer();
            return false;
        } else {
            System.out.println("Invalid move, please try again");
            return false;
        }
    }


    public void resetGame(){
        board.resetBoard();
        currentPlayer = "X";
    }
}
