package com.target.cab.allocation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.target.cab.allocation.dataaccess.entity.TeamMember;
import com.target.cab.allocation.dataaccess.repo.TeamMemberRepository;
import com.target.cab.allocation.model.CustomException;

@Component
public class TeamMemberRegisterService {

	@Autowired
	private TeamMemberRepository teamMemberRepository;

	public void saveTeamMember(TeamMember teamMember) throws CustomException {
		
		try {
			teamMemberRepository.save(teamMember);
		} catch (Exception ex) {
			throw new CustomException("Error while registering Team Member");
		}
	}

	public List<TeamMember> fetchAllTeamMembers() {
		return teamMemberRepository.findAll();
	}
	
}
