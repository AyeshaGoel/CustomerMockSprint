package com.cg.customermgt.item.service;

//import com.cg.customermgt.customer.dao.ICustomerDao;
//import com.cg.customermgt.item.dao.IItemDao;

import com.cg.customermgt.item.dao.IItemRepo;
import com.cg.customermgt.customer.dao.ICustomerRepo;
import com.cg.customermgt.item.entities.Item;
import com.cg.customermgt.customer.entities.Customer;

import com.cg.customermgt.customer.exceptions.CustomerNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cg.customermgt.item.exception.*;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import javax.persistence.EntityManager;

@Service
public class ItemServiceImpl implements IItemService{
	
	
//    @Autowired
//    private IItemDao dao;
//    
//    @Autowired
//    private ICustomerDao customerDao;
	
	@Autowired
	private IItemRepo itemRepository;
	
	@Autowired
	private ICustomerRepo customerRepository;

    @Autowired
	EntityManager entityManager;
    
    public String generateItemId() {
		Random random = new Random();
		Integer n = 1000000000 + random.nextInt(900000000);
		String itemId = n.toString();
		return itemId;
	}	

    @Transactional
    @Override
    public Item create(Double price, String description)
    {
//        Item item = new Item();
//        LocalDateTime localDateTime = LocalDateTime.now();
//
//        item.setPrice(price);
//        item.setDescription(description);
//        item.setAddedDate(localDateTime);
//
//        item = dao.add(item);
//        return item;
    	
		String itemId = generateItemId();
		LocalDateTime now = LocalDateTime.now();
		Item item = new Item(price, description);
		item.setId(itemId);
		item.setAddedDate(now);
		return itemRepository.save(item);
    }


	@Override
	public Item findByID(String itemId) {
//		return dao.findByID(itemId);
		Optional<Item> optional = itemRepository.findById(itemId);
		if(!optional.isPresent()) {
			throw new ItemNotFoundException("Cannot find item with id "+itemId);
		}
		return optional.get();
	}

	@Transactional
    @Override
    public Item buyItem(String itemId, Long customerId) {
//		Customer customer = customerDao.findById(customerId);
//		Item item = dao.findByID(itemId);
//		item.setBoughtBy(customer);
//		Item updatedItem =dao.update(item);
//		Set<Item> itemSet = customer.getBoughtItems();
//		itemSet.add(item);
//		customer.setBoughtItems(itemSet);
//		customerDao.update(customer);
//		return updatedItem;
		

		Optional<Customer> custOperational = customerRepository.findById(customerId);
		if(!custOperational.isPresent()) {
			throw new CustomerNotFoundException("Customer with id "+ customerId+" not found");
		}
		Customer customer = custOperational.get();
		
		Optional<Item> itemOptional = itemRepository.findById(itemId);
		if(!itemOptional.isPresent()) {
			throw new ItemNotFoundException("Cannot find item with id "+itemId);
		}
		Item item = itemOptional.get();
		
		item.setBoughtBy(customer);
		item = itemRepository.save(item);
		
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customer = customerRepository.save(customer);
		
		return item;
	}
}