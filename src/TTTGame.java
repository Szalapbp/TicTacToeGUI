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
//this switches the player after each play starting with X
    public void switchPlayer(){
        currentPlayer = currentPlayer.equals("X") ? "O" : "X";

    }
// this checks to see if anyone has won the game, if not, it switches the player and continues the game.
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

//This method calls the resetBoard() method and resets the current player to X for next game.
    public void resetGame(){
        board.resetBoard();
        currentPlayer = "X";
    }
}
