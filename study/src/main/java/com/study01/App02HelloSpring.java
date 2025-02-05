package com.study01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloSpring {
    public static void main(String[] args) {
        // 1. Spring Context를 실행
        var context = 
            new AnnotationConfigApplicationContext(HelloWorldConfiguration.class);
        // 2. Spring 에서 관리할 것을 설정
        //   (1) 설정 클래스(@Configuration)를 사용하여 빈을 정의하는 방식
        //   (2) 설정 파일을 이용하는 방식

        // 3. (1) HelloWorldConfiguration.java 에서 정의한 Spring에 관리 되는 @Bean 검색
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodeCall"));
        System.out.println(context.getBean("person3Parameters"));
        System.out.println(context.getBean("address2"));

        // @Bean(name = "address2")로 설정했을 때 Address 빈을 가져오는 방법
        System.out.println(context.getBean("address2",Address.class));
        // Spring이 Bean을 관리하기 시작하면 Bean의 이름(name)을 사용하거나, Bean의 타입을 사용하여 Bean을 가져올 수 있음.

    } 
} 