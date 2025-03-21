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

    public boolean setTile(int row, int col, String player){
        if(board[row][col].equals(" ")){
            board[row][col] = player;
            return true;
        }
        return false;
    }

    public boolean isWin(String player) {
        for(int row = 0; row<rows; row++){
            boolean win = true;
            for(int col = 0; col<cols; col++){
                if(board[row][col].equals(player)){
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }
        }
        for(int col = 0; col<cols; col++){
            boolean win = true;
            for(int row = 0; row<rows; row++){
                if(!board[row][col].equals(player)){
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }

        }
        boolean winDiagonal1 = true;
        boolean winDiagonal2 = true;
        for(int i = 0; i < rows; i++){
            if(!board[i][i].equals(player)) {
                winDiagonal1 = false;
            }
            if (!board[i][rows - i - 1].equals(player)) {
                winDiagonal2 = false;
            }
        }
        return winDiagonal1 || winDiagonal2;
    }
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
