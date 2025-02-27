package com.annotation_study;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository
public class MySqlDataService implements DataService {

    @Override
    public int[] retrieveData() {
        System.out.println("MySql 에서 데이터를 가져옴");
        return new int[] { 1, 2, 3, 4, 5 };
    }
}
