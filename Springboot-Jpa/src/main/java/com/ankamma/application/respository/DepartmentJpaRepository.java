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

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankamma.application.persistence.model.Department;

/**
 * The Interface DepartmentJpaRepository.
 */
@Repository
public interface DepartmentJpaRepository extends JpaRepository<Department, Long> {

	List<Department> findByDepartmentName(String deptName);

}
