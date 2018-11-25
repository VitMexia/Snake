package isel.poo.snake.model.Cells;

import isel.poo.snake.ctrl.Dir;

public class BodyCell extends Cell{

    public BodyCell() {
        super();
        this.type = 'B';
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
