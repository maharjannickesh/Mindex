package com.mindex.challenge.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mindex.challenge.dao.CompensationRepository;
import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.CompensationService;

@Service
public class CompensationServiceImpl implements CompensationService {

	private static final Logger LOG = LoggerFactory.getLogger(CompensationServiceImpl.class);

	@Autowired
	CompensationRepository compensationRepository;

	public Compensation createCompensation(Compensation compensation) {
		LOG.debug("Creating compensation [{}]", compensation);
		return compensationRepository.insert(compensation);

	}

	@Override
	public Compensation getCompensationByEmployeeId(String employeeID) {
		LOG.debug("Getting Compensiation of employee with id [{}]", employeeID);
		if (employeeID == null) {
			throw new RuntimeException("Invalid employeeId: " + employeeID);
		}

		return compensationRepository.findCompensationbyEmployeeID(employeeID);
	}

}
