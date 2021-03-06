package isel.poo.snake.model;

public class Position {

    private int col;
    private int line;

    public Position(int line, int col){
        this.col = col;
        this.line = line;
    }

    public int getCol() {
        return col;
    }

    public int getLine() {
        return line;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setLine(int line) {
        this.line = line;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Position))return false;

        Position pos = (Position) obj;

        if(this.line == pos.line && this.col == pos.col)
            return true;
        return false;

    }

}
