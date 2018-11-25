package isel.poo.snake.model;

import isel.poo.snake.ctrl.Dir;
import isel.poo.snake.model.Cells.*;
import java.util.LinkedList;

public class Level {

    private int levelNumber, height, width, appleCount, startApples;
    public Cell[][] lMatrix;
    private LinkedList<Cell> otherPlayers;
    private Cell playerHead;
    private int playerSize;
    private Game game;
    private boolean finish;
    private Observer updater;
    private int stepCount;

    public Level(int levelNumber, int height, int width) {

        this.levelNumber = levelNumber;
        this.height = height;
        this.width = width;
        this.lMatrix = new Cell[height][width];
        this.appleCount = 10;//TODO: Correct to 10

        otherPlayers = new LinkedList<>();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getNumber() {
        return levelNumber;
    }

    public int getRemainingApples() {
        return appleCount;
    }

    public Cell getCell(int l, int c) {
        return  lMatrix[l][c];
    }

    public void setObserver(Observer updater) {
        this.updater = updater;
    }

    public boolean isFinished() {
        return finish;
    }

    public boolean snakeIsDead() {
        return playerHead.isDead;
    }

    public void step() {

        //goes through the list of mouses and Bad Snakes and each one does its thing
        for (Cell others: otherPlayers) {
            if(!others.isDead) others.doYourThing(lMatrix, stepCount);
            else otherPlayers.remove(others);

            if(others.ateApple) {
                checkMeal(others); //if snake ate apple, a new apple will be generated
            }
        }

        playerSize = playerHead.snakeSize;
        playerHead.doYourThing(lMatrix, stepCount);
        checkMeal(playerHead); // checks what the player ate and acts accordingly

        if(appleCount == 0 ){
            finish = true;
            return;
        }

        if(playerHead.isDead){
            finish = true;
            return;
        }
        stepCount += 1;

        if(stepCount % 10 == 0 && stepCount>0){
            game.addScore(-1);
        }

    }

    //checks was was eaten by each snake (player or BadASnake) and adds score and requests a new apple when required
    private void checkMeal(Cell cell) {

            if (cell.ateApple) {
                if(!cell.isBad) {
                    appleCount -= 1;
                    game.addScore(4);
                    updater.applesUpdated(appleCount);
                }

                AddApples(cell);
                cell.ateApple = false;
            }
            else if (cell.ateMouse) {
                cell.ateMouse = false;
                if(!cell.isBad) {
                    game.addScore(10);
                }
            }
            else if (cell.ateSnake) {
                cell.ateSnake = false;
                if(!cell.isBad) {
                    game.addScore(10 + 2*playerSize);
                }
            }
    }

    //Requests Cell Class to generate an apple on a free position
    private void AddApples(Cell cell) {

        if(appleCount >= startApples || cell.isBad ){
            Cell apple = Cell.getApple(lMatrix) ;
            updater.cellCreated(apple.getPosition().getLine(), apple.getPosition().getCol(), apple);
            lMatrix[apple.getPosition().getLine()][apple.getPosition().getCol()] = apple;

        }
    }

    //sets the snake Direction based on user input
    public void setSnakeDirection(Dir dir) {

        switch (dir){
            case UP: if(playerHead.getDirection() != Dir.DOWN ) playerHead.setDirection(dir); break;
            case DOWN:if(playerHead.getDirection() != Dir.UP ) playerHead.setDirection(dir); break;
            case RIGHT:if(playerHead.getDirection() != Dir.LEFT ) playerHead.setDirection(dir); break;
            case LEFT:if(playerHead.getDirection() != Dir.RIGHT ) playerHead.setDirection(dir); break;
        }
    }

    //based on Cell type property defines the player and other players (Bad Snakes and Mouses);
    //it also sets the start apples quantity
    public void putCell(int l, int c, Cell cell) {


        if(cell.type == 'S' && !cell.isBad){
            playerHead = cell;
        }
        else if(cell.type == 'S' && cell.isBad){

            otherPlayers.add(cell);
        }
        else if(cell.type == 'A'){
            startApples +=1;
        }
        else if(cell.type == 'M'){
            otherPlayers.add(0, cell);
        }

        cell.setPosition(l,c);

        lMatrix[l][c] = cell;
    }

    public interface Observer {
        public void cellUpdated(int l, int c, Cell cell); //its never used in this implementation
        public void cellCreated(int l, int c, Cell cell);
        public void cellRemoved(int l, int c);
        public void cellMoved(int fromL, int fromC, int toL, int toC, Cell cell);
        public void applesUpdated(int apples);
    }

    public void init(Game game){

        this.game = game;
        initBehaviour();
    }

    //initializes the listener list and implements the Cell StateChangeListener interface
    private void initBehaviour() {

        Cell.StateChangeListener listener = new MovingCells.StateChangeListener() {

            @Override
            public void positionChanged(Cell source, Position oldPos, Position newPos) {
                updater.cellMoved(oldPos.getLine(), oldPos.getCol(),newPos.getLine(), newPos.getCol(), source );
                lMatrix[oldPos.getLine()][oldPos.getCol()] = null;
                lMatrix[newPos.getLine()][newPos.getCol()] = source;

            }

            @Override
            public void cellRemoved(Position posToRemove) {
                updater.cellRemoved(posToRemove.getLine(), posToRemove.getCol());
                lMatrix[posToRemove.getLine()][posToRemove.getCol()] = null;
            }

            @Override
            public void cellCreated(Cell cell) {
                updater.cellCreated(cell.getPosition().getLine(), cell.getPosition().getCol(), cell); //add where head wa
                lMatrix[cell.getPosition().getLine()][cell.getPosition().getCol()] = cell;
            }


        };

         playerHead.addListener(listener);
         for (Cell cell : otherPlayers) {
             cell.addListener(listener);
        }
    }

}
