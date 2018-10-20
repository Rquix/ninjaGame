package org.academiadecodigo.bootcamp.easterEGG;

import com.sun.org.apache.regexp.internal.RE;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 19/10/2018.
 */
public class PicturedBinaryObject extends BinaryObject {

    private PicturedCell picturedCell;

    public PicturedBinaryObject(int colunn, int row, boolean positiveState, Picture positivePic, Picture negativePic, int padding, int cellPadding) {
        super(colunn, row, positiveState);
        this.picturedCell = new PicturedCell(colunn,row,padding,cellPadding,positivePic,negativePic);
    }

    @Override
    public void changeState() {
        super.changeState();
        drawObject();
    }

    public void drawObject() {
        picturedCell.draw(isPositiveState());
    }

}
