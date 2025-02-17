package com.study01.game;

import org.springframework.stereotype.Component;

@Component
public class PackmanGame implements GamingConsole {
       // 게이밍 콘솔 인터페이스 구현
    @Override
    public void up() {
        System.out.println("위로 가기");
    }
    @Override
    public void down() {
        System.out.println("아래로 가기");
    }
    @Override
    public void left() {
        System.out.println("왼쪽으로 가기");
    }
    @Override
    public void right() {
        System.out.println("오른쪽으로 가기");
    }
}
