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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ankamma.application.persistence.model.Department;
import com.ankamma.application.persistence.model.Employee;
import com.ankamma.application.respository.DepartmentJpaRepository;
import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.DepartmentResponse;
import com.ankamma.application.rest.model.EmployeeRequest;
import com.ankamma.application.util.DepartmentUtil;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentServiceImpl.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DepartmentServiceImpl.class)
public class DepartmentServiceImplTest {

	/** The department service. */
	@MockBean
	private DepartmentUtil departmentUtil;

	/** The department jpa repository. */
	@MockBean
	private DepartmentJpaRepository departmentJpaRepository;

	@Autowired
	private DepartmentServiceImpl departmentService;

	@Test
	public void testCreateDept() {
		DepartmentRequest departmentRequest = buildDepartmentRequest();
		Department department = buildDepartment();
		when(departmentUtil.tranformEntity(departmentRequest)).thenReturn(department);
		when(departmentJpaRepository.save(department)).thenReturn(department);
		DepartmentResponse response = departmentService.createDepartMent(departmentRequest);

		assertThat(response.getDepId()).isEqualTo(1);

	}

	@Test
	public void testupdateDept() {
		DepartmentRequest departmentRequest = buildDepartmentRequest();
		Department department = buildDepartment();
		Long deptId = 1l;
		Mockito.doNothing().when(departmentUtil).updateDepartMentByIdMapper(department, departmentRequest);
		when(departmentJpaRepository.findById(deptId)).thenReturn(Optional.ofNullable(department));
		departmentService.updateDepartMentById(deptId, departmentRequest);
		when(departmentJpaRepository.save(department)).thenReturn(department);

	}

	@Test
	public void testgetDeptAll() {

		List<Department> department = buildDepartmentList();
		List<DepartMent> dept = buildDept();

		when(departmentJpaRepository.findAll()).thenReturn(department);
		when(departmentUtil.tranformResponse(department)).thenReturn(dept);
		List<DepartMent> response = departmentService.getAllDepartMent();
		assertThat(response).isNotEmpty();

	}

	@Test
	public void testgetDeptById() {

		DepartMent departMent = buildDepartMent();
		Department department = buildDepartment();
		Long deptId = 1l;
		when(departmentJpaRepository.findById(deptId)).thenReturn(Optional.ofNullable(department));
		when(departmentUtil.tranformResponseById(department)).thenReturn(departMent);
		DepartMent response = departmentService.getDepartMentById(deptId);
		assertThat(response.getDeptid()).isEqualTo(1l);
		assertThat(response).isNotNull();

	}

	@Test
	public void testdeleteDept() {

		Long deptId = 1l;
		Mockito.doNothing().when(departmentJpaRepository).deleteById(deptId);

		departmentService.deleteDept(deptId);

	}

	@Test
	public void testFindDeptName() {

		List<Department> department = buildDepartmentList();
		List<DepartMent> dept = buildDept();

		String deptName = "IT";

		when(departmentJpaRepository.findByDepartmentName(deptName)).thenReturn(department);
		when(departmentUtil.tranformResponse(department)).thenReturn(dept);
		List<DepartMent> response = departmentService.findByDeptName(deptName);
		assertThat(response).isNotEmpty();

	}

	private DepartMent buildDepartMent() {
		DepartMent departMent = new DepartMent();
		departMent.setDeptid(1l);
		departMent.setDeptName("IT");
		return departMent;
	}

	private List<DepartMent> buildDept() {
		List<DepartMent> departMents = new ArrayList<>();
		DepartMent departMent = new DepartMent();
		departMent.setDeptid(1l);
		departMent.setDeptName("IT");
		departMents.add(departMent);
		return departMents;
	}

	private List<Department> buildDepartmentList() {
		List<Department> departments = new ArrayList<>();
		departments.add(buildDepartment());
		return departments;
	}

	private Department buildDepartment() {
		Department department = new Department();
		department.setDepartmentId(1);
		department.setDepartmentName("IT");
		department.setEmployees(setEmployees());
		return department;
	}

	private List<Employee> setEmployees() {
		List<Employee> empList = new ArrayList<>();
		Employee employee = new Employee();
		employee.setEmployeeName("ankamma pallapu");
		employee.setEmployeeNumber(12l);
		employee.setSalary(new BigDecimal(1233444));
		empList.add(employee);
		return empList;
	}

	private DepartmentRequest buildDepartmentRequest() {
		DepartmentRequest departmentRequest = new DepartmentRequest();
		departmentRequest.setDeptid(1l);
		departmentRequest.setDeptName("IT");
		departmentRequest.setEmployee(setEmployee());
		return departmentRequest;
	}

	private List<EmployeeRequest> setEmployee() {
		List<EmployeeRequest> employeeRequests = new ArrayList<>();
		EmployeeRequest employeeRequest = new EmployeeRequest();
		employeeRequest.setEmpId(12l);
		employeeRequest.setEmpName("Ankamma pallapu");
		employeeRequest.setSalaray(123l);
		employeeRequests.add(employeeRequest);
		return employeeRequests;
	}

}
