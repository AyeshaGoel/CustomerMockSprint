package com.cg.customermgt.customer.controller;

import com.cg.customermgt.customer.dto.*;
import com.cg.customermgt.customer.entities.Customer;
import com.cg.customermgt.customer.service.ICustomerService;
import com.cg.customermgt.customer.util.CustomerUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/customers")
@RestController
public class CustomerRestController
{
    @Autowired
    ICustomerService service;
    @Autowired
    CustomerUtil util;

    @GetMapping(value = "/bycustomerid/{id}")
    public CustomerDetails fetchCustomer(@PathVariable("id") Long id)
    {
        Customer customer = service.findById(id);
        return util.toDetail(customer);
    }
    
        
    @PutMapping(value = "/addAmount")
    public CustomerDetails addAmount(@RequestBody AddAmountRequest addAmountRequest)
    {
        Customer customer = service.addAmount(addAmountRequest.getCustomerId(),addAmountRequest.getAmount());
        return util.toDetail(customer);
    }
    
  


}
