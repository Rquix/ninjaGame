package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.graphics.Text;

/**
 * Created by codecadet on 19/10/2018.
 */
public class Grid extends AbstractGrid {
    private final int GRID_PADDING = 10;
    private final int CELL_PADDING = 20;
    private final int INNER_CELL_SIZE = 50;
    private Cursor cursor;
    //private CircleBinaryObject[][] circleBinaryObjects;
    private BinaryObject[][] binaryObjects;
    private Text stateOfGameDisplay;

    public Grid(int width, int height) {
        super(width, height);
        this.cursor = new Cursor(getAbstractCursor().getColunn(),getAbstractCursor().getRow(),GRID_PADDING,
                2*CELL_PADDING+INNER_CELL_SIZE,2*CELL_PADDING+INNER_CELL_SIZE);
        this.binaryObjects = changeAbstractGridToCircleBinaryObject();
        this.stateOfGameDisplay = new Text(2*CELL_PADDING,CELL_PADDING + (2*CELL_PADDING+INNER_CELL_SIZE)*getHeight(),stateOfGameMsg());
    }

    private BinaryObject[][] changeAbstractGridToCircleBinaryObject() {
        BinaryObject[][] output = new CircleBinaryObject[getWidth()][getHeight()];
        for (int i = 0; i < getWidth(); i++) {
            for (int j = 0; j < getHeight(); j++) {
                output[i][j] = new CircleBinaryObject(i,j,getAbstractGrid()[i][j],GRID_PADDING,CELL_PADDING,INNER_CELL_SIZE);
            }
        }
        return output;
    }

/*
    public void drawGrid() {
        for (CircleBinaryObject[] colunnOfCells: circleBinaryObjects) {
            for (CircleBinaryObject cell: colunnOfCells) {
                cell.draw();
            }
        }
    }
*/
    public void drawGrid() {
        for (BinaryObject[] colunnOfCells: binaryObjects) {
            for (BinaryObject cell: colunnOfCells) {
                cell.drawItState();
            }
        }
    }



    @Override
    public void init() {
        super.init();
        drawGrid();
        cursor.draw();
    }

    @Override
    public void showStateOfGameMsg() {
        super.showStateOfGameMsg();
        stateOfGameDisplay.setText(stateOfGameMsg());
        //Text stateOfGameDisplay = new Text(2*CELL_PADDING,CELL_PADDING + (2*CELL_PADDING+INNER_CELL_SIZE)*getHeight(),stateOfGameMsg());
        stateOfGameDisplay.draw();
    }

    @Override
    protected boolean moveCursorRight() {
        if (super.moveCursorRight()) {
            cursor.moveRight();
            drawGrid();
            return true;
        }
        return false;
    }

    @Override
    protected boolean moveCursorLeft() {
        if (super.moveCursorLeft()) {
            cursor.moveLeft();
            drawGrid();
            return true;
        }
        return false;
    }

    @Override
    protected boolean moveCursorDown() {
        if (super.moveCursorDown()) {
            cursor.moveDown();
            drawGrid();
            return true;
        }
        return false;
    }

    @Override
    protected boolean moveCursorUp() {
        if (super.moveCursorUp()) {
            cursor.moveUp();
            drawGrid();
            return true;
        }
        return false;
    }

    @Override
    protected void changeStateOfCells() {
        super.changeStateOfCells();
        int colunn = super.getAbstractCursor().getColunn();
        int row = super.getAbstractCursor().getRow();
        for (int i = 0; i < super.getWidth() ; i++) {
            binaryObjects[i][row].changeState();
            binaryObjects[i][row].drawItState();
        }
        for (int j = 0; j < super.getHeight() ; j++) {
            if (j!=row) {
                binaryObjects[colunn][j].changeState();
                binaryObjects[colunn][j].drawItState();
            }
        }

    }
}

