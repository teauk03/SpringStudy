package com.annotation_study;

import java.util.Arrays;

import org.springframework.stereotype.Service;


/* 
    클래스에 비지니스 로직을 작성 했다면 해당 클래스는 서비스 클래스
   @Component 대신 @Service 어노테이션을 사용하여 스프링 컨테이너에 빈으로 등록
   @Service 어노테이션을 사용함으로 해당 클래스가 비지니스 로직을 담당하는 클래스임을 명확히 명시할 수 있음
 */ 

@Service
public class BusinessCalculationService {
    private DataService dataService;

    public BusinessCalculationService(DataService dataService) {
        super();
        this.dataService = dataService;
    }

    public int findMax() {
        return Arrays.stream(dataService.retrieveData()).max().orElse(0);
    }
}
