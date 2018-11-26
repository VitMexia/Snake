package isel.poo.snake.model.Cells;

import isel.poo.snake.ctrl.Dir;
import isel.poo.snake.model.Position;
import java.util.List;

//Abstract Class that implements the methods and abstract methods that need to be implemented
//and used by the Snakes and Mouses
public abstract class MovingCells extends Cell {

    private Dir direction;

    public boolean isDead;
    public boolean ateMouse;
    public boolean ateSnake;
    public boolean ateApple;
    public int snakeSize;

    public void setDirection(Dir direction) {
        this.direction = direction;
    }


    public Dir getDirection() {
        return direction;
    }

    //if the position passed as a parameter is outside the "Arena", the position is corrected
    //to the opposite side
    protected Position correctPosition(Position position) {

        Position correctPos = position;

        //Correct Lines
        if(position.getLine() == -1){
            correctPos.setLine(getLineLimit()-1);
        }else if(position.getLine() == getLineLimit()){
            correctPos.setLine(0);
        }
        //Correct Columns
        if(position.getCol() == -1){
            correctPos.setLine(getColLimit()-1);
        }else if(position.getCol() == getColLimit()){
            correctPos.setCol(0);
        }
        return correctPos;
    }

    //abstract method that needs to be implemented to all objects that extend from this class
    public abstract List<Position> getNewAdjacentAvailablePosition(Position position);

    //tells the listener subscribers (Level) that a cell has moved
    protected void moveTo(Position oldPos, Position newPos){
        for (StateChangeListener listener: listeners)
            listener.positionChanged(this, oldPos, newPos);
    }



    //abstract methods and interfaces
    public abstract void doYourThing(Cell[][] LevelMatrix, int stepCount);

    //tells the listener subscribers (Level) that a cell has been removed
    protected void removeCell(Position pos){

        for(StateChangeListener listener : listeners){
            listener.cellRemoved(pos);
        }
    }

    //tells the listener subscribers that a cell has been created
    protected void createCell(Cell cell) {
        for (StateChangeListener listener : listeners) {
            listener.cellCreated(cell);
        }
    }

}
