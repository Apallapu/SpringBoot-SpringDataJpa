/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartmentServiceImpl.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankamma.application.persistence.model.Department;
import com.ankamma.application.respository.DepartmentJpaRepository;
import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.DepartmentResponse;
import com.ankamma.application.service.DepartmentService;
import com.ankamma.application.util.DepartmentUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentServiceImpl.
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

	/** The department util. */
	@Autowired
	private DepartmentUtil departmentUtil;

	/** The department jpa repository. */
	@Autowired
	private DepartmentJpaRepository departmentJpaRepository;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ankamma.application.service.DepartmentService#createDepartMent(com.
	 * ankamma.application.rest.model.DepartmentRequest)
	 */
	@Override
	public DepartmentResponse createDepartMent(DepartmentRequest departmentRequest) {
		DepartmentResponse departmentResponse = new DepartmentResponse();
		Department department = departmentUtil.tranformEntity(departmentRequest);
		department = departmentJpaRepository.save(department);
		departmentResponse.setDepId(department.getDepartmentId());
		return departmentResponse;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ankamma.application.service.DepartmentService#getAllDepartMent()
	 */
	@Override
	public List<DepartMent> getAllDepartMent() {

		List<Department> department = departmentJpaRepository.findAll();
		return departmentUtil.tranformResponse(department);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.service.DepartmentService#getDepartMentById(java.lang
	 * .Long)
	 */
	@Override
	public DepartMent getDepartMentById(Long deptId) {
		Optional<Department> dept = departmentJpaRepository.findById(deptId);
		return departmentUtil.tranformResponseById(dept.get());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.service.DepartmentService#updateDepartMentById(java.
	 * lang.Long, com.ankamma.application.rest.model.DepartmentRequest)
	 */
	@Override
	public void updateDepartMentById(Long deptId, DepartmentRequest departmentRequest) {
		Optional<Department> dept = departmentJpaRepository.findById(deptId);
		departmentUtil.updateDepartMentByIdMapper(dept.get(), departmentRequest);
		departmentJpaRepository.save(dept.get());

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.ankamma.application.service.DepartmentService#deleteDept(java.lang.Long)
	 */
	@Override
	public void deleteDept(Long deptId) {
		departmentJpaRepository.deleteById(deptId);
	}

	public List<DepartMent> findByDeptName(String deptName) {
		// TODO Auto-generated method stub

		List<Department> deptList = departmentJpaRepository.findByDepartmentName(deptName);
		return departmentUtil.tranformResponse(deptList);
	}

}
