/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartmentControllerImpl.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ankamma.application.controller.DepartmentController;
import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.DepartmentResponse;
import com.ankamma.application.service.DepartmentService;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentControllerImpl.
 */
@RestController
public class DepartmentControllerImpl implements DepartmentController {

	/** The department service. */
	@Autowired
	private DepartmentService departmentService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.controller.DepartmentController#createDepartment(com.
	 * ankamma.application.rest.model.DepartmentRequest)
	 */
	@Override
	public DepartmentResponse createDepartment(@RequestBody DepartmentRequest departmentRequest) {
		DepartmentResponse departmentRespons = departmentService.createDepartMent(departmentRequest);
		return departmentRespons;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.controller.DepartmentController#getAllDepartMent()
	 */
	@Override
	public List<DepartMent> getAllDepartMent() {

		return departmentService.getAllDepartMent();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.controller.DepartmentController#getDepartMentById(
	 * java.lang.Long)
	 */
	@Override
	public DepartMent getDepartMentById(@PathVariable Long deptId) {
		return departmentService.getDepartMentById(deptId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.controller.DepartmentController#updateDepartMentById(
	 * java.lang.Long, com.ankamma.application.rest.model.DepartmentRequest)
	 */
	@Override
	public void updateDepartMentById(Long deptId, DepartmentRequest departmentRequest) {
		// TODO Auto-generated method stub
		departmentService.updateDepartMentById(deptId, departmentRequest);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.controller.DepartmentController#deleteDept(java.lang.
	 * Long)
	 */
	@Override
	public void deleteDept(@PathVariable Long deptId) {

		departmentService.deleteDept(deptId);

	}

	@Override
	public List<DepartMent> findByDeptName(String depName) {
		// TODO Auto-generated method stub
		return departmentService.findByDeptName(depName);
	}

}
