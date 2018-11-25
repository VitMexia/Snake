package isel.poo.snake.view.CellTiles;

import isel.leic.pg.Console;

public class DeadTile extends CellTile {

    public DeadTile(){
        setColor(Console.YELLOW);
        setC('X');
    }
}
