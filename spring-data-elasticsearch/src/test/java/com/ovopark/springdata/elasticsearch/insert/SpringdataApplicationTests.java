package com.ovopark.springdata.elasticsearch.insert;

import com.ovopark.springdata.elasticsearch.entity.Item;
import com.ovopark.springdata.elasticsearch.mapping.ItemRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
class SpringdataApplicationTests {


    @Autowired
    private ItemRepository itemRepository;

    /**
     * 单个新增
     */
    @Test
    public void insert(){
        Item item = new Item();
        item.setId(2L);
        item.setCategory("1");
        item.setImages("http://localhost");
        Item save = itemRepository.save(item);
        System.out.println(save.getId());
    }

    /**
     * 批量新增
     */
    @Test
    public void insertList(){
        Item item = new Item(1L,"dsds","dsa","dss",36.2,"httpsls");
        Item item1 = new Item(3L,"dsdsds","dsa3a","dss",36.2,"httpsls");
        Item item2 = new Item(4L,"dsdsdddd","dsa4","dss",36.2,"httpsls");
        List<Item> list = new ArrayList<>();
        list.add(item);
        list.add(item1);
        list.add(item2);
        ArrayList items = (ArrayList) itemRepository.saveAll(list);
        System.out.println("传了多少歌？"+items.size());
    }

    @Test
    public void t(){
        System.out.println("sss");
    }

}
