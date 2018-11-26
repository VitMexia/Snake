package isel.poo.snake.model.Cells;

import isel.poo.snake.model.Position;

import java.util.LinkedList;

public class AppleCell extends Cell {

    public AppleCell() {
        super();
    }

    public AppleCell(Cell[][] LevelMatrix){
        this();
        this.LevelMatrix = LevelMatrix;
        setPosition(getNewPosition());
     }


    private Position getNewPosition() {
        LinkedList<Position> freePosList = getEmptyPositions();
       return getRandomAvailablePosition(freePosList);
    }

    private LinkedList<Position> getEmptyPositions() {

        LinkedList<Position> positions = new LinkedList<>();

        for(int col = 0; col< getColLimit(); col++){
            for(int line = 0; line< getLineLimit(); line++){
                if(LevelMatrix[line][col] == null){
                    positions.add(new Position(line, col));
                }
            }
        }
        return  positions;
    }


}
