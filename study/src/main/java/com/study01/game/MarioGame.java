package com.study01.game;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class MarioGame implements GamingConsole {
       // 게이밍 콘솔 인터페이스 구현
    @Override
    public void up() {
        System.out.println("점프!!");
    }
    @Override
    public void down() {
        System.out.println("구멍으로 들어가기.");
    }
    @Override
    public void left() {
        System.out.println("뒤로 가기.");
    }
    @Override
    public void right() {
        System.out.println("가속");
    }
}
