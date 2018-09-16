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

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.ankamma.application.rest.model.DepartMent;
import com.ankamma.application.rest.model.DepartmentRequest;
import com.ankamma.application.rest.model.DepartmentResponse;
import com.ankamma.application.rest.model.EmployeeRequest;
import com.ankamma.application.service.Impl.DepartmentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

@RunWith(SpringRunner.class)
@WebMvcTest(value = DepartmentControllerImpl.class, secure = false)
public class DepartmentControllerImplTest {

	@Autowired
	private MockMvc mockMvc;
	/** The department service. */
	@MockBean
	private DepartmentServiceImpl departmentServiceImpl;

	private static final String URI = "http://localhost:8080/depart";

	@Test
	public void createDepartMentTest() throws Exception {
		DepartmentRequest departmentRequest = buildDepartmentRequest();
		DepartmentResponse departmentResponse = buildDepartmentResponse();
		when(this.departmentServiceImpl.createDepartMent(departmentRequest)).thenReturn(departmentResponse);

		mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON)
				.content(getJson(departmentRequest)).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].deptId").value(1));

	}

	@Test
	public void testGetDept() throws Exception {
		List<DepartMent> response = buildDeptList();
		when(departmentServiceImpl.getAllDepartMent()).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllDepts").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].deptId").value(1))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$[0].deptName").value("IT"));

	}

	@Test
	public void testGetDeptById() throws Exception {
		DepartMent response = buildDept();
		Long deptId = 1l;
		when(departmentServiceImpl.getDepartMentById(deptId)).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.get("/getAllDepts/1").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.deptId").value(1))
				.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.deptName").value("IT"));

	}

	@Test
	public void updateDepartMentTest() throws Exception {
		DepartmentRequest departmentRequest = buildDepartmentRequest();

		Mockito.doNothing().when(this.departmentServiceImpl).updateDepartMentById(1l, departmentRequest);

		mockMvc.perform(MockMvcRequestBuilders.put("/dept/1").accept(MediaType.APPLICATION_JSON)
				.content(getJson(departmentRequest)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void deleteDepartMentTest() throws Exception {
		DepartmentRequest departmentRequest = buildDepartmentRequest();

		Mockito.doNothing().when(this.departmentServiceImpl).deleteDept(1l);

		mockMvc.perform(MockMvcRequestBuilders.delete("/dept/1").accept(MediaType.APPLICATION_JSON)
				.content(getJson(departmentRequest)).contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());

	}

	@Test
	public void testFindDeptName() throws Exception {
		List<DepartMent> response = buildDeptList();
		String deptName = "IT";
		when(departmentServiceImpl.findByDeptName(deptName)).thenReturn(response);
		mockMvc.perform(MockMvcRequestBuilders.get("/findByDeptName").param("depName", "IT")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].deptId").value(1)).andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$[0].deptName").value("IT"));

	}

	private DepartMent buildDept() {
		DepartMent departMent = new DepartMent();
		departMent.setDeptid(1l);
		departMent.setDeptName("IT");
		return departMent;
	}

	private List<DepartMent> buildDeptList() {
		List<DepartMent> list = new ArrayList<>();
		DepartMent departMent = new DepartMent();
		departMent.setDeptid(1l);
		departMent.setDeptName("IT");
		list.add(departMent);

		return list;
	}

	private byte[] getJson(Object departmentRequest) throws JsonProcessingException {
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String json = ow.writeValueAsString(departmentRequest);
		return json.getBytes();
	}

	private DepartmentResponse buildDepartmentResponse() {
		DepartmentResponse departmentResponse = new DepartmentResponse();
		departmentResponse.setDepId(1l);
		return departmentResponse;
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
