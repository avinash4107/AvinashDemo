package com.centraprise.hrmodule.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.centraprise.hrmodule.entity.EmployeeDetails;
import com.centraprise.hrmodule.exception.DatabaseException;
import com.centraprise.hrmodule.model.EmployeeCommand;
import com.centraprise.hrmodule.model.EmployeeInfoCommand;
import com.centraprise.hrmodule.model.EmployeeListDTO;
import com.centraprise.hrmodule.service.EmployeeService;

@Controller
@PreAuthorize("hasAnyRole('ADMIN')")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/emp")
	public String getEmp() {
		return "redirect:/employeeList";
	}

	@RequestMapping("/employeeList")
	public String getEmployeeList(Model model, HttpServletRequest request) {
		List<EmployeeListDTO> employeeDetails = null;
		try {
			employeeDetails = employeeService.getEmployeesList();
			if (employeeDetails != null) {
				model.addAttribute("employees", employeeDetails);
			}
		} catch (DatabaseException e) {

		} catch (Exception e) {

		}

		return "employee";
	}

	@GetMapping("/addemployee")
	public String getNewEmployeeForm(Model model) {
		model.addAttribute("employeeForm", new EmployeeCommand());
		return "addEmployee";
	}

	@PostMapping("/addemployee")
	public String addNewEmployee(@ModelAttribute("employeeForm") EmployeeCommand employeeDetails,
			BindingResult result) {
		try {
			System.out.println(employeeDetails);
			employeeService.saveEmployee(employeeDetails);
		} catch (DatabaseException e) {

		} catch (Exception e) {

		}
		return "redirect:/employeeList";
	}

	@GetMapping("/employeeInfo")
	public String getEmployeeInfo(Model model) {
		model.addAttribute("employeeInfo", new EmployeeInfoCommand());
		return "employeeInfo";
	}

}
