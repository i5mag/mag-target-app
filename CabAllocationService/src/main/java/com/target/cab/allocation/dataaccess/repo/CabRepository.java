package com.target.cab.allocation.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.target.cab.allocation.dataaccess.entity.Cab;

public interface CabRepository extends JpaRepository<Cab, String>{

}
