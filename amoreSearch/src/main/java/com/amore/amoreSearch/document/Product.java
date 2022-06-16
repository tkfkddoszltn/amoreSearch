package com.amore.amoreSearch.document;

import com.amore.amoreSearch.indices.Indices;

import lombok.Getter;
import lombok.Setter;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

@Document(indexName = Indices.PRPDUCT_INDEX)
@Setting(settingPath = "static/es-settings.json")
@Getter
@Setter
public class Product {
	
	// DocumentId
	@Id
    @Field(type = FieldType.Keyword)
    private String id;
	
	// 상품번호
	@Field(type = FieldType.Long)
    private String productno;
	
	// 브랜드명
	@Field(type = FieldType.Text)
    private String brandname;
	
	// 상품명
	@Field(type = FieldType.Text)
    private String productname;
	
	// 상품가격
	@Field(type = FieldType.Long)
    private String productprice;
	
	// 카테고리번호
	@Field(type = FieldType.Long)
    private String categoryno;
	
	// 카테고리명
	@Field(type = FieldType.Text)
    private String catgoryname;
	
	// 상위카테고리번호
	@Field(type = FieldType.Long)
    private String parentno;
	
	// 카테고리 depath
	@Field(type = FieldType.Long)
    private String depth;
		
	// 카테고리 정렬
	@Field(type = FieldType.Long)
    private String categorysort;
	
}
