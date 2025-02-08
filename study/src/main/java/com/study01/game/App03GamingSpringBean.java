package com.study01.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App03GamingSpringBean {
    public static void main(String[] args) {    
        try(var context = new AnnotationConfigApplicationContext
        (GamingConfiguration.class)) 
        {
            context.getBean(GamingConsole.class).up();
            context.getBean(GameRunner.class).run();
        }
            
        /**
        var marioGame = new MarioGame(); // 객체 생성
        var gameRunner = new GameRunner(marioGame); // 객체 생성 및 종속성 주입
        gameRunner.run(); // 실행 메서드 호출

        GamingConsole superContraGame = new SuperContraGame();
        gameRunner = new GameRunner(superContraGame);
        gameRunner.run();

        GamingConsole packmanGame = new PackmanGame();
        gameRunner = new GameRunner(packmanGame);
        gameRunner.run();
         */
    }
} 