package org.academiadecodigo.bootcamp.easterEGG;

/**
 * Created by codecadet on 19/10/2018.
 * Defines an abstract cursor to move in the abstract grid.
 */
public class AbstractCursor {

    private int colunn;
    private int row;

    public AbstractCursor(int colunn, int row) {
        this.colunn = colunn;
        this.row = row;
    }

    //public void draw() {}

    public void moveRight(){
        colunn++;
    }

    public void moveLeft(){
        colunn--;
    }

    public void moveDown(){
        row++;
    }

    public void moveUp(){
        row--;
    }

    public int getColunn() {
        return colunn;
    }

    public int getRow() {
        return row;
    }
}
