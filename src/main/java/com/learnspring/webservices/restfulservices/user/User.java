package com.learnspring.webservices.restfulservices.user;

import java.util.Date;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;


public class User {
	private Integer id;
	
	//@Size is used to add validation that size of the name should not be than 5
	//message field will be shown when validation fails 
	@Size(min = 5 , message = "name should have atleast 5 character" )
	private String name;
	
	//@Past is used because we need this date to be in past not in future
	@Past
	private Date date;
	public User(int id, String name, Date date) {
		super();
		this.id = id;
		this.name = name;
		this.date = date;
	}
	public int getId() {
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", date=" + date + "]";
	}
	
	

}
