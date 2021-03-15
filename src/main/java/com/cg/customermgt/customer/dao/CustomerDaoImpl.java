package com.cg.customermgt.customer.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.cg.customermgt.customer.entities.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Transactional
	 @Override
	public Customer add(Customer customer) {
		entityManager.persist(customer);
		return customer;
	}

	@Transactional
	@Override
	public Customer findById(Long id) {
		Customer customer=entityManager.find(Customer.class,id);
		return customer;
	}
	 
	@Transactional
	@Override
	public Customer update(Customer customer) {
		customer=entityManager.merge(customer);
		return customer;
	}
}
