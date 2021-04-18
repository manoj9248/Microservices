package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CustomerEntity;
import com.example.demo.repo.CustomerRepo;


@Service
public class Customer_Service {
	@Autowired
	private CustomerRepo repo;
	
	public List<CustomerEntity> listAll(){
		return repo.findAll();
	}
	public void save(CustomerEntity customers) {
		repo.save(customers);
	}
	public CustomerEntity get(Integer id) {
		Optional<CustomerEntity>obj=repo.findById(id);if(obj.isPresent()) {
			return obj.get();
		}
		else {
			return null;
		}
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
	
	
	
}

