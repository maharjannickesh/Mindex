package com.mindex.challenge.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingService;

@RestController
public class ReportingController {

	private static final Logger LOG = LoggerFactory.getLogger(ReportingController.class);

	@Autowired
	ReportingService reportingService;

	@RequestMapping("/employee/{employeeId}/reports")
	public ReportingStructure getEmployeeDirectReport(@PathVariable String employeeId) {
		LOG.debug("Received Reporting get getEmployeeDirectReport request for employee id [{}]", employeeId);
		return reportingService.getEmployeeDirectReport(employeeId);

	}

}
