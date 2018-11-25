package isel.poo.snake.model.Cells;

import isel.poo.snake.ctrl.Dir;

public class DeadCell extends Cell {

    public DeadCell() {
        super();
        this.type = 'D';
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
