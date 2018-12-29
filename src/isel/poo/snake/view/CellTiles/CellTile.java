package isel.poo.snake.view.CellTiles;

import isel.leic.pg.Console;
import isel.poo.console.tile.Tile;
import isel.poo.snake.model.Cells.*;

import static isel.leic.pg.Console.setForeground;


public abstract class CellTile extends Tile{

    public final static int SIDE = 1;
    private int color;
    private int foregroundColor;
    private char c;


    public void setColor(int color) {
        this.color = color;
    }

    public void setForegroundColor(int color){this.foregroundColor = color;}

    public void setC(char c) {
        this.c = c;
    }

    public CellTile(){
        this.c = ' ';
        this.color = Console.LIGHT_GRAY;
    }

    public static CellTile tileOf(Cell cell) {

        if(cell == null){
            return new EmptyTile();
        }
        else if(cell instanceof SnakeCells && !((SnakeCells)cell).isBad){
            return new HeadTile();
        }
        else if(cell instanceof DeadCell && !((DeadCell)cell).isBad){
            return new DeadTile();
        }
        else if(cell instanceof BodyCell){
            return new BodyTile();
        }
        else if(cell instanceof AppleCell){
            return new AppleTile();
        }
        else if(cell instanceof WallCell){
            return new WallTile();
        }
        else if(cell instanceof MouseCell){
            return new MouseTile();
        }
        else if(cell instanceof SnakeCells && ((SnakeCells)cell).isBad){
            return new BadSnakeTile();
        }
        else if(cell instanceof DeadCell && ((DeadCell)cell).isBad){
            return new BadDeadTile();
        }
        return null;
    }

    @Override
    public void paint() {
        setForeground(this.foregroundColor);
        print(0,0, this.c);
    }

    @Override
    public void setBackground(int color) {
        super.setBackground(this.color);
    }
}
