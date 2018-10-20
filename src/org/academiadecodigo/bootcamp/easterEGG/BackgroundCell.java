package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

/**
 * Created by codecadet on 19/10/2018.
 */
public class BackgroundCell {
    private int colunn;
    private int row;
    private int padding;
    private int cellWidth;
    private int cellHeight;
    private Rectangle cell;
    private final Color color = Color.YELLOW;

    public BackgroundCell(int colunn, int row, int padding, int cellWidth, int cellHeight) {
        this.colunn = colunn;
        this.row = row;
        this.padding = padding;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.cell = new Rectangle(padding+colunn*cellWidth,padding+row*cellHeight, cellWidth, cellHeight);
        this.cell.setColor(color);
    }

    public Rectangle getCell() {
        return cell;
    }
}
