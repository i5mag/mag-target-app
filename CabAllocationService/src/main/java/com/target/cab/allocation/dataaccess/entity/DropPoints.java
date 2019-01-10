package com.target.cab.allocation.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DropPoints 
{
	private Long slNo;
	
	@Id
	private String dropPointName;
	
	private String dropDistances;
	
	public DropPoints() {
		super();
	}

	public DropPoints(Long slNo, String dropPointName, String dropDistances) {
		super();
		this.slNo = slNo;
		this.dropPointName = dropPointName;
		this.dropDistances = dropDistances;
	}

	public Long getSlNo() {
		return slNo;
	}

	public void setSlNo(Long slNo) {
		this.slNo = slNo;
	}

	public String getDropPointName() {
		return dropPointName;
	}

	public void setDropPointName(String dropPointName) {
		this.dropPointName = dropPointName;
	}

	public String getDropDistances() {
		return dropDistances;
	}

	public void setDropDistances(String dropDistances) {
		this.dropDistances = dropDistances;
	}
}
