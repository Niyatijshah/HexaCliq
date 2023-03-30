package com.hexaware.hexacliq.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hexaware.hexacliq.dto.AttendanceDto;
import com.hexaware.hexacliq.service.AttendanceService;

@RestController
@RequestMapping("/attendance")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@PostMapping("/submit")
	public ResponseEntity<String> post( List<AttendanceDto> form){
		String response = attendanceService.submitAttendance(form);
		 return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
	@GetMapping("/getMarkedAttendance/{month}")
	public ResponseEntity<String> getMarkedAttendance( @PathVariable("month") String month){
		String response = attendanceService.getMarkedAttendance(month);
		 return new ResponseEntity<String>(response,HttpStatus.CREATED);
	}
	
}