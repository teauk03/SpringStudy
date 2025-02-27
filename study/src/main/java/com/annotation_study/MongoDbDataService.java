package com.annotation_study;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

// @Component
/*
 * @Repository 어노테이션은 해당 클래스가 데이터베이스에 접근하는 클래스임을 명시
 * @Repository 어노테이션을 사용함으로써 해당 클래스가 데이터베이스에 접근하는 클래스임을 명확히 명시할 수 있음
 */
@Repository
@Primary
public class MongoDbDataService implements DataService {

    @Override
    public int[] retrieveData() {
        System.out.println("Mongo DB 에서 데이터를 가져옴");
        return new int[] { 11, 22 , 89, 45 };
    }
}
