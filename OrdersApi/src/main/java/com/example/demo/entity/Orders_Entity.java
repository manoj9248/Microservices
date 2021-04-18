package com.example.demo.entity;


import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="orders")
public class Orders_Entity {
	@Id
	private int id;
	private String itemname;
	private String status;
	private LocalDate date= LocalDate.now();
	private int custid;
	
	
	
	public Orders_Entity() {	}
	public Orders_Entity(int id, String itemname, String status, LocalDate date, int custid) {
		super();
		this.id = id;
		this.itemname = itemname;
		this.status = status;
		this.date = date;
		this.custid = custid;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	
	
	
	
}