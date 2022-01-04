package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer extends AbstractUser{
	
	@Id
	private int customerId;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + "]";
	}
	
	

}
