package com.cg.customermgt.customer.service;

import com.cg.customermgt.customer.dao.ICustomerRepo;
import com.cg.customermgt.customer.dao.IAccountRepo;
import com.cg.customermgt.customer.entities.*;
import com.cg.customermgt.customer.exceptions.*;

import com.cg.customermgt.item.entities.Item;

import java.time.LocalDateTime;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService{

//	@Autowired
//	public ICustomerDao dao;	
	
	@PersistenceContext
	EntityManager entityManager;
	
	@Autowired
	private ICustomerRepo customerRepository;
	
	@Autowired
	private IAccountRepo accountRepository;
	
	@Override
	public Customer findById(Long id) {
		//Customer customer=dao.findById(id);
		//return customer;	
		
		Optional<Customer> optional = customerRepository.findById(id);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+id+" not found");
		}
		return optional.get();
		
	}
	
	@Transactional
	@Override
	public Customer createCustomer(String name) {
//		LocalDateTime now = LocalDateTime.now();
//		Account account = new Account(0, now);
//		entityManager.persist(account);
//		Customer customer = new Customer(name, account);
//		dao.add(customer);
//		return customer;
		
		validateName(name);
		LocalDateTime now = LocalDateTime.now();
		Account account = new Account();
		account.setCreated(now);
		accountRepository.save(account);
		Customer customer = new Customer(name, account);
		customerRepository.save(customer);
		return customer;
	}
	

	@Transactional
	@Override
	public Customer addAmount(long customerId, double amount) {
//		Customer customer = dao.findById(customerId);
//		customer.getAccount().setBalance(amount);
//		customer = dao.update(customer);
//		return customer;
		

		Customer customer = findById(customerId);
		customer.getAccount().setBalance(amount);
		customerRepository.save(customer);
		return customer;
	
	}
	
	@Override
	public Set<Item> itemsBoughtByCustomer(Long customerId) {
//		Customer customer = entityManager.find(Customer.class, customerId);
//		Set<Item> itemSet = customer.getBoughtItems();
//		return itemSet;
		
		Optional<Customer> optional = customerRepository.findById(customerId);
		if(!optional.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+customerId+" not found");
		}
		Customer customer = optional.get();
		Set<Item> itemSet = customer.getBoughtItems();
		return itemSet;
	}
	 void validateName(String name)
	   {
			if(name==null || name.isEmpty() || name.trim().isEmpty())
			{
				throw new InvalidNameException("name can't be null or empty");
			}
		}
}
