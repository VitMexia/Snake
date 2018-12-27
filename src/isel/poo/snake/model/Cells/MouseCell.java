package isel.poo.snake.model.Cells;

import isel.poo.snake.ctrl.Dir;
import isel.poo.snake.model.Position;
import isel.poo.snake.model.TheMatrix;

import java.util.LinkedList;
import java.util.List;

public class MouseCell extends MovingCells {

    public MouseCell(){
        super();
    }

    public MouseCell(TheMatrix theMatrix){
        super(theMatrix);
        }

    @Override
    public List<Position> getNewAdjacentAvailablePosition(Position position) {

        List<Position> adjacentAvailCell = new LinkedList<>();

        for (Dir d: Dir.values()) {
            if(theMatrix.getCellAt(position.getLine() + d.line, position.getCol() + d.column) == null)
            {
                adjacentAvailCell.add(new Position(position.getLine() + d.line, position.getCol() + d.column));
            }
        }

        return adjacentAvailCell;
    }

    @Override
    public void doYourThing(int stepCount) {

        if(stepCount % 4 == 0 && stepCount != 0){

            Position oldPos = getPosition();
            Position newPos = getRandomAvailablePosition(getNewAdjacentAvailablePosition(oldPos));
            if(newPos != null){
                moveTo(oldPos, newPos);
                setPosition(newPos);
            }
        }
    }
}
