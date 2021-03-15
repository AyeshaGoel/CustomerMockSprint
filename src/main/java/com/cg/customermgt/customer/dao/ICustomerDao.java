package com.cg.customermgt.customer.dao;

import com.cg.customermgt.customer.entities.Customer;

public interface ICustomerDao {
	
	Customer add(Customer customer) ;
	 
	Customer findById(Long id);

	Customer update(Customer customer);

}


