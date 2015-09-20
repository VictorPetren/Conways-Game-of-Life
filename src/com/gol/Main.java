package com.gol;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        ArrayList<Point> initialCells = new ArrayList<Point>();

        /*Scanner sc = new Scanner(System.in);

        //Read initial live cells
        int x, y;
        Point p = new Point();

        while(true){
            System.out.println("Enter x coordinate for cell or 99 if finished");
            x = sc.nextInt();
            if (x == 99) break;

            System.out.println("Enter y coordinate for cell");
            y = sc.nextInt();

            p.setLocation(x, y);
            initialCells.add(p);
        }*/

        /* BLINKER PRESET */

        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();

        p1.setLocation(0,1);
        p2.setLocation(1,1);
        p3.setLocation(2,1);

        initialCells.add(p1);
        initialCells.add(p2);
        initialCells.add(p3);

        /* GLIDER PRESET */
        /*
        Point p1 = new Point();
        Point p2 = new Point();
        Point p3 = new Point();
        Point p4 = new Point();
        Point p5 = new Point();

        p1.setLocation(0,2);
        p2.setLocation(1,2);
        p3.setLocation(2,2);
        p4.setLocation(2,1);
        p5.setLocation(1,0);

        initialCells.add(p1);
        initialCells.add(p2);
        initialCells.add(p3);
        initialCells.add(p4);
        initialCells.add(p5);
        */

        Board myBoard = new Board(10, 22, initialCells);

        //Run game
        myBoard.printBoard();
        System.out.println(' ');

        while(true){

            myBoard.refreshBoard();
            myBoard.printBoard();
            System.out.println(' ');

            try{
                Thread.sleep(500);
            }catch(InterruptedException ex){
            }
        }
    }
}
