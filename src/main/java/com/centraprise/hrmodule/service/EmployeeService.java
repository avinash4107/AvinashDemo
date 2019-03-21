package com.centraprise.hrmodule.service;

import java.util.List;

import com.centraprise.hrmodule.model.EmployeeCommand;
import com.centraprise.hrmodule.model.EmployeeListDTO;

public interface EmployeeService {

	List<EmployeeListDTO> getEmployeesList();

	void saveEmployee(EmployeeCommand employeeDetails);
}
