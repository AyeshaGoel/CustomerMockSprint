package com.cg.customermgt.item.util;


import com.cg.customermgt.item.dto.ItemDetails;
import com.cg.customermgt.item.entities.Item;


import org.springframework.stereotype.Component;

@Component
public class ItemUtil
{
    	public ItemDetails toDetails(Item item) {
    		ItemDetails details = new ItemDetails(item.getId(), item.getPrice(), item.getDescription()
    				,item.getBoughtBy().getId(), item.getBoughtBy().getName());
    		return details;
    }
}
