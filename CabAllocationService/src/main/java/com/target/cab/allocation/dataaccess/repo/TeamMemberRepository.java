package com.target.cab.allocation.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.target.cab.allocation.dataaccess.entity.TeamMember;

public interface TeamMemberRepository extends JpaRepository<TeamMember, Integer>{

}
