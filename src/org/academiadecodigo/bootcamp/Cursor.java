package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 19/10/2018.
 */
public class Cursor extends AbstractCursor{

    //Properties
    private BackgroundCell cursorBackgroundCell;
    private Rectangle cursorSquare;


    public Cursor(int colunn, int row, int padding, int cellWidth, int cellHeight) {
        super(colunn, row);
        this.cursorBackgroundCell = new BackgroundCell(colunn,row,padding,cellWidth,cellHeight);
        this.cursorSquare = new Rectangle(cursorBackgroundCell.getCell().getX()+2,cursorBackgroundCell.getCell().getY()+2,
                cursorBackgroundCell.getCell().getWidth()-4,cursorBackgroundCell.getCell().getHeight()-4);
    }

    @Override
    public void moveRight() {
        super.moveRight();
        cursorSquare.translate(cursorBackgroundCell.getCell().getWidth(),0);
    }

    @Override
    public void moveLeft() {
        super.moveLeft();
        cursorSquare.translate(-cursorBackgroundCell.getCell().getWidth(),0);
    }

    @Override
    public void moveDown() {
        super.moveDown();
        cursorSquare.translate(0,cursorBackgroundCell.getCell().getHeight());
    }

    @Override
    public void moveUp() {
        super.moveUp();
        cursorSquare.translate(0,-cursorBackgroundCell.getCell().getHeight());
    }

    public void draw() {
        cursorSquare.draw();

        //cursorCell.getCell().draw();
        //cursorCell.getCell().fill();
    }
}
