package com.study01.game;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("superContraGameQualifier")
public class SuperContraGame implements GamingConsole {
    // 게이밍 콘솔 인터페이스 구현
    @Override
    public void up() {
        System.out.println("위로 가기");
    }
    @Override
    public void down() {
        System.out.println("앉기");
    }
    @Override
    public void left() {
        System.out.println("뒤로 가기");
    }
    @Override
    public void right() {
        System.out.println("총알 발사");
    }
}
