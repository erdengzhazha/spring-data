package com.ovopark.springdata.elasticsearch.query;

import com.ovopark.springdata.elasticsearch.entity.Item;
import com.ovopark.springdata.elasticsearch.mapping.ItemRepository;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;

@SpringBootTest
class SpringdataApplicationTests {

    @Autowired
    private ItemRepository itemRepository;

    /**
     * 封装查询
     */
    @Test
    public void query(){
        Iterable<Item> items = itemRepository.findAll(Sort.by("price").ascending());
        for (Item item : items){
            System.out.println(item);
        }
    }

    /**
     *
     * 自定义查询方法
     */
    @Test
    public void defindQuery(){
        Item dsds = itemRepository.findByTitle("dsds");
        System.out.println(dsds.toString());
    }


    /**
     * 区间查询
     */


    /**
     *  模糊查询
     */


    //自定义查询,查询数目等
    @Test
    public void matchQuery(){
        // 构建查询条件
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        // 添加基本分词查询
        queryBuilder.withQuery(QueryBuilders.matchQuery("title","dsds"));
        //获取结果
        Page<Item> items = (Page<Item>) this.itemRepository.findAll();
        //条数
        long total = items.getTotalElements();
        System.out.println("total = "+total);
        for (Item item : items){
            System.out.println(item);
        }
    }


    /**
     * 分页查询
     */

    @Test
    public void queryByPage(){
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        nativeSearchQueryBuilder.withQuery(QueryBuilders.termQuery("category","dsa"));
        int page = 0;
        int size = 2;
        nativeSearchQueryBuilder.withPageable(PageRequest.of(page,size));
        Page<Item> items = (Page<Item>) this.itemRepository.findAll();
        long total = items.getTotalElements();
        int totalPage = items.getTotalPages();
        int nowPage = items.getNumber();
        int pageSize = items.getSize();
        System.out.println("总条数 = "+total);
        System.out.println("总页数 = "+totalPage);
        System.out.println("当前页 = "+nowPage);
        System.out.println("每页大小 = "+pageSize);
        for (Item item : items){
            System.out.println(item);
        }
    }

    @Test
    public void t(){
        System.out.println("sss");
    }

}
