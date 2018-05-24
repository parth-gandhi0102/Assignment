package com.hexgen.services;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexgen.dao.CustomerDao;
import com.hexgen.model.Customer;

@Service("custService")
@Transactional(propagation=Propagation.REQUIRED,readOnly=false)
public class CustomerService {

	@Autowired
	private CustomerDao customerDao;
	
	@Transactional(readOnly=false)
	public void saveCustomerDetails(List<Customer> custList){
		 customerDao.saveCustomer(custList);
		
	}
	
	@Transactional(readOnly=false)
	public List<Customer> getAllCustomer(){
		return customerDao.getAllCustomer();
	}
	
}
