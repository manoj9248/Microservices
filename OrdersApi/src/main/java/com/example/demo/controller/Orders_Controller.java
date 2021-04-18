package com.example.demo.controller;


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

import com.example.demo.entity.Orders_Entity;
import com.example.demo.service.Orders_Service;



@RestController
@RequestMapping("Orders")
public class Orders_Controller {
	@Autowired
	public Orders_Service service;
	
	@GetMapping
	public List<Orders_Entity> list(){
		return service.listAll();
	}
	
	@GetMapping("/{custId}")
	public List<Orders_Entity> getallordersbtcustid(@PathVariable Integer custId){
		return service.getAllOrdersWithCustmoer(custId);
	}
	@GetMapping("id/{id}")
	public ResponseEntity<Orders_Entity>get(@PathVariable Integer id){
		Orders_Entity obj=service.get(id);
		if(obj==null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			return new ResponseEntity<>(obj,HttpStatus.OK);
		}
	}
	@PostMapping
	public String add(@RequestBody Orders_Entity orders) {
		service.save(orders);
		return "created";
	}
	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		service.delete(id);
		return "deleted";
	}
}