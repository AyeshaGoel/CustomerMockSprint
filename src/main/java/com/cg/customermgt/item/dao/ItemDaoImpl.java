package com.cg.customermgt.item.dao;

import com.cg.customermgt.item.entities.Item;
import org.springframework.stereotype.Repository;

import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ItemDaoImpl implements IItemDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	
	public String generateItemId() {
		Random random = new Random();
		Integer n = 1000000000 + random.nextInt(900000000);
		String itemId = n.toString();
		return itemId;
	}	 
	 
	@Override
	public Item add(Item item) {
		String id = generateItemId();
		item.setId(id);
		entityManager.persist(item);
		return item;
	}
	
	@Override
    public Item findByID(String itemID)
    {
        Item item = entityManager.find(Item.class,itemID);
        return item;
    }

	@Override
	public Item update(Item item) {
		item = entityManager.merge(item);
		return item;
	}
}