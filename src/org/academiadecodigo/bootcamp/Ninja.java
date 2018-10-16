package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;

public class Ninja implements KeyboardHandler {

    private int x;
    private int y;
    private int speed;
    private int score;
    private int health;

   public Ninja(int x, int y) {

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

    public boolean move() {

       this.x = x;
       this.y -= speed;

       return true;

    }

    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

       if(keyboardEvent.getKey() == KeyboardEvent.KEY_UP) {


       }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
