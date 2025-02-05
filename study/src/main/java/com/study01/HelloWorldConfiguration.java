package com.study01;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String name, int age) { }
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
        return new Person("Riva",23);
    }
    
    @Bean
    public Address address() {
        return new Address("123","Seoul");
    }
}
