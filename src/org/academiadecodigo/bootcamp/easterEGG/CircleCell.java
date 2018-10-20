package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.graphics.Ellipse;

/**
 * Created by codecadet on 20/10/2018.
 */
public class CircleCell extends BackgroundCell {

    private Ellipse circle;



    public CircleCell(int colunn, int row, int padding, int cellPadding, int circleSize) {
        super(colunn, row, padding, 2*cellPadding+circleSize, 2*cellPadding+circleSize);
        this.circle = new Ellipse(padding+colunn*(2*cellPadding+circleSize)+cellPadding,
                padding+row*(2*cellPadding+circleSize)+cellPadding, circleSize, circleSize);

    }

    public Ellipse getCircle() {
        return circle;
    }
}
