package com.example.demo.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Orders_Entity;
import com.example.demo.repo.Orders_repo;

@Service
public class Orders_Service {
	@Autowired
	private Orders_repo repo;
	
	public List<Orders_Entity> listAll(){
		return repo.findAll();
	}
	public void save(Orders_Entity orders) {
		repo.save(orders);
	}
	public Orders_Entity get(Integer id) {
		Optional<Orders_Entity>obj=repo.findById(id);if(obj.isPresent()) {
			return obj.get();
		}
		else {
			return null;
		}
	}
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	public List<Orders_Entity> getAllOrdersWithCustmoer(Integer custid){
		List<Orders_Entity> cus=repo.findByCustid(custid);
		return cus;
	}
	
}
