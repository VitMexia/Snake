package isel.poo.snake.model;

import isel.poo.snake.model.Cells.Cell;

import java.util.concurrent.CancellationException;

public class MapHolder {

    private Cell[][] cellMap;
    private int height;
    private int width;

    public MapHolder(Cell cell[][]){

        this.cellMap = cell;
        this.height = cell.length;
        this.width = cell[0].length;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }


    public Cell getCellAt(int line, int col) {
        return cellMap[line][col];
    }

    public void setCellAt(Cell cell, Position pos){
        cellMap[pos.getLine()][pos.getCol()] = cell;
    }

    public void clearCellAt(Position pos){
        cellMap[pos.getLine()][pos.getCol()] = null;
    }


    public Cell getCellAt(Position position) {

        Position correctPos = position;
        //Correct Lines
        if(position.getLine() == -1){
            correctPos.setLine(getHeight()-1);
        }else if(position.getLine() == getHeight()){
            correctPos.setLine(0);
        }
        //Correct Columns
        if(position.getCol() == -1){
            correctPos.setLine(getWidth()-1);
        }else if(position.getCol() == getWidth()){
            correctPos.setCol(0);
        }

        return cellMap[position.getLine()][position.getCol()];
    }

}
