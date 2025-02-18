package com.bean_scope_study;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
class NomalClass {


}


/**
 * 이 클래스는 @Scope 어노테이션이 달려 있어, 프로토타입 범위로 정의됨
 * Spring에서 프로토타입 범위의 빈은 컨테이너에서 요청될 때마다 다른 인스턴스를 반환함
 * 범위는 ConfigurableBeanFactory.SCOPE_PROTOTYPE을 사용하여 설정됨
 */
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
class PrototypeClass {

}



@Configuration
@ComponentScan
public class BeanScopeLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
        (BeanScopeLauncherApplication.class)) {

            // 싱글톤 범위의 빈을 요청할 때마다 같은 인스턴스를 반환
            System.out.println("NomalClass ");
            System.out.println(context.getBean(NomalClass.class));
            System.out.println(context.getBean(NomalClass.class));

            // 프로토타입 범위의 빈을 요청할 때마다 다른 인스턴스를 반환
            System.out.println("PrototypeClass ");
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
            System.out.println(context.getBean(PrototypeClass.class));
        }

    }
}
