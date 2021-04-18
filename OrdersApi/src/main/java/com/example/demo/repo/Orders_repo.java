package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Orders_Entity;


@Repository
public interface Orders_repo extends JpaRepository<Orders_Entity,Integer>{
	List<Orders_Entity> findByCustid(Integer custid);
}