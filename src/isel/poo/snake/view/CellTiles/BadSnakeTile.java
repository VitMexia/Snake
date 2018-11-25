package isel.poo.snake.view.CellTiles;
import isel.leic.pg.Console;

public class BadSnakeTile extends CellTile {
    public BadSnakeTile(){
        setColor(Console.GRAY);
        setForegroundColor(Console.BLACK);
        setC('@');

    }
}
