package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.common.Orders_Entity;
import com.example.demo.entity.CustomerEntity;
import com.example.demo.service.Customer_Service;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;


@RestController
@RequestMapping("/customer")
public class Controller {
	
	@Autowired
	private Customer_Service service;
	
	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping
	public List<CustomerEntity> list(){
		return service.listAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerEntity>get(@PathVariable Integer id){
		CustomerEntity obj=service.get(id);
		if(obj==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
	}
	
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "deleted";
	}
	@PostMapping
	public String add(@RequestBody CustomerEntity customer) {
		service.save(customer);
		return "created";
	}
	
	@GetMapping("rest/{customerId}")
	@HystrixCommand(fallbackMethod = "getOrdersFromOrderEntityFallBackMethod")
	public List<Orders_Entity> getOrdersFromOrderEntity(@PathVariable int customerId){
		Orders_Entity obj[] =restTemplate.getForObject("http://localhost:8021/Orders/"+customerId, Orders_Entity[].class);
		return Arrays.asList(obj);
	}
	
	public List<Orders_Entity> getOrdersFromOrderEntityFallBackMethod(@PathVariable int customerId){
		List<Orders_Entity> list = new ArrayList<>();
		return list;
	}
}
