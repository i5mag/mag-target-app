package com.target.cab.allocation.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.target.cab.allocation.dataaccess.entity.Cab;
import com.target.cab.allocation.dataaccess.entity.DropPoints;
import com.target.cab.allocation.dataaccess.entity.TeamMember;
import com.target.cab.allocation.model.CustomException;
import com.target.cab.allocation.model.DropPointsVO;
import com.target.cab.allocation.model.StatusVO;
import com.target.cab.allocation.service.CabService;
import com.target.cab.allocation.service.DropPointsService;
import com.target.cab.allocation.service.TeamMemberRegisterService;

@RestController
@RequestMapping("/target")
public class CabAllocationController {

	@Autowired
	private TeamMemberRegisterService teamMemberRegisterService;

	@Autowired
	private DropPointsService dropPointsService;

	@Autowired
	private CabService cabService;

	@PostMapping(value = "/register")
	public ResponseEntity<StatusVO> registerTeamMember(@RequestBody List<TeamMember> teamMembersList) throws CustomException {
		
		if(teamMembersList != null && !teamMembersList.isEmpty()) {
			for(TeamMember teamMember : teamMembersList) {
				if (dropPointsService.validateDropPoint(teamMember.getDropPoint())) {
					teamMemberRegisterService.saveTeamMember(teamMember);
				} else {
					throw new CustomException("Invalid Drop Point.  Drop Point does not exist");
				}
			}
		}
		
		StatusVO responseStatus = new StatusVO("Success", String.valueOf(HttpStatus.CREATED.value()), null);
		return new ResponseEntity<StatusVO>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping(value = "/cabs")
	public ResponseEntity<StatusVO> saveCabs(@RequestBody List<Cab> cabsList) throws CustomException {
		
		if (cabsList != null && !cabsList.isEmpty()) {
			List<TeamMember> availableTeamMembersList = teamMemberRegisterService.fetchAllTeamMembers();
			boolean isSecurityRequired = true;
			int totalCabCapacity = 0;
			
			for (TeamMember teamMember : availableTeamMembersList) {
				if (teamMember.getGender().equals("M")) {
					isSecurityRequired = false;
					break;
				}
			}
			
			for (Cab cab : cabsList) {
				totalCabCapacity = isSecurityRequired ? (totalCabCapacity + (cab.getCapacity() - 1)) : (totalCabCapacity + cab.getCapacity());
			}
			
			if (totalCabCapacity < availableTeamMembersList.size()) {
				throw new CustomException("Cab Capacity is less to accommodate the Team members");
			} else {
				cabService.saveCabs(cabsList);
			}
		}
		
		StatusVO responseStatus = new StatusVO("Success", String.valueOf(HttpStatus.CREATED.value()), null);
		return new ResponseEntity<StatusVO>(responseStatus, HttpStatus.CREATED);
	}

	@PostMapping(value = "/drop_points")
	public ResponseEntity<StatusVO> saveDropPoints(@RequestBody DropPointsVO dropPoints) throws CustomException {
		
		List<DropPoints> dropPointsList = new ArrayList<DropPoints>();
		dropPointsList.add(createDropPointsMapper(1L, "target_headquarter", dropPoints));
		dropPointsList.add(createDropPointsMapper(2L, "pointA", dropPoints));
		dropPointsList.add(createDropPointsMapper(3L, "pointB", dropPoints));
		dropPointsList.add(createDropPointsMapper(4L, "pointC", dropPoints));
		dropPointsList.add(createDropPointsMapper(5L, "pointD", dropPoints));
		dropPointsList.add(createDropPointsMapper(6L, "pointE", dropPoints));
		
		dropPointsService.saveDropPoints(dropPointsList);
		
		StatusVO responseStatus = new StatusVO("Success", String.valueOf(HttpStatus.CREATED.value()), null);
		return new ResponseEntity<StatusVO>(responseStatus, HttpStatus.CREATED);
	}

	private DropPoints createDropPointsMapper(Long slNo, String dropPoint, DropPointsVO dropPointsVO) {
		
		DropPoints dropPoints = new DropPoints();
		
		switch (dropPoint) {
		case "target_headquarter":
			dropPoints.setSlNo(slNo);
			dropPoints.setDropPointName("target_headquarter");
			dropPoints.setDropDistances(dropPointsVO.getTarget_headquarter());
			break;
		
		case "pointA":
			dropPoints.setSlNo(slNo);
			dropPoints.setDropPointName("pointA");
			dropPoints.setDropDistances(dropPointsVO.getPointA());
			break;
		
		case "pointB":
			dropPoints.setSlNo(slNo);
			dropPoints.setDropPointName("pointB");
			dropPoints.setDropDistances(dropPointsVO.getPointB());
			break;
		
		case "pointC":
			dropPoints.setSlNo(slNo);
			dropPoints.setDropPointName("pointC");
			dropPoints.setDropDistances(dropPointsVO.getPointC());
			break;
		
		case "pointD":
			dropPoints.setSlNo(slNo);
			dropPoints.setDropPointName("pointD");
			dropPoints.setDropDistances(dropPointsVO.getPointD());
			break;
		
		case "pointE":
			dropPoints.setSlNo(slNo);
			dropPoints.setDropPointName("pointE");
			dropPoints.setDropDistances(dropPointsVO.getPointE());
			break;
		}
		
		return dropPoints;
	}
}
