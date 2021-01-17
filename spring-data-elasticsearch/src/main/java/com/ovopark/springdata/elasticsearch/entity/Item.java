package com.ovopark.springdata.elasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *  索引（indices）--------数据库（databases)
 *  类型（type)------------数据表（table)
 *  文档（Document）---------------- 行(row)
 *  字段（Field）-------------------列(Columns )
 */



// ndexName 对应索引库名称
// type 对应在索引库中的类型
// shards：分片数量，默认5，
// replicas：副本数量，默认1
@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "item",type = "docs",shards = 1,replicas = 0)
public class Item {

    @Id
    private Long id;
//    @Field(type = FieldType.Text,analyzer = "ik_max_word")
    @Field(type = FieldType.Text,analyzer = "")
    private String title;
    @Field(type=FieldType.Keyword)
    private String category;
    @Field(type=FieldType.Keyword)
    private String brand;
    @Field(type=FieldType.Double)
    private Double price;
    // 不创建索引
    @Field(index = false,type = FieldType.Keyword)
    private String images;

}
