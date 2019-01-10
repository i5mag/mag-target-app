package com.target.cab.allocation.dataaccess.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.target.cab.allocation.dataaccess.entity.DropPoints;

public interface DropPointsRepository extends JpaRepository<DropPoints, String> {

}
