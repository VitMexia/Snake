package isel.poo.snake.view.CellTiles;

import isel.leic.pg.Console;
import isel.poo.snake.view.CellTiles.CellTile;

public class WallTile extends CellTile {

    public WallTile(){
        setColor(Console.BROWN);
        setC(' ');
    }

}
