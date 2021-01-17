package com.ovopark.springdata.elasticsearch.index;

import com.ovopark.springdata.elasticsearch.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

@SpringBootTest
class SpringdataApplicationTests {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    /**
     * 创建一个索引 (yellow)
     */
    @Test
    public  void createIndex(){
        boolean test01 = elasticsearchTemplate.createIndex("test01");
        System.out.println(test01);
    }

    /**
     * 创建一个索引 (green)
     */
    @Test
    public void createIndex2(){
        // 1. 创建索引
        boolean index = elasticsearchTemplate.createIndex(Item.class);
        System.out.println(index);
        // 2. 为索引设置Mapping
        boolean b = elasticsearchTemplate.putMapping(Item.class);
        System.out.println(b);
    }

    /**
     * 删除索引
     */
    @Test
    public void deleteIndex(){
        boolean test01 = elasticsearchTemplate.deleteIndex("test01");
        System.out.println(test01);
    }



    @Test
    public void t(){
        System.out.println("sss");
    }

}
