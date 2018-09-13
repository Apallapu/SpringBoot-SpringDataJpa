/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:Employee.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.rest.model;

import com.fasterxml.jackson.annotation.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class Employee.
 */
public class Employee {
	
	/** The emp id. */
	@JsonProperty("empId")
	private Long empId;
	
	/** The emp name. */
	@JsonProperty("empName")
	private String empName;

	/**
	 * Gets the emp id.
	 *
	 * @return the emp id
	 */
	public Long getEmpId() {
		return empId;
	}

	/**
	 * Sets the emp id.
	 *
	 * @param empId the new emp id
	 */
	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	/**
	 * Gets the emp name.
	 *
	 * @return the emp name
	 */
	public String getEmpName() {
		return empName;
	}

	/**
	 * Sets the emp name.
	 *
	 * @param empName the new emp name
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	/**
	 * Gets the salaray.
	 *
	 * @return the salaray
	 */
	public long getSalaray() {
		return salaray;
	}

	/**
	 * Sets the salaray.
	 *
	 * @param salaray the new salaray
	 */
	public void setSalaray(long salaray) {
		this.salaray = salaray;
	}

	/** The salaray. */
	@JsonProperty("salary")
	private long salaray;

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "EmployeeRequest [empId=" + empId + ", empName=" + empName + ", salaray=" + salaray + "]";
	}

}
