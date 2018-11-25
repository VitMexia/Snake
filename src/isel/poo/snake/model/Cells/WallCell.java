package isel.poo.snake.model.Cells;

import isel.poo.snake.ctrl.Dir;

public class WallCell extends Cell {

    public WallCell() {
        super();
        this.type = 'W';
    }

    @Override
    public void doYourThing(Cell[][] LevelMatrix, int stepCount) {
    }

    @Override
    public Dir getDirection() {
        return null;
    }

    @Override
    public void setDirection(Dir direction) {

    }
}
