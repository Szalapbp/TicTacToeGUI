public class TTTBoard {
    private final int rows;
    private final int cols;
    private String[][] board;

    public TTTBoard(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.board = new String[rows][cols];
        resetBoard();
    }
//sets all tiles to blank at the start of the game
    public boolean setTile(int row, int col, String player){
        if(board[row][col].equals(" ")){
            board[row][col] = player;
            return true;
        }
        return false;
    }
//This method is checking multiple sections for possible wins, including horizontal row wins, vertical column wins, as well as
    // diagonal wins from top right to bottom left and top left to bottom right
    public boolean isWin(String player) {
        // Check rows
        for (int row = 0; row < rows; row++) {
            boolean win = true;
            for (int col = 0; col < cols; col++) {
                if (!board[row][col].equals(player)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }


        for (int col = 0; col < cols; col++) {
            boolean win = true;
            for (int row = 0; row < rows; row++) {
                if (!board[row][col].equals(player)) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }


        boolean winDiagonal1 = true;
        for (int i = 0; i < rows; i++) {
            if (!board[i][i].equals(player)) {
                winDiagonal1 = false;
                break;
            }
        }


        boolean winDiagonal2 = true;
        for (int i = 0; i < rows; i++) {
            if (!board[i][rows - i - 1].equals(player)) {
                winDiagonal2 = false;
                break;
            }
        }


        return winDiagonal1 || winDiagonal2;
    }

//this method checks to see if the players tied by checking to see if there are no more available tiles to play
    //if there are, the game is not tied, if there is not, the game is tied
    public boolean isTie(){
        for(int row = 0; row<rows; row++){
            for(int col = 0; col<cols; col++){
                if(board[row][col].equals(" ")){
                    return false;
                }
            }
        }
        return true;
    }

    //this method resets the board after game over
    public void resetBoard(){
        for(int row = 0; row < rows; row++){
            for(int col = 0; col < cols; col++){
                board[row][col] = " ";
            }
        }
    }

    public String getTile(int row, int col){
        return board[row][col];
    }
}
