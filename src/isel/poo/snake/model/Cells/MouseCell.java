package isel.poo.snake.model.Cells;

import isel.poo.snake.model.Position;
import java.util.LinkedList;
import java.util.List;

public class MouseCell extends MovingCells {

    public MouseCell(){ super();
    this.type = 'M';
    }

    @Override
    public List<Position> getNewAdjacentAvailablePosition(Position position) {

        List<Position> adjacentAvailCell = new LinkedList<>();

        Position posUP = correctPosition(new Position(position.getLine() - 1, position.getCol()));
        Position posDown = correctPosition(new Position(position.getLine() + 1, position.getCol()));
        Position posLeft = correctPosition(new Position(position.getLine(), position.getCol() - 1));
        Position posRight = correctPosition(new Position(position.getLine(), position.getCol() + 1));

        //Get freePosition positions
        if(LevelMatrix[posUP.getLine()][posUP.getCol()] == null)
        {
            adjacentAvailCell.add(posUP);
        }
        if(LevelMatrix[posDown.getLine()][posDown.getCol()] == null)
        {
            adjacentAvailCell.add(posDown);
        }
        if(LevelMatrix[posLeft.getLine()][posLeft.getCol()] == null)
        {
            adjacentAvailCell.add(posLeft);
        }
        if(LevelMatrix[posRight.getLine()][posRight.getCol()] == null)
        {
            adjacentAvailCell.add(posRight);
        }

        return adjacentAvailCell;
    }

    @Override
    public void doYourThing(Cell[][] LevelMatrix, int stepCount) {

        this.LevelMatrix = LevelMatrix;

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
