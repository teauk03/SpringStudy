package com.study01;

import com.study01.game.GameRunner;
import com.study01.game.GamingConsole;
import com.study01.game.MarioGame;
import com.study01.game.PackmanGame;
import com.study01.game.SuperContraGame;

public class App02GamingBasicJava {
    public static void main(String[] args) {
        var marioGame = new MarioGame(); // 객체 생성
        var gameRunner = new GameRunner(marioGame); // 객체 생성 및 종속성 주입
        gameRunner.run(); // 실행 메서드 호출

        GamingConsole superContraGame = new SuperContraGame();
        gameRunner = new GameRunner(superContraGame);
        gameRunner.run();

        GamingConsole packmanGame = new PackmanGame();
        gameRunner = new GameRunner(packmanGame);
        gameRunner.run();
    }
} 