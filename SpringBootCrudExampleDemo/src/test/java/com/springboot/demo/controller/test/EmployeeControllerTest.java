package com.springboot.demo.controller.test;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.demo.EmployeeService.EmployeeService;
import com.springboot.demo.controller.EmployeeController;
import com.springboot.demo.model.Employee;

@AutoConfigureMockMvc(addFilters = false)
@WebMvcTest(controllers = EmployeeController.class,excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class EmployeeControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper mapper;

	@MockBean
	EmployeeService employeeService;

	Optional<Employee> e1=Optional.ofNullable(new Employee("abc",1L,"address",123456L));
	Employee e2=new Employee("abc",2L,"address",123456L);
	Employee e3=new Employee("abc",3L,"address",123456L);

	private WebApplicationContext context;

	@Test
	public void findEmployeeByIdTest() throws Exception
	{
		Mockito.when(employeeService.findById(1L)).thenReturn(e1);
		mockMvc.perform(MockMvcRequestBuilders
				.get("/employee/1")
				.contentType(MediaType.APPLICATION_JSON))
		.andExpect((ResultMatcher) status().isFound())
		//.andExpect(jsonPath("$",Matchers.hasSize(1)))
		.andExpect(jsonPath("$.name",Matchers.is("abc")));
	}

}
