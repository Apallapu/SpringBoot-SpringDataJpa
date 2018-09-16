/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartmentService.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.service;

import java.util.List;

import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.DepartmentResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface DepartmentService.
 */

public interface DepartmentService {

	/**
	 * Creates the depart ment.
	 *
	 * @param departmentRequest the department request
	 * @return the department response
	 */
	DepartmentResponse createDepartMent(DepartmentRequest departmentRequest);

	/**
	 * Gets the all depart ment.
	 *
	 * @return the all depart ment
	 */
	List<DepartMent> getAllDepartMent();

	/**
	 * Gets the depart ment by id.
	 *
	 * @param deptId the dept id
	 * @return the depart ment by id
	 */
	DepartMent getDepartMentById(Long deptId);

	/**
	 * Update depart ment by id.
	 *
	 * @param deptId the dept id
	 * @param departmentRequest the department request
	 */
	void updateDepartMentById(Long deptId, DepartmentRequest departmentRequest);

	/**
	 * Delete dept.
	 *
	 * @param deptId the dept id
	 */
	void deleteDept(Long deptId);

	List<DepartMent> findByDeptName(String depName);

}
