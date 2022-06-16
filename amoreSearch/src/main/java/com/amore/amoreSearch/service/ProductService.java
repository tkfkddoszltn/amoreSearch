package com.amore.amoreSearch.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import com.amore.amoreSearch.indices.Indices;

@Service
public class ProductService {
	
	@Value("${ELASTICSEARCH.IP}")
    private String ip;  // 127.0.0.1
	
	@Value("${ELASTICSEARCH.PORT}")
    private int port;  // 9230
	
	// elastic client 접속
	private RestHighLevelClient client;
	
	public SearchResponse searchProduct(String query) {
		
		client = new RestHighLevelClient(
		        RestClient.builder(
		                new HttpHost(ip, port, "http")));
        
		//make Result Set
		List <Map<String, Object>> arrList = new ArrayList<>();
        
        FieldSortBuilder categorySortBuilder = SortBuilders.fieldSort("categorysort").order(SortOrder.DESC); // category 정렬
        FieldSortBuilder priceSortBuilder = SortBuilders.fieldSort("productprice").order(SortOrder.DESC); // 가격 정렬
        QueryBuilder queryStringBuilder = QueryBuilders.queryStringQuery(query); // 단순키워드
        
        SearchRequest searchRequest = new SearchRequest(Indices.PRPDUCT_INDEX);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
    	sourceBuilder.query(queryStringBuilder);
    	sourceBuilder.from(0); 
    	sourceBuilder.size(1000);
    	sourceBuilder.sort(categorySortBuilder);
    	sourceBuilder.sort(categorySortBuilder);
    	//Add Builder to Search Request
    	searchRequest.source(sourceBuilder);
    	
    	try {
    		SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
    		
    		return searchResponse;
    	} catch (IOException e) {
    		System.err.println("Elastic search fail");
    		return null;
    	}        
    }
}
