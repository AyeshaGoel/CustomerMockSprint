package com.cg.customermgt.item.controller;

import com.cg.customermgt.item.dto.*;
import com.cg.customermgt.item.entities.Item;
import com.cg.customermgt.item.service.IItemService;
import com.cg.customermgt.item.util.ItemUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/items")
@RestController
public class ItemRestController
{
    @Autowired
    private IItemService service;
    
    @Autowired
	private ItemUtil util;
    
    
    @PutMapping("/buyItem")
	public ItemDetails buyItem(@RequestBody BuyItemRequest requestBody) {
		Item item=service.buyItem(requestBody.getItemId(), requestBody.getCustId());
		return util.toDetails(item);
	}
	
	
	@GetMapping(value = "/findByItemId/{id}")
	public ItemDetails getItemById(@PathVariable("id") String itemId) {
		Item item = service.findByID(itemId);
		return  util.toDetails(item);
	}

}