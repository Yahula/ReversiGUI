package TheGame;

/**
 * Created by sagi on 15/01/2018.
 */
public class Disk {
    private int row;
    private int column;
    private int color;

    public Disk(int row, int column, int color) {
        this.row = row;
        this.column = column;
        this.color = color;
    }
    public Disk(Disk d) {
        this.row = d.getRow();
        this.column = d.getColumn();
        this.color = d.getColor();
    }


    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
