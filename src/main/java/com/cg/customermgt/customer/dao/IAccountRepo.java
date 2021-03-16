package com.cg.customermgt.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customermgt.customer.entities.Account;

public interface IAccountRepo extends JpaRepository<Account , Long> {
	

}
