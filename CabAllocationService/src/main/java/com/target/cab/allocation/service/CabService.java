package com.target.cab.allocation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.target.cab.allocation.dataaccess.entity.Cab;
import com.target.cab.allocation.dataaccess.repo.CabRepository;
import com.target.cab.allocation.model.CustomException;

@Component
public class CabService {

	@Autowired
	private CabRepository cabRepository;

	public void saveCabs(List<Cab> cabsList) throws CustomException {
		
		try {
			cabRepository.saveAll(cabsList);
		} catch (Exception ex) {
			throw new CustomException(ex.getMessage());
		}
	}

}
