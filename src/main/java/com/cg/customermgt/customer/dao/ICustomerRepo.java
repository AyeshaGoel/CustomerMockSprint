package com.cg.customermgt.customer.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.customermgt.customer.entities.Customer;

public interface ICustomerRepo extends JpaRepository<Customer, Long>{

}
