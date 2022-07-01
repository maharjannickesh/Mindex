package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@RestController
public class CompensationController {
	private static final Logger LOG = LoggerFactory.getLogger(CompensationController.class);
	
	@Autowired
	CompensationService compensationService;

	
	@PostMapping("/compensation")
	public Compensation createCompensiation (@RequestBody Compensation compensation) {
		  LOG.debug("Received compensation create request for [{}]", compensation);
		return compensationService.createCompensation(compensation);
	}
	
	@GetMapping("/compensation/{employeeId}")
	public Compensation getCompensationByEmployeeId(@PathVariable String employeeId) {
		LOG.debug("Received compensation get request for employee id [{}]", employeeId);
		return compensationService.getCompensationByEmployeeId(employeeId);
	}
	

}
