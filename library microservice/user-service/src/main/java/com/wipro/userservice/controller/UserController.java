package com.wipro.userservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.wipro.userservice.entity.Users;
import com.wipro.userservice.repository.UserRepo;

@RestController
public class UserController {
	
	@Autowired
	private UserRepo repository;
	
	@PostMapping("/addUserList")
	public ResponseEntity<HttpStatus> addUserList(@RequestBody List<Users> user){
		repository.saveAll(user);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@GetMapping("/getBookList")
	public List<Object> getBookList(){
		RestTemplate restTemplate = new RestTemplate();
		Object[] products = restTemplate.getForObject("http://localhost:8081/products/getList", Object[].class);
		return Arrays.asList(products);
	}
	
	@PostMapping("/addBookList")
	public ResponseEntity<HttpStatus> addBookList(@RequestBody List<Object> book){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<List<Object>> httpEntity = new HttpEntity<List<Object>>(book);
		restTemplate.postForEntity("http://localhost:8081/products/addList", httpEntity, Object.class);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping("/addBook")
	public ResponseEntity<HttpStatus> addBook(@RequestBody Object book){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<Object> httpEntity = new HttpEntity<Object>(book);
		restTemplate.postForEntity("http://localhost:8081/products/addOne", httpEntity, Object.class);
		return ResponseEntity.ok(HttpStatus.OK);
	}
	
	@PostMapping("/addUser")
	public Users addUser(Users user) {
		return repository.save(user);
	}
	
	@GetMapping("/getUser/{userId}")
	public Users getUser(@PathVariable String userId) {
		return repository.findUserByUserId(userId);
	}
	
	@GetMapping("/getUserList")
	public List<Users> getUserList(){
		return repository.findAll();
	}

}
