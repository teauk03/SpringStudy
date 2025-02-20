package com.study07;


import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
// import org.springframework.stereotype.Component;

import jakarta.inject.Inject;
import jakarta.inject.Named;


//@Component
// CDI 방식을 사용
// 라이브러리 추가 (pom.xml)
@Named
class BusinessService {
    DataServices dataServices;

    // @Autowired
    @Inject
    public void setDataServices(DataServices dataServices) {
        System.out.println("Setter Injection");
        this.dataServices = dataServices;
    }

    public DataServices getDataServices() {
        return dataServices;
    }

}

// @Component
@Named
class DataServices {

}

@Configuration
@ComponentScan
public class CdiContextLauncherApplication {

    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext
        (CdiContextLauncherApplication.class)) {

            // 스프링 컨테이너에 등록된 Bean 확인하는 코드 
            Arrays.stream(context.getBeanDefinitionNames())
                .forEach(name -> System.out.println("스프링에 의해 관리되는 모든 Bean의 이름: " + name));


            System.out.println(context.getBean(BusinessService.class).getDataServices());
        }

    }
}
