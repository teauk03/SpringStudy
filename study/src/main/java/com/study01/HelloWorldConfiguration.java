package com.study01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    
    
    @Bean(name = "address2")
    public Address address() {
        return new Address("123","Seoul");
    }

    @Bean(name = "address3")
    public Address address3() {
        return new Address("789","Suwon");
    }
}
