package com.ers.valueobject;

import com.ers.valueobject.TeamDetailsVO;
/**
 *Employee.java
 *
 *Version:1.0
 *Date: 21-Mar-2016
 *Author:Kowsalya Jaganathan
 *
 *This class has employee details
 *
*/

public class EmployeeVO{
	int empId;
	String name;
	boolean isSupervisor;
	TeamDetailsVO teamDetails;
	

	public boolean isSupervisor() {
		return isSupervisor;
	}
	public void setSupervisor(boolean isSupervisor) {
		this.isSupervisor = isSupervisor;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public TeamDetailsVO getTeamDetails() {
		return teamDetails;
	}
	public void setTeamDetails(TeamDetailsVO teamDetails) {
		this.teamDetails = teamDetails;
	}
	
	
}