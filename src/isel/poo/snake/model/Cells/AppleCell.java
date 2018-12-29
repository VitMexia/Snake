package isel.poo.snake.model.Cells;

import isel.poo.snake.model.MapHolder;
import isel.poo.snake.model.Position;
import java.util.LinkedList;

public class AppleCell extends Cell {

    public AppleCell() {
        super();
    }

    public AppleCell(MapHolder mapHolder) {
        super();
        this.mapHolder = mapHolder;
        setPosition(getNewPosition());
    }

    private Position getNewPosition() {
        LinkedList<Position> freePosList = mapHolder.getEmptyPositions();
       return mapHolder.getRandomAvailablePosition(freePosList);
    }




}
