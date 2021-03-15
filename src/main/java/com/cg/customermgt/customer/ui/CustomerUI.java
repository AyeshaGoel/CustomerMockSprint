package com.cg.customermgt.customer.ui;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.customermgt.customer.entities.*;
import com.cg.customermgt.customer.service.ICustomerService;
import com.cg.customermgt.item.service.*;
import com.cg.customermgt.item.entities.Item;

//import com.cg.customermgt.item.service.IItemService;

@Component
public class CustomerUI {

	@Autowired
	ICustomerService service;

	@Autowired
	private IItemService itemService;

	public void start() {
		System.out.println("      CUSTOMER DETAILS \n");

		Customer ayesha = service.createCustomer("Ayesha");
		display(ayesha);

		Customer shivangi = service.createCustomer("Shivangi");
		display(shivangi);

		Customer findCustomer = service.findById(2L);
		display(findCustomer);

		Long ayeshaId = ayesha.getId();
		Customer ayeshaAmount = service.addAmount(ayeshaId, 4000.0);
		display(ayeshaAmount);

		Long shivangiId = shivangi.getId();
		Customer shivangiAmount = service.addAmount(shivangiId, 2570.0);
		display(shivangiAmount);

		Long id = ayesha.getId();
		Customer fetchedCustomer = service.findById(2L);
		System.out.println("-------------------------");
		System.out.println("Fetched Customer");
		display(fetchedCustomer);

		

		Item kiwi = itemService.create(250.0, "Kiwi ");
		displayItem(kiwi);

		Item apple = itemService.create(200.0, "Apple ");
		displayItem(apple);

		Item grapes = itemService.create(80.50, "Grapes");
		displayItem(grapes);

		
		System.out.println("Finding an item with id");
		String itemId = apple.getId();
		Item findItem = itemService.findByID(itemId);
		displayItem(findItem);
		
		Item buykiwi=itemService.buyItem(kiwi.getId(),shivangi.getId());
		shivangi=service.findById(shivangi.getId());
		 displayItem(buykiwi);
		 display(shivangi);

	}

	void display(Customer customer) {
		Account account = customer.getAccount();
		System.out.println("Customer \t" + customer.getId() + "\t " + customer.getName() + "\t "
				+ account.getAccountId() + "\t " + account.getBalance() + " \t" + account.getCreated());
	}

	public void displayItem(Item item) {
		if(item.getBoughtBy()== null ) {
		System.out.println("ID:" + item.getId() + "\nDescription:" + item.getDescription() + "\nPrice:"
				+ item.getPrice() + "\nAddedDate" + item.getAddedDate());
	}
		else
		{
			System.out.println("ID:" + item.getId() + "\nDescription:" + item.getDescription() + "\nPrice:"
					+ item.getPrice() + "\nAddedDate" + item.getAddedDate() + " "+item.getBoughtBy().getName());
		}
	}
}
