package com.amore.amoreSearch.web.controller;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amore.amoreSearch.document.Product;
import com.amore.amoreSearch.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@GetMapping(value ="/")
	public String getHome(){
		return "Amore Search API";
	}

	@GetMapping(value ="/search")
	public SearchResponse getSearchProduct(){
		String query = "손크림";
		
		return productService.searchProduct(query);
	}
}
