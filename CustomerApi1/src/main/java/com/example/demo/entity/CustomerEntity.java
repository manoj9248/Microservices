package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
public class CustomerEntity {

	@Id
	//@GeneratedValue
	private Integer id;
	private String name;
	private String email;
	private String password;
	private int orders;
	private String phonenumber;
	
	
	public CustomerEntity() {	}
	public CustomerEntity(Integer id, String name, String email, String password, int orders, String phonenumber) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.orders = orders;
		this.phonenumber = phonenumber;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password
				+ ", orders=" + orders + ", phonenumber=" + phonenumber + "]";
	}
	
	
}
