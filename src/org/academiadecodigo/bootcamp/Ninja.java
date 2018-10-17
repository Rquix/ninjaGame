package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.pictures.Picture;

public class Ninja implements KeyboardHandler {

    private Rectangle ninja;
    private int x;
    private int y;
    private int speed;
    private int score;
    private int health;

    public Ninja(int x, int y) {

        ninja = ninja = ninja = new Rectangle(x, y, 75, 20);
        ninja.setColor(Color.RED);
        ninja.fill();
        this.x = x;
        this.y = y;
        this.health = 100;
        this.score = 0;
        this.speed = 10;

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent move = new KeyboardEvent();

        move.setKey(KeyboardEvent.KEY_UP);

        move.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);

        keyboard.addEventListener(move);

    }

    public int getX() {

        return this.x;

    }

    public void setX(int x) {

        this.x = x;

    }

    public int getY() {

        return this.y;

    }

    public void setY(int y) {

        this.y = y;

    }

    public int getHealth() {

        return this.health;

    }

    public void setHealth(int health) {

        this.health = health;

    }

    public int getScore() {

        return this.score;

    }

    public void setScore(int score) {

        this.score = score;

    }

    public int getSpeed() {

        return this.speed;

    }

    public void setSpeed(int speed) {

        this.speed = speed;

    }

    public void move() {

        if(ninja.getY() > 10) {

            ninja.translate(0, -speed);

        }

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        if (keyboardEvent.getKey() == keyboardEvent.KEY_UP) {

            move();

        }

    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
