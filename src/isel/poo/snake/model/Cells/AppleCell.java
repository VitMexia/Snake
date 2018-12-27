package isel.poo.snake.model.Cells;

import isel.poo.snake.model.Level;
import isel.poo.snake.model.Position;
import isel.poo.snake.model.TheMatrix;

import java.util.LinkedList;

public class AppleCell extends Cell {

    public AppleCell() {
        super();
    }


    public AppleCell(TheMatrix theMatrix){
        super(theMatrix);
        setPosition(getNewPosition());
    }


    private Position getNewPosition() {
        LinkedList<Position> freePosList = getEmptyPositions();
       return getRandomAvailablePosition(freePosList);
    }

    private LinkedList<Position> getEmptyPositions() {

        LinkedList<Position> positions = new LinkedList<>();

        for(int col = 0; col< theMatrix.getColLimit(); col++){
            for(int line = 0; line< theMatrix.getLineLimit(); line++){
                if(theMatrix.getCellAt(line, col) == null){
                    positions.add(new Position(line, col));
                }
            }
        }
        return  positions;
    }


}
