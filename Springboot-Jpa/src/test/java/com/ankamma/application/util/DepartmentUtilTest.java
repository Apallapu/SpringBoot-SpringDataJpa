/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartmentUtil.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ankamma.application.persistence.model.Department;
import com.ankamma.application.persistence.model.Employee;
import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.EmployeeRequest;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DepartmentUtil.class)
public class DepartmentUtilTest {

	@Autowired
	DepartmentUtil departmentUtil;

	@Test
	public void testtranformEntity() {
		DepartmentRequest departmentRequest = buildDepartmentRequest();
		Department department = departmentUtil.tranformEntity(departmentRequest);
		assertThat(department.getDepartmentName()).isEqualTo("IT");
	}

	@Test
	public void testtranformResponse() {
		List<Department> department = buildDepartmentList();

		List<DepartMent> departmentResponse = departmentUtil.tranformResponse(department);
		assertThat(departmentResponse).isNotNull();
	}

	@Test
	public void testtranformResponseById() {
		Department department = buildDepartment();
		DepartMent departmentResponse = departmentUtil.tranformResponseById(department);
		assertThat(departmentResponse).isNotNull();
	}

	@Test
	public void testupdateDepartMentByIdMapper() {
		Department department = buildDepartment();
		DepartmentRequest departmentRequest = buildDepartmentRequest();
		departmentUtil.updateDepartMentByIdMapper(department, departmentRequest);

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
