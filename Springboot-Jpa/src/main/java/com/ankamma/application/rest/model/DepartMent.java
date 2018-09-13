/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartMent.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.rest.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartMent.
 */
public class DepartMent {
	
	/** The deptid. */
	@JsonProperty("deptId")
	private Long deptid;
	
	/** The dept name. */
	@JsonProperty("deptName")
	private String deptName;
	
	/** The employee. */
	@JsonProperty("employee")
	private List<Employee> employee;

	
	/**
	 * Gets the deptid.
	 *
	 * @return the deptid
	 */
	public Long getDeptid() {
		return deptid;
	}

	/**
	 * Sets the deptid.
	 *
	 * @param deptid the new deptid
	 */
	public void setDeptid(Long deptid) {
		this.deptid = deptid;
	}

	/**
	 * Gets the dept name.
	 *
	 * @return the dept name
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * Sets the dept name.
	 *
	 * @param deptName the new dept name
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	/**
	 * Gets the employee.
	 *
	 * @return the employee
	 */
	public List<Employee> getEmployee() {
		return employee;
	}

	/**
	 * Sets the employee.
	 *
	 * @param employee the new employee
	 */
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "DepartmentRequest [deptid=" + deptid + ", deptName=" + deptName + ", employee=" + employee + "]";
	}


}
