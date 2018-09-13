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

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.ankamma.application.persistence.model.Department;
import com.ankamma.application.persistence.model.Employee;
import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.EmployeeRequest;

// TODO: Auto-generated Javadoc
/**
 * The Class DepartmentUtil.
 */
@Component
public class DepartmentUtil {

	/**
	 * Tranform entity.
	 *
	 * @param departmentRequest the department request
	 * @return the department
	 */
	public Department tranformEntity(DepartmentRequest departmentRequest) {
		Department department = new Department();
		department.setDepartmentName(departmentRequest.getDeptName());
		department.setEmployees(setemployees(departmentRequest, department));
		return department;
	}

	/**
	 * Setemployees.
	 *
	 * @param departmentRequest the department request
	 * @param department the department
	 * @return the list
	 */
	private List<Employee> setemployees(DepartmentRequest departmentRequest, Department department) {
		List<Employee> employees = new ArrayList<>();

		departmentRequest.getEmployee().stream().forEach(emp -> employees.add(setEmp(emp, department)));
		return employees;
	}

	/**
	 * Sets the emp.
	 *
	 * @param emp the emp
	 * @param department the department
	 * @return the employee
	 */
	private Employee setEmp(EmployeeRequest emp, Department department) {
		Employee employee = new Employee();
		employee.setDepartment(department);
		employee.setEmployeeName(emp.getEmpName());
		employee.setSalary(new BigDecimal(emp.getSalaray()));

		return employee;
	}

	/**
	 * Tranform response.
	 *
	 * @param department the department
	 * @return the list
	 */
	public List<DepartMent> tranformResponse(List<Department> department) {
		List<DepartMent> deptList = new ArrayList<>();

		department.stream().forEach(dept -> {
			DepartMent departMent = new DepartMent();
			departMent.setDeptid(dept.getDepartmentId());
			departMent.setDeptName(dept.getDepartmentName());
			departMent.setEmployee(geyEmployee(dept.getEmployees()));
			deptList.add(departMent);
		});

		return deptList;
	}

	/**
	 * Gey employee.
	 *
	 * @param employees the employees
	 * @return the list
	 */
	private List<com.ankamma.application.rest.model.Employee> geyEmployee(List<Employee> employees) {
		List<com.ankamma.application.rest.model.Employee> empList = new ArrayList<>();

		employees.stream().forEach(emp -> {
			com.ankamma.application.rest.model.Employee employee = new com.ankamma.application.rest.model.Employee();
			employee.setEmpId(emp.getEmployeeNumber());
			employee.setEmpName(emp.getEmployeeName());
			employee.setSalaray((emp.getSalary().longValue()));
			empList.add(employee);

		});
		return empList;
	}

	/**
	 * Tranform response by id.
	 *
	 * @param department the department
	 * @return the depart ment
	 */
	public DepartMent tranformResponseById(Department department) {
		DepartMent departMent = new DepartMent();
		departMent.setDeptid(department.getDepartmentId());
		departMent.setDeptName(department.getDepartmentName());
		departMent.setEmployee(geyEmployee(department.getEmployees()));
		return departMent;
	}

	/**
	 * Update depart ment by id mapper.
	 *
	 * @param department the department
	 * @param departmentRequest the department request
	 */
	public void updateDepartMentByIdMapper(Department department, DepartmentRequest departmentRequest) {
		
		department.setDepartmentName(departmentRequest.getDeptName());
	}

}
