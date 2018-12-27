package isel.poo.snake.model;
import isel.poo.snake.model.Cells.Cell;

public interface TheMatrix {

    Cell[][] getLevelMatrix();

    Cell getCellAt(int line, int col);

    Cell getCellAt(Position position);

    int getLineLimit();

    int getColLimit();
}
