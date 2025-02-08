package com.study01.game;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GamingConfiguration {
    @Bean
    public GamingConsole game() {
            var game = new PackmanGame();
            return game;
    }


    @Bean
    public GameRunner gameRunner(GamingConsole game) {
            var gameRunner = new GameRunner(game);
            return gameRunner;
    }
}
