package isel.poo.snake.model.Cells;

import isel.poo.snake.model.Position;
import isel.poo.snake.model.TheMatrix;

import java.util.LinkedList;
import java.util.List;

public class MouseCell extends MovingCells {

    public MouseCell(TheMatrix theMatrix){
        super(theMatrix);
        }

    @Override
    public List<Position> getNewAdjacentAvailablePosition(Position position) {

        List<Position> adjacentAvailCell = new LinkedList<>();

//        Position posUP = correctPosition(new Position(position.getLine() - 1, position.getCol()));
//        Position posDown = correctPosition(new Position(position.getLine() + 1, position.getCol()));
//        Position posLeft = correctPosition(new Position(position.getLine(), position.getCol() - 1));
//        Position posRight = correctPosition(new Position(position.getLine(), position.getCol() + 1));

        //Get freePosition positions
        if(theMatrix.getCellAt(position.getLine() - 1 , position.getCol()) == null)
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
