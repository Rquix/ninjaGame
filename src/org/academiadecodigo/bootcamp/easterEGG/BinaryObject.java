package org.academiadecodigo.bootcamp.easterEGG;

/**
 * Created by codecadet on 19/10/2018.
 */
public /*abstract*/ class BinaryObject {

    //Properties
    private int colunn;
    private int row;
    private boolean positiveState;

    //Constructor
    public BinaryObject(int colunn, int row, boolean positiveState) {
        this.colunn = colunn;
        this.row = row;
        this.positiveState = positiveState;
    }

    //Methods
    protected void changeState() {
        positiveState = !positiveState;
    }

    //Getters & Setters


    public int getColunn() {
        return colunn;
    }

    public int getRow() {
        return row;
    }

    public boolean isPositiveState() {
        return positiveState;
    }
}
