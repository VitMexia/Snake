package isel.poo.snake.model.Cells;

import isel.poo.snake.model.Position;
import isel.poo.snake.model.TheMatrix;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Cell {


    private Position position;
    public char type; // used to simplify the need to understand cell types S- SnakeCell, B-BodyCell, W-WallCell, A-AppleCell, D-DeadCell, M-MouseCell
    private final Random random = new Random();
    public boolean isBad;
    protected List<StateChangeListener> listeners;
    protected TheMatrix theMatrix;

    //public Cell[][] LevelMatrix;

    public Cell()
    {
        listeners = new ArrayList<>();
    }

    public Cell(TheMatrix theMatrix){
        super();
        this.theMatrix = theMatrix;
    }

    //Produce a random position of a provided list of positions
    protected Position getRandomAvailablePosition(List<Position> list){
        if(list.size() >0) {
            return list.remove(random.nextInt(list.size()));
        }
        return null;
    }


    //Sets the Cell position by receiving a position
    public void setPosition(Position position){
        this.position=position;
    }

    //Sets the Cell position by receiving a line and a column
    public void setPosition(int l, int c) {
        this.position = new Position(l, c);
    }

    //return Cell current Position
    public Position getPosition(){
        return position;
    }

    //creates a new cell depending on the char receive
    public static Cell newInstance(char type) {

        switch (type){
            case '@': return new SnakeCells();
            case 'A': return new AppleCell();
            case 'X': return new WallCell();
            case '#': return new BodyCell();
            case 'M': return new MouseCell();
            case '*': return new SnakeCells(true);
            default: return null;
        }
    }

    //creates a new Apple on an empty position
    //public static Cell getApple(Cell[][] LevelMatrix) {
//        return new AppleCell(LevelMatrix);
//    }

    public static Cell getApple(TheMatrix theMatrix) {
        return new AppleCell(theMatrix);
    }

    //Adds a listener to the array
    public void addListener(StateChangeListener stateChangeListener) {
        listeners.add(stateChangeListener);
    }

    public void removeListener(StateChangeListener stateChangeListener) {
        listeners.remove(stateChangeListener);
    }

    //interface that sets the contract to be implemented on who needs to know about Cell changes (Level)
    public interface StateChangeListener {
        void positionChanged(Cell source, Position oldPos, Position newPos);
        void cellRemoved(Position posToRemove);
        void cellCreated(Cell cell);

    }



}
