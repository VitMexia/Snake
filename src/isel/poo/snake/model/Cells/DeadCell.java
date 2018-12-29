package isel.poo.snake.model.Cells;


import isel.poo.snake.model.MapHolder;

import java.util.LinkedList;

public class DeadCell extends MovingCells {

    public boolean isBad;
    protected LinkedList<BodyCell> bodyList;

    public DeadCell() {
        super();

    }

    @Override
    public void doYourThing(int stepCount, MapHolder mapHolder) {

        if(bodyList.size()>0)
            removeCell(bodyList.removeLast().getPosition());

    }

    public int getSize(){
        return bodyList.size();
    }


}
