package org.academiadecodigo.bootcamp;

import org.academiadecodigo.simplegraphics.graphics.Color;

public class Game {

    private Player player;
    private Grid grid;
    private GameObjects[] enemies;
    private int score, playerHealth, maxY;
    private float speed;

    Game() {
        maxY = 260;
        speed = 0.00002f;



    }

    public void start (){
        grid = new Grid(500, 500, 10);
        player = new Player(200, 20, 20, 20, 100);
        player.playerInit(Color.BLACK);

        while (true){
            speed = (player.getY()<maxY && !player.getMoving()) ? 0.00002f : 0;
            if (player.getY()==maxY) player.jump=0;
            player.setY(speed);
        }

    }

    public void init(){

    }



}
