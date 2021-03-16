package com.cg.customermgt.item.service;

import com.cg.customermgt.customer.dao.ICustomerDao;
import com.cg.customermgt.item.dao.IItemDao;
import com.cg.customermgt.item.entities.Item;
import com.cg.customermgt.customer.entities.Customer;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.EntityManager;

@Service
public class ItemServiceImpl implements IItemService{
	
	
    @Autowired
    private IItemDao dao;
    
    @Autowired
    private ICustomerDao customerDao;

    @Autowired
	EntityManager entityManager;
    

    @Transactional
    @Override
    public Item create(Double price, String description)
    {
        Item item = new Item();
        LocalDateTime localDateTime = LocalDateTime.now();

        item.setPrice(price);
        item.setDescription(description);
        item.setAddedDate(localDateTime);

        item = dao.add(item);
        return item;
    }


	@Override
	public Item findByID(String itemId) {
		return dao.findByID(itemId);
	}

	@Transactional
    @Override
    public Item buyItem(String itemId, Long customerId) {
		Customer customer = customerDao.findById(customerId);
		Item item = dao.findByID(itemId);
		item.setBoughtBy(customer);
		Item updatedItem =dao.update(item);
		Set<Item> itemSet = customer.getBoughtItems();
		itemSet.add(item);
		customer.setBoughtItems(itemSet);
		customerDao.update(customer);
		return updatedItem;
	}
}