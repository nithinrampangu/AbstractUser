package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Activity {
	
	@Id
	private int activityId;
	private String description;
	private float charges;
	public int getActivityId() {
		return activityId;
	}
	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCharges() {
		return charges;
	}
	public void setCharges(float charges) {
		this.charges = charges;
	}
	@Override
	public String toString() {
		return "Activity [activityId=" + activityId + ", description=" + description + ", charges=" + charges + "]";
	}
	
	

}
