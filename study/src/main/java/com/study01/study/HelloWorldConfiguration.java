package com.study01.study;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

record Person(String name, int age, Address address) { }
// 주소를 추가 해볼거임 - 첫 행, 도시
record Address(String firstLine , String city) { }
@Configuration
public class HelloWorldConfiguration {


    @Bean
    public String name() {
        return "Ranga!";
    }

    @Bean
    public int age() {
        return 15;
    }

    @Bean
    public Person person() {
        return new Person("Riva",23, new Address("567","Busan"));
    }

   // 기존 Spring Bean과 관계가 있는 새로운 Bean을 생성 - person2
    @Bean
    public Person person2MethodeCall() {
        return new Person(name(), age(), address()); // name, age
            // 이 문제를 해결하는 방법 1. 메서드 호출
    }
    

    // 기존 Spring Bean과 관계가 있는 새로운 Bean을 생성 - person3
    @Bean
    public Person person3Parameters(String name, int age, Address address3) //  name, age, address3
    {
        return new Person(name, age, address3); // name, age
            // 이 문제를 해결하는 방법 2. 매개변수를 활용
    }
    
    @Bean
    @Primary
    public Person person4Parameters(String name, int age, Address address) 
    {
        return new Person(name, age, address); // name, age
    }
    
    @Bean
    @Qualifier("person4Parameters")
    public Person person5Qualifier(String name, int age, @Qualifier("address3qualifier") Address address) 
    {
        return new Person(name, age, address); // name, age
    }


    @Bean(name = "address2")
    @Primary  
    // 동일한 타입의 여러 빈이 존재할 때 기본적으로 주입될 빈을 지정하는 데 사용
    // 이 어노테이션이 붙은 Bean이 우선적으로 주입됨
    public Address address() {
        return new Address("123","Seoul");
    }

    @Bean(name = "address3")
    @Qualifier("address3qualifier")
    // Qualifier 어노테이션은 동일한 타입의 여러 빈이 존재할 때 특정 빈을 주입하는 데 사용
    public Address address3() {
        return new Address("789","Suwon");
    }
}
