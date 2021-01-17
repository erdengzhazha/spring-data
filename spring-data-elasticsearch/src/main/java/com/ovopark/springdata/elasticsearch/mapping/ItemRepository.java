package com.ovopark.springdata.elasticsearch.mapping;

import com.ovopark.springdata.elasticsearch.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

public interface ItemRepository  extends ElasticsearchCrudRepository<Item,Long> {


    Item findByTitle(String title);
}
