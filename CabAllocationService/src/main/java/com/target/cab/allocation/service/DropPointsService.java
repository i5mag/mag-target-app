package com.target.cab.allocation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.target.cab.allocation.dataaccess.entity.DropPoints;
import com.target.cab.allocation.dataaccess.repo.DropPointsRepository;
import com.target.cab.allocation.model.CustomException;

@Component
public class DropPointsService {

	@Autowired
	private DropPointsRepository dropPointsRepository;

	public void saveDropPoints(List<DropPoints> dropPoints) throws CustomException {
		
		try {
			dropPointsRepository.deleteAll();
			dropPointsRepository.saveAll(dropPoints);
		} catch (Exception ex) {
			throw new CustomException("Error while saving dropPoints");
		}
	}

	public boolean validateDropPoint(String dropPointName) throws CustomException {
		return dropPointsRepository.existsById(dropPointName);
	}
}
