package com.study06;


import java.util.Arrays;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


@Component
class SomeClass {
   
    private  SomeDependency someDependency;
    // 의존성이 연결되는 대로 초기화를 실행하고 싶다면 어케 해야할까?"
    // @PostConstruct를 사용하면 됨
    /*
    1. 의존성이 준비 됨
    2. 의존성이 준비된 후 초기화 실행
     */

    public SomeClass(SomeDependency someDependency) {
        super();
        this.someDependency = someDependency;
        System.out.println("의존성이 연결이 준비 됨");
    }   

    @PostConstruct
    /* 
    @PostConstruct 애너테이션은 의존성 주입이 완료된 후 실행해야 하는 초기화 메서드에 사용됨. 
    해당 클래스가 서비스에 등록되기 전에 반드시 호출되어야 하며, 의존성을 주입받지 않더라도 실행됨. 
    */
    public void init() {
        someDependency.getReady();
        }
    

    @PreDestroy
    /*
    객체가 컨테이너에 의해 제거되기 전에 실행해야 하는 콜백 메서드에 사용됨. 주로 자원 해제 등의 정리 작업을 수행하는 데 활용됨.
     */    
    public void cleanUp() {
        // context에서 bean이 제거되기 전에 호출
        System.out.println("종료");    
    }
}
        
        
@Component
class SomeDependency {
        
    public void getReady() {    
        System.out.println("의존성을 사용하는 로직");
    }
}


@Configuration
@ComponentScan
public class PrePostAnnotationsContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
        (PrePostAnnotationsContextLauncherApplication.class)) {

            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(name -> System.out.println("스프링에 의해 관리되는 모든 Bean의 이름: " + name));
        }

    }
}
