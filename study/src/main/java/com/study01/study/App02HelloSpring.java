package com.study01.study;

import java.lang.reflect.Array;
import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloSpring {
    public static void main(String[] args) {

        // 1. Spring Context를 실행
        try(var context =  // try-with-resources 구문으로 close()를 자동 호출
        new AnnotationConfigApplicationContext
        (HelloWorldConfiguration.class)) {

        // 2. Spring 에서 관리할 것을 설정
        //   (1) 설정 클래스(@Configuration)를 사용하여 빈을 정의하는 방식
        //   (2) 설정 파일을 이용하는 방식

        // 3. (1) HelloWorldConfiguration.java 에서 정의한 Spring에 관리 되는 @Bean 검색
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("age"));
        System.out.println(context.getBean("person"));
        System.out.println(context.getBean("person2MethodeCall"));
        System.out.println(context.getBean("person3Parameters"));

        System.out.println("=====================================");
        System.out.println(context.getBean("address2"));

        System.out.println("여러개의 일치하는 Bean이 있을 때");
        // @Bean(name = "address2")로 설정했을 때 Address 빈을 가져오는 방법
        System.out.println(context.getBean("address2",Address.class));
        // Spring이 Bean을 관리하기 시작하면 Bean의 이름(name)을 사용하거나, Bean의 타입을 사용하여 Bean을 가져올 수 있음.
        System.out.println(context.getBean(Address.class));
        // NoUniqueBeanDefinitionException @Primary를 사용하지 않았을 때
        System.out.println(context.getBean(Person.class));
        //.NoUniqueBeanDefinitionException:
        // No qualifying bean of type 'com.study01.Person' 
        //available: expected single matching bean but found 4:
        // person, person2MethodeCall, person3Parameters, person4Parameters
        System.out.println("Qulifier 사용");
        System.out.println(context.getBean("person4Parameters"));

        System.out.println("=====================================");
        // Spring Bean을 나열할려면 어케 해야하지?
        // context.getBeanDefinitionNames() 메서드를 사용하면 Spring Bean의 이름을 나열할 수 있음
        System.out.println("스프링에 의해 관리되는 모든 Bean의 이름 출력");
        Arrays.stream(context.getBeanDefinitionNames())
            .forEach(name -> System.out.println("스프링에 의해 관리되는 모든 Bean의 이름: " + name));
        }

        };

    
} 