package com.study01;

import com.study01.game.GameRunner;
import com.study01.game.MarioGame;
import com.study01.game.SuperContraGame;

public class AppGamingBasicJava {
    public static void main(String[] args) {
        // var marioGame = new MarioGame();
        // var gameRunner = new GameRunner(marioGame);
        var superContraGame = new SuperContraGame();
        var gameRunner = new GameRunner(superContraGame);
        gameRunner.run();
    }
} 