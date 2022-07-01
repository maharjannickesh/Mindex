package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.ReportingService;

@Service
public class ReportingServiceImpl implements ReportingService {

	private static final Logger LOG = LoggerFactory.getLogger(ReportingServiceImpl.class);

	@Autowired
	private EmployeeRepository employeeRepository;

	public ReportingStructure getEmployeeDirectReport(String employeeID) {
		LOG.debug("Getting employee Direct Report  with employeeID [{}]", employeeID);
		Employee employee = employeeRepository.findByEmployeeId(employeeID);
		if (employee == null) {
			throw new RuntimeException("Invalid employeeId: " + employeeID);
		}
		ReportingStructure rs = new ReportingStructure();
		rs.setEmployee(employee);
		rs.setNumberOfReports(employee.getDirectReports().size());
		return rs;
	}

}
