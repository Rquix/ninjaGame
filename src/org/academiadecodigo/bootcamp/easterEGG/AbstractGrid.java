package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.awt.*;

/**
 * Created by codecadet on 20/10/2018.
 */
public class AbstractGrid implements KeyboardHandler{

    private int width;
    private int height;
    private boolean[][] abstractGrid;
    private AbstractCursor abstractCursor;
    private int numberOfSwitchPresses;


    public AbstractGrid(int width, int height) {
        this.width = width;
        this.height = height;
        this.abstractCursor = new AbstractCursor(0,0);
        this.abstractGrid = produceRandomGrid();
        this.numberOfSwitchPresses = 0;
    }

    private boolean[][] produceRandomGrid() {

        boolean[][] output = new boolean[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                output[i][j] = (Math.random()<0.2);
            }
        }
        return output;
    }

    public void start(){

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent paint = new KeyboardEvent();
        paint.setKey(KeyboardEvent.KEY_P);
        paint.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(paint);

        KeyboardEvent save = new KeyboardEvent();
        save.setKey(KeyboardEvent.KEY_S);
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(save);

        this.init();

        while (!sucessCondition()) {

        }

        return;



    }





    protected void init() {
        System.out.println(this);
        showStateOfGameMsg();
    }

    //To simplify after create sucessDistance method
    protected boolean sucessCondition () {
        return (sucessDistance() == 0);
        /*
        boolean output = false;
        for (boolean[] row: abstractGrid) {
            for (boolean cellValue : row) {
                output = output || cellValue;
            }
        }
        return output;
        */
    }

    protected int sucessDistance () {
        int output = 0;
        for (int i=0; i < width; i++) {
            for (int j=0; j < height; j++) {
                if (toPressCell(i,j)) {
                    output++;
                }
            }
        }
        return output;
    }

    protected boolean toPressCell (int colunn, int row) {
        boolean output = false;
        for (int i = 0; i < width ; i++) {
            output = (output & !abstractGrid[i][row]) | (!output & abstractGrid[i][row]);
        }
        for (int j = 0; j < height ; j++) {
            if (j!=row) {
                output = (output & !abstractGrid[colunn][j]) | (!output & abstractGrid[colunn][j]);
            }
        }
        return output;
    }


    protected boolean moveCursorRight() {
        if (abstractCursor.getColunn() < width-1) {
            abstractCursor.moveRight();
            return true;
        }
        return false;
    }

    protected boolean moveCursorLeft() {
        if (abstractCursor.getColunn() > 0) {
            abstractCursor.moveLeft();
            return true;
        }
        return false;
    }

    protected boolean moveCursorDown() {
        if (abstractCursor.getRow() < height-1) {
            abstractCursor.moveDown();
            return true;
        }
        return false;
    }

    protected boolean moveCursorUp() {
        if (abstractCursor.getRow() > 0) {
            abstractCursor.moveUp();
            return true;
        }
        return false;
    }

    protected void changeStateOfCells() {
        int colunn = abstractCursor.getColunn();
        int row = abstractCursor.getRow();
        for (int i = 0; i < width ; i++) {
            abstractGrid[i][row] = !abstractGrid[i][row];
        }
        for (int j = 0; j < height ; j++) {
            if (j!=row) {
                abstractGrid[colunn][j] = !abstractGrid[colunn][j];
            }
        }
    }

    public void showStateOfGameMsg() {
        System.out.println(stateOfGameMsg());
    }

    public String stateOfGameMsg() {
        String msg = "You have'd made " + numberOfSwitchPresses + " changes and have at least " + sucessDistance() + " to do.";
        if(sucessCondition()) {
            msg = "Congratulations! You win!!";
        }
        return msg;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                moveCursorLeft();
                System.out.println(this);
                break;
            case KeyboardEvent.KEY_RIGHT:
                moveCursorRight();
                System.out.println(this);
                break;
            case KeyboardEvent.KEY_DOWN:
                moveCursorDown();
                System.out.println(this);
                break;
            case KeyboardEvent.KEY_UP:
                moveCursorUp();
                System.out.println(this);
                break;
            case KeyboardEvent.KEY_P:
                changeStateOfCells();
                numberOfSwitchPresses++;
                System.out.println(this);
                showStateOfGameMsg();
                break;
            default:
                System.out.println("We have a problem");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}

    //Getters and Setters
    public int getWidth() {
        return width;
    }


    public int getHeight() {
        return height;
    }

    public boolean[][] getAbstractGrid() {
        return abstractGrid;
    }

    public AbstractCursor getAbstractCursor() {
        return abstractCursor;
    }


    //ToString method
    @Override
    public String toString() {
        String output = "";
        for (int j = 0; j < height ; j++) {
            for (int i = 0; i < width ; i++) {
                output = output  + (((abstractCursor.getColunn() == i) && (abstractCursor.getRow()==j))?"<":" ")
                        + (abstractGrid[i][j] ? "X" : "O") + (((abstractCursor.getColunn() == i) && (abstractCursor.getRow()==j))?">":" ");
            }
            output = output + "\n";

        }
        return output;
    }

}
