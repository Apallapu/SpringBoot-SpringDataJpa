/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartmentController.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.DepartmentResponse;

// TODO: Auto-generated Javadoc
/**
 * The Interface DepartmentController.
 */

public interface DepartmentController {

	/**
	 * Creates the department.
	 *
	 * @param departmentRequest the department request
	 * @return the department response
	 */
	@PostMapping(path = "/depart", consumes = "application/json", produces = "application/json")
	public DepartmentResponse createDepartment(@RequestBody DepartmentRequest departmentRequest);

	/**
	 * Gets the all depart ment.
	 *
	 * @return the all depart ment
	 */
	@GetMapping(path = "/getAllDepts", produces = "application/json")
	public List<DepartMent> getAllDepartMent();

	/**
	 * Gets the depart ment by id.
	 *
	 * @param deptId the dept id
	 * @return the depart ment by id
	 */
	@GetMapping(path = "/getAllDepts/{deptId}", produces = "application/json")
	public DepartMent getDepartMentById(@PathVariable Long deptId);

	/**
	 * Update depart ment by id.
	 *
	 * @param deptId            the dept id
	 * @param departmentRequest the department request
	 */
	@PutMapping(path = "/dept/{deptId}", consumes = "application/json", produces = "application/json")
	public void updateDepartMentById(@PathVariable Long deptId, @RequestBody DepartmentRequest departmentRequest);

	/**
	 * Delete dept.
	 *
	 * @param deptId the dept id
	 */
	@DeleteMapping("/dept/{deptId}")
	public void deleteDept(@PathVariable Long deptId);

	@GetMapping(path = "/findByDeptName", produces = "application/json")
	public List<DepartMent> findByDeptName(@RequestParam String depName);

}
