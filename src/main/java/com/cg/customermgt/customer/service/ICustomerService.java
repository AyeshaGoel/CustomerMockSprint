package com.cg.customermgt.customer.service;

import java.util.Set;

import com.cg.customermgt.customer.entities.Customer;
import com.cg.customermgt.item.entities.Item;


public interface ICustomerService {
	
	Customer findById(Long id);
	
	Customer createCustomer(String name);
	
	Customer addAmount(long customerId, double amount);

    Set<Item> itemsBoughtByCustomer(Long customerId);
    
    Customer update(Long id,String name);
}
