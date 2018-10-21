package org.academiadecodigo.bootcamp.easterEGG;

/**
 * Created by codecadet on 20/10/2018.
 */
public class CircleBinaryObject extends BinaryObject implements Drawable {

    private CircleCell circleCell;

    public CircleBinaryObject(int colunn, int row, boolean positiveState,int padding, int cellPadding, int circleSize) {
        super(colunn, row, positiveState);
        this.circleCell = new CircleCell(colunn,row,padding,cellPadding,circleSize);
    }


    @Override
    public void drawItState () {
        circleCell.getCell().draw();
        if (isPositiveState()) {
            circleCell.getCircle().fill();
            return;
        }
        circleCell.getCircle().draw();
    }

}
