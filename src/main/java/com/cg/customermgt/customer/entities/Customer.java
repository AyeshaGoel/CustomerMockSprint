package com.cg.customermgt.customer.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.cg.customermgt.item.entities.Item;

@Entity
public class Customer {
	
	@GeneratedValue
	@Id
	private Long id;
	private String name;
	//Set<Item> boughtItem
	
	@OneToOne
	private Account account;
	
	@OneToMany
	private Set<Item> boughtItems;
	
	public Customer() {
		
	}


	public Customer( String name, Account account) {
	
		this.name = name;
		this.account = account;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Account getAccount() {
		return account;
	}


	public void setAccount(Account account) {
		this.account = account;
	}

	public Set<Item> getBoughtItems() {
	return boughtItems;
}

public void setBoughtItems(Set<Item> boughtItems) {
	this.boughtItems = boughtItems;
}
	
	
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + "]";
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
		

}
