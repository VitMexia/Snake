package isel.poo.snake.model.Cells;

import isel.poo.snake.model.MapHolder;
import isel.poo.snake.model.Position;

public class MouseCell extends MovingCells {

    public MouseCell(){
        super();
    }

    @Override
    public void doYourThing(int stepCount, MapHolder mapHolder) {

        this.mapHolder = mapHolder;

        if(stepCount % 4 == 0 && stepCount != 0){

            Position oldPos = getPosition();
            Position newPos = mapHolder.getRandomAvailablePosition(mapHolder.getNewAdjacentAvailablePosition(oldPos, false));
            if(newPos != null){
                moveTo(oldPos, newPos);
                setPosition(newPos);
            }
        }
    }
}
