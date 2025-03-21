import javax.swing.JButton;

public class TTTTiles extends JButton{
    private final int row;
    private final int col;

    public TTTTiles(int row, int col){
        super(" ");
        this.row = row;
        this.col = col;

    }

    public int getRow(){
        return row;

    }

    public int getCol(){
        return col;
    }


    public void resetTile(){
        this.setText(" ");
        this.setEnabled(true);
    }
}
