package com.study01.game;

public class SuperContraGame implements GamingConsole {
    // 게이밍 콘솔 인터페이스 구현
    public void up() {
        System.out.println("위로 가기");
    }
    public void down() {
        System.out.println("앉기");
    }
    public void left() {
        System.out.println("뒤로 가기");
    }
    public void right() {
        System.out.println("총알 발사");
    }
}
