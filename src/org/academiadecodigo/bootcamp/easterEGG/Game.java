package org.academiadecodigo.bootcamp.easterEGG;

import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

/**
 * Created by codecadet on 21/10/2018.
 */
public class Game implements KeyboardHandler {

    private Grid grid;
    private boolean gameStarted = false;
    private Text rules1 = new Text(30,30,"Use the arrows to move the cursor");
    private Text rules2 = new Text(30,50,"Press SPACE to switch the colors of the cells in cursor row and colunn");
    private Text rules3 = new Text(30,70,"You win when all cells are white (press n to continue)");
    private Text menu = new Text(30,30,"Choose the dificulty: Easy (press e), Medium (press m) or Hard (press h)");


    public void run () {
        showRules();

    }


    public void init() {

        rules1.delete();
        rules2.delete();
        rules3.delete();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent chooseEasy = new KeyboardEvent();
        chooseEasy.setKey(KeyboardEvent.KEY_E);
        chooseEasy.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(chooseEasy);

        KeyboardEvent chooseMedium = new KeyboardEvent();
        chooseMedium.setKey(KeyboardEvent.KEY_M);
        chooseMedium.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(chooseMedium);

        KeyboardEvent chooseHard = new KeyboardEvent();
        chooseHard.setKey(KeyboardEvent.KEY_H);
        chooseHard.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(chooseHard);


        menu.draw();
    }

    public void showRules() {

        rules1.draw();
        rules2.draw();
        rules3.draw();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent next = new KeyboardEvent();
        next.setKey(KeyboardEvent.KEY_N);
        next.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(next);


    }


    public void start(){

        menu.delete();

        Keyboard keyboard = new Keyboard(this);

        KeyboardEvent left = new KeyboardEvent();
        left.setKey(KeyboardEvent.KEY_LEFT);
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(left);

        KeyboardEvent right = new KeyboardEvent();
        right.setKey(KeyboardEvent.KEY_RIGHT);
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(right);

        KeyboardEvent down = new KeyboardEvent();
        down.setKey(KeyboardEvent.KEY_DOWN);
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(down);

        KeyboardEvent up = new KeyboardEvent();
        up.setKey(KeyboardEvent.KEY_UP);
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(up);

        KeyboardEvent switchPress = new KeyboardEvent();
        switchPress.setKey(KeyboardEvent.KEY_SPACE);
        switchPress.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        keyboard.addEventListener(switchPress);

        grid.init();



    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {
        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_LEFT:
                    grid.moveCursorLeft();
                    System.out.println(grid);
                break;
            case KeyboardEvent.KEY_RIGHT:
                    grid.moveCursorRight();
                    System.out.println(grid);
                break;
            case KeyboardEvent.KEY_DOWN:
                    grid.moveCursorDown();
                    System.out.println(grid);
                break;
            case KeyboardEvent.KEY_UP:
                    grid.moveCursorUp();
                    System.out.println(grid);
                break;
            case KeyboardEvent.KEY_SPACE:
                if (!grid.sucessCondition()) {
                    grid.changeStateOfCells();
                    grid.increaseNumberOfSwitchPresses();
                    System.out.println(grid);
                    grid.showStateOfGameMsg();
                }
                break;
            case KeyboardEvent.KEY_E:
                    grid = new Grid(2,2);
                    gameStarted = true;
                    start();
                break;
            case KeyboardEvent.KEY_M:
                    grid = new Grid(4,4);
                    gameStarted = true;
                    start();
                break;
            case KeyboardEvent.KEY_H:
                    grid = new Grid(6,6);
                    gameStarted = true;
                    start();
                break;

            case KeyboardEvent.KEY_N:
                init();

                break;


            default:
                System.out.println("We have a problem");
        }
    }

    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {}


}
