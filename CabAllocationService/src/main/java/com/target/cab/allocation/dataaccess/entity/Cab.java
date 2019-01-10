package com.target.cab.allocation.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Cab 
{
	@Id
	private String cabId;
	
	private int cost;
	
	private int capacity;

	public Cab() {
		super();
	}
	
	public Cab(String cabId, int cost, int capacity) {
		super();
		this.cabId = cabId;
		this.cost = cost;
		this.capacity = capacity;
	}

	public String getCabId() {
		return cabId;
	}

	public void setCabId(String cabId) {
		this.cabId = cabId;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	
	
}
