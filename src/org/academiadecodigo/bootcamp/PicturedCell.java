package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.pictures.Picture;

/**
 * Created by codecadet on 20/10/2018.
 */
public class PicturedCell extends BackgroundCell {

    private Picture positivePic;
    private Picture negativePic;//WARNING: both pics shall have the same dimensions

    public PicturedCell(int colunn, int row, int padding, int cellPadding, Picture positivePic, Picture negativePic) {

        super(colunn, row, padding, 2*cellPadding+Math.max(positivePic.getWidth(),negativePic.getWidth()),
                2*cellPadding+Math.max(positivePic.getHeight(),negativePic.getHeight()));
        this.positivePic = positivePic;
        this.negativePic = negativePic;
    }

    public void draw (boolean state) {
        if (state) {
            positivePic.draw();
            return;
        }
        negativePic.draw();
    }
}
