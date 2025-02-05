package com.study01.game;

public class MarioGame implements GamingConsole {
       // 게이밍 콘솔 인터페이스 구현
    public void up() {
        System.out.println("점프!!");
    }
    public void down() {
        System.out.println("구멍으로 들어가기.");
    }
    public void left() {
        System.out.println("뒤로 가기.");
    }
    public void right() {
        System.out.println("가속");
    }
}
