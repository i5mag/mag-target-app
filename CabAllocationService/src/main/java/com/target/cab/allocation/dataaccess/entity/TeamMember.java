package com.target.cab.allocation.dataaccess.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class TeamMember 
{
	@Id
	private Integer teamMemberId;
	
	private String gender;
	
	private String dropPoint;
	
	public TeamMember() {
		super();
	}

	public TeamMember(Integer teamMemberId, String gender, String dropPoint) {
		super();
		this.teamMemberId = teamMemberId;
		this.gender = gender;
		this.dropPoint = dropPoint;
	}

	public Integer getTeamMemberId() {
		return teamMemberId;
	}

	public void setTeamMemberId(Integer teamMemberId) {
		this.teamMemberId = teamMemberId;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDropPoint() {
		return dropPoint;
	}

	public void setDropPoint(String dropPoint) {
		this.dropPoint = dropPoint;
	}
}
