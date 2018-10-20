package org.academiadecodigo.bootcamp.easterEGG;

/**
 * Created by codecadet on 19/10/2018.
 */
public class Grid extends AbstractGrid {
    private final int GRID_PADDING = 10;
    private final int CELL_PADDING = 10;
    private final int INNER_CELL_SIZE = 20;
    private Cursor cursor;
    private CircleBinaryObject[][] circleBinaryObjects;


    public Grid(int width, int height) {
        super(width, height);
        this.cursor = new Cursor(getAbstractCursor().getColunn(),getAbstractCursor().getRow(),GRID_PADDING,
                2*CELL_PADDING+INNER_CELL_SIZE,2*CELL_PADDING+INNER_CELL_SIZE);
        this.circleBinaryObjects = new CircleBinaryObject[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                this.circleBinaryObjects[i][j] = new CircleBinaryObject(i,j,getAbstractGrid()[i][j],GRID_PADDING,CELL_PADDING,INNER_CELL_SIZE);
            }
        }
    }


    public void drawGrid() {
        for (CircleBinaryObject[] colunnOfCells: circleBinaryObjects) {
            for (CircleBinaryObject cell: colunnOfCells) {
                cell.draw();
            }
        }
    }

    public void drawStates() {
        for (CircleBinaryObject[] colunnOfCells: circleBinaryObjects) {
            for (CircleBinaryObject cell: colunnOfCells) {
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
    protected boolean moveCursorRight() {
        if (super.moveCursorRight()) {
            cursor.moveRight();
            drawStates();
            return true;
        }
        return false;
    }

    @Override
    protected boolean moveCursorLeft() {
        if (super.moveCursorLeft()) {
            cursor.moveLeft();
            drawStates();
            return true;
        }
        return false;
    }

    @Override
    protected boolean moveCursorDown() {
        if (super.moveCursorDown()) {
            cursor.moveDown();
            drawStates();
            return true;
        }
        return false;
    }

    @Override
    protected boolean moveCursorUp() {
        if (super.moveCursorUp()) {
            cursor.moveUp();
            drawStates();
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
            circleBinaryObjects[i][row].changeState();
            circleBinaryObjects[i][row].drawItState();
        }
        for (int j = 0; j < super.getHeight() ; j++) {
            if (j!=row) {
                circleBinaryObjects[colunn][j].changeState();
                circleBinaryObjects[colunn][j].drawItState();
            }
        }

    }
}
