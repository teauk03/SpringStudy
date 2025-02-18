package com.study05;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
class ClassA {


}

@Component
@Lazy 
class ClassB {
    private ClassA classA;


    public ClassB(ClassA classA) {
        System.out.println("초기화 로직");
        this.classA = classA;   
    }

    public void doSomething() {
        System.out.println("어떤 것을 하는 중..");
    }

}




@Configuration
@ComponentScan
public class LazyInitializationLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
        (LazyInitializationLauncherApplication.class)) {
            System.out.println("Spring Context가 초기화 되었습니다.");
            context.getBean(ClassB.class).doSomething();
        }

    }
}
