/*******************************************************
 * copy right (c) ankamma ,All rights reserved
 * 
 * 
 * Application name :Springboot-Jpa
 * 
 * This application is used to managed the micro service development
 * 
 * 
 * File name:DepartmentJpaRepository.java
 * 
 * File created Date:13 Sep, 2018
 * 
 ***********************************************************/
package com.ankamma.application.respository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.ankamma.application.persistence.model.Department;
import com.ankamma.application.persistence.model.Employee;

/**
 * The Interface DepartmentJpaRepository.
 */
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class DepartmentJpaRepositoryTest {

	
	@Autowired
	private DepartmentJpaRepository departmentJpaRepository;

	@Test
	public void findByDepartName() {

		/*Department dept = buildDepartment();

		entityManager.persist(dept);
		entityManager.flush();*/
		List<Department> listDept = departmentJpaRepository.findByDepartmentName("IT");
		System.out.println("listDept"+listDept.size());
		assertThat(listDept).isNotNull();

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

}
