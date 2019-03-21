package com.centraprise.hrmodule.model;

public class EmployeeListDTO {

	private int id;
	private String name;
	private int employeeId;
	private String panNumber;
	private String joiningDate;

	public EmployeeListDTO() {

	}

	public EmployeeListDTO(int id, String name, int employeeId, String panNumber, String joiningDate) {
		this.id = id;
		this.name = name;
		this.employeeId = employeeId;
		this.panNumber = panNumber;
		this.joiningDate = joiningDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPanNumber() {
		return panNumber;
	}

	public void setPanNumber(String panNumber) {
		this.panNumber = panNumber;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	@Override
	public String toString() {
		return "EmployeeListDTO [id=" + id + ", name=" + name + ", employeeId=" + employeeId + ", panNumber="
				+ panNumber + ", joiningDate=" + joiningDate + "]";
	}

}
