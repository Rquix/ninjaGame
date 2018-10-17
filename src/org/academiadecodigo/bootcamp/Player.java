package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Ellipse;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

public class Player implements KeyboardHandler {

    private Ellipse player;
    public int health, jump = 0;
    private Keyboard keyboard;
    private boolean moving = false;

    public Player(int verticalPos, int horizontalPos, int vSize, int hSize, int health) {

        this.health = health;

        player = new Ellipse(horizontalPos, verticalPos, hSize, vSize);

        keyboard = new Keyboard(this);


        KeyboardEvent moveUp = new KeyboardEvent();
        moveUp.setKey(KeyboardEvent.KEY_UP);
        moveUp.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveUp);

       /* KeyboardEvent moveDown = new KeyboardEvent();
        moveDown.setKey(KeyboardEvent.KEY_DOWN);
        moveDown.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(moveDown); */
    }

    public void playerInit(Color color) {
        player.setColor(color);
        player.fill();
    }


    public void moveUp(float distance, int maxJump) {


        while (player.getY() > maxJump) {

            setY(-distance);

        }
        moving = false;
    }

   /* public void moveDown(int distance, int maxY) {

        if (player.getY() < maxY) {

            player.translate(0, distance);

        }

    }*/

    public int getHealth() {
        return health;
    }

    public void setHealth(int damage) {
        health = health - damage;
    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            //  case KeyboardEvent.KEY_DOWN: moveDown(5, 250);
            //     break;
            case KeyboardEvent.KEY_UP:
                if (jump < 1) {
                    moving = true;
                    jump++;
                    moveUp(0.0002f, 125);
                }

        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }

    public boolean getMoving() {
        return moving;
    }

    public int getY() {
        return player.getY();
    }

    public void setY(float gravity) {
        player.translate(0, gravity);
    }
}
