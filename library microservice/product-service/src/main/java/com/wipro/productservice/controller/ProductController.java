package com.wipro.productservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.productservice.entity.Product;
import com.wipro.productservice.repository.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	@Autowired
	private ProductRepository repository;
	
	@PostMapping("/addList")
	public ResponseEntity<HttpStatus> addList(@RequestBody List<Product> product) {
		repository.saveAll(product);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping("/addOne")
	public ResponseEntity<HttpStatus> addProduct(@RequestBody Product product){
		repository.save(product);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/getList")
	public List<Product> getAll(){
		return repository.findAll();
	}

}
