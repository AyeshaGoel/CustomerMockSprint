package com.cg.customermgt.item.service;

import com.cg.customermgt.item.entities.Item;

public interface IItemService
{
   public Item create(Double price, String description);
   public Item findByID(String itemID);
   public Item buyItem(String itemID, Long customerID);
}