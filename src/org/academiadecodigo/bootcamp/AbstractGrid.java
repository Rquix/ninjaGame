package org.academiadecodigo.bootcamp.easterEGG;


/**
 * Created by codecadet on 20/10/2018.
 * Defines an abstract grid to be printed in terminal and blue print the class grid.
 */
public class AbstractGrid {

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
        boolean playableOutput = false;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                output[i][j] = (Math.random()<0.2);
                playableOutput |= output[i][j];
            }
        }
        if(!playableOutput) {
            output = produceRandomGrid();
        }
        return output;
    }



    protected void increaseNumberOfSwitchPresses () {
        numberOfSwitchPresses++;
    }

    protected void init() {
        System.out.println(this);
        showStateOfGameMsg();
    }

    protected boolean sucessCondition () {
        return (sucessDistance() == 0);
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
