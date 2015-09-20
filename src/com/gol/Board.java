package com.gol;

import java.util.ArrayList;
import java.awt.Point;
import java.util.Arrays;

public class Board {
    int width, height;
    Cell[][] board;

    public Board(int width, int height, ArrayList<Point> init){
        this.width = width;
        this.height = height;

        this.board = new Cell[width][height];
        initBoard();
        initGameState(init);
    }

    private void initBoard(){
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                this.board[i][j] = new Cell('X');
            }
        }
    }

    private void initGameState(ArrayList<Point> startState){
        Point p;

        for(int i = 0; i < startState.size(); i++){
            p = startState.get(i);
            System.out.println("x = " + p.getX());
            System.out.println("y = " + p.getY());
            this.board[((int) p.getX())][(int) p.getY()].setStatus('#');
        }
    }

    public int numberOfNeighbors(int x, int y){

        int neighbors = 0;
        try {
            if (this.board[x - 1][y - 1].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x-1][y].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x-1][y+1].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x][y-1].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x][y+1].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x+1][y-1].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x+1][y].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}
        try{
            if(this.board[x+1][y+1].getStatus() == '#')
                neighbors++;
        }catch (ArrayIndexOutOfBoundsException e){}

        return neighbors;
    }

    /* RULES

       Any live cell with fewer than two live neighbours dies, as if caused by under-population.
       Any live cell with two or three live neighbours lives on to the next generation.
       Any live cell with more than three live neighbours dies, as if by overcrowding.
       Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

    */
    private void enforceRules(Cell[][] someBoard, int x, int y){
        int neighbors = numberOfNeighbors(x,y);
        switch (neighbors){
            case 0:
                someBoard[x][y].setStatus('X');
                break;
            case 1:
                someBoard[x][y].setStatus('X');
                break;
            case 2:
                someBoard[x][y].setStatus(this.board[x][y].getStatus());
                break;
            case 3:
                someBoard[x][y].setStatus('#');
                break;
            default:
                someBoard[x][y].setStatus('X');
                break;
        }
    }
    public void printBoard(){
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                System.out.print(this.board[i][j].getStatus());
            }
            System.out.println();
        }
    }

    public void refreshBoard(){
        Cell[][] newBoard = new Cell[this.width][this.height];
        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                newBoard[i][j] = new Cell('X');
            }
        }

        for(int i = 0; i < this.width; i++){
            for(int j = 0; j < this.height; j++){
                enforceRules(newBoard, i, j);
            }
        }

        this.board = cloneArray(newBoard);
    }

    public static Cell[][] cloneArray(Cell[][] src) {
        int length = src.length;
        Cell[][] target = new Cell[length][src[0].length];
        for (int i = 0; i < length; i++) {
            System.arraycopy(src[i], 0, target[i], 0, src[i].length);
        }
        return target;
    }
}
