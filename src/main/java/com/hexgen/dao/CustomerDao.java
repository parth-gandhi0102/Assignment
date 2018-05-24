package com.hexgen.dao;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hexgen.model.Customer;


@Repository("custDAO")
public class CustomerDao {
	
	private static final String HQL_GETALL_CUSTOMER="from Customer";
	
	@Autowired
	HibernateTemplate hibernateTemplate;
	
	@Transactional(readOnly=false)
	public void saveCustomer(List<Customer> custList){
		
		for(Customer customer:custList){
			if(customer!=null){
			Integer id=(Integer)hibernateTemplate.save(customer);
			System.out.println("id is:"+id);
			}
		}
	}
	
	@Transactional(readOnly=false)
	public List<Customer> getAllCustomer(){
		List<Customer> custList;
		custList=(List<Customer>)hibernateTemplate.find(HQL_GETALL_CUSTOMER);
		return custList;
	}

}
