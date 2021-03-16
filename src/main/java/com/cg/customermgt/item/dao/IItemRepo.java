package com.cg.customermgt.item.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cg.customermgt.item.entities.Item;

public interface IItemRepo extends JpaRepository< Item , String>{
	
}
