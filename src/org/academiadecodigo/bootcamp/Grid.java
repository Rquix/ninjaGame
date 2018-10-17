package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Grid {

    private Rectangle grid;

    Grid (int maxX, int maxY, int padding){
        grid = new Rectangle(padding, padding, maxX, maxY);
        grid.setColor(Color.GREEN);

        grid.fill();
    }
}
