package com.bean_scope_study_test.study;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import org.springframework.context.annotation.Scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;


public class PrototypeTest {
    @Scope("prototype")
    static class PrototypeBean {
        @PostConstruct
        public void init() {
            System.out.println("SingletonBean.init");
        }
    
        // 실행이 되지 않아야 함 
        @PreDestroy
        public void destroy() {
            System.out.println("SingletonBean.destroy");
        }
    }
    @Test
    @DisplayName("프로토타입 스코프 빈 생성 테스트")
    void prototypeScopeTest() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);
        assertThat(bean1).isNotSameAs(bean2);
        ac.close();
    }

    @Test
    @DisplayName("프로토타입 빈 조회")
    void prototypeBeanFind() {
        ConfigurableApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);
        System.out.println("찾음 prototypeBean 1");
        final PrototypeBean prototypeBean1 = ac.getBean(PrototypeBean.class);
        System.out.println("찾음 prototypeBean 2");
        final PrototypeBean prototypeBean2 = ac.getBean(PrototypeBean.class);
        assertThat(prototypeBean1).isNotSameAs(prototypeBean2);
        ac.close();
    }   
}
