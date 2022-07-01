package com.mindex.challenge.service;

import java.util.Date;

import com.mindex.challenge.data.Compensation;
import com.mindex.challenge.service.impl.CompensationServiceImpl;

public interface CompensationService {

	public Compensation createCompensation(Compensation compensation);

	public Compensation getCompensationByEmployeeId(String employeeID);

}
