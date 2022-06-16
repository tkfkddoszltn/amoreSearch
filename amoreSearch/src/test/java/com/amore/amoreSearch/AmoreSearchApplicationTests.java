package com.amore.amoreSearch;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.amore.amoreSearch.service.ProductService;

@SpringBootTest
class AmoreSearchApplicationTests {
	
	@Autowired
	private ProductService productService;

	@Test
	void elasticsearchTest() {
		
		// 검색키워드
		String query = "손크림";
		
		// 검색결과
		System.out.println(productService.searchProduct(query));
		
	}

}
