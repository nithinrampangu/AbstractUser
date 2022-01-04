package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser{
	
	@Id
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + "]";
	}
	
	

}
