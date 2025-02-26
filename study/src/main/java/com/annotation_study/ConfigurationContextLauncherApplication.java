package com.annotation_study;


import java.util.Arrays;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class ConfigurationContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext()) 
        {

            // 스프링 컨테이너에 등록된 Bean 확인하는 코드 
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(name -> System.out.println("스프링에 의해 관리되는 모든 Bean의 이름: " + name));
            System.out.println("=====================================");
            System.out.println("스프링 컨테이너에 등록된 Bean을 확인하는 코드");
            // 스프링 컨테이너에 등록된 Bean 확인하는 코드
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(name -> System.out.println(context.getBean(name)));
           
        }

    }
}
