package com.ovopark.springdata;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootTest
class SpringdataApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Test
    public  void t1(){
        boolean test01 = elasticsearchTemplate.createIndex("test01");
        System.out.println(test01);
    }

    @Test
    public void t(){
        System.out.println("sss");
    }

}
