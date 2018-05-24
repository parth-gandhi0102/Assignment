package com.hexgen.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="CUSTOMER")
public class Customer {
	
	@Id
	@GenericGenerator(name="gen1",strategy="increment")
	@GeneratedValue(generator="gen1")
	@Column(name="CUSTOMERID")
	private int custId;
	@Column(name="NAME")
	private String name;
	@Column(name="AGE")
	private int age;
	@Column(name="DOB")
	private Date date;
	@Column(name="MONTH")
	private String month;
	
	
	public int getCustId() {
		return custId;
	}
	public void setCustId(int custId) {
		this.custId = custId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	

}
