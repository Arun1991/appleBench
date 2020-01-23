package com.Apple.Assignment.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.Apple.Assignment.model.Student;
import com.Apple.Assignment.service.StudentService;

@WebMvcTest(StudentController.class)
@RunWith(SpringRunner.class)
public class StudentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	StudentService studentService;
	
	@Test
	public void createStudent_test() throws Exception {
		when(studentService.createStudent(new Student("Arun","A",25,"M"))).thenReturn(new Student("Arun","A",25,"M"));
		
		RequestBuilder request = MockMvcRequestBuilders.post("/Student/createStudent")
							  .accept(MediaType.APPLICATION_JSON)
							  .contentType(MediaType.APPLICATION_JSON)
							  .content("{\"name\":\"Arun\",\"grade\":\"A\",\"age\":25,\"gender\":\"M\"}");
	
		MvcResult result = mockMvc.perform(request)
			   .andExpect(status().isOk())
			  // .andExpect(content().json("{name:Arun,grade:A,age:25,gender:M}",false))
			   .andReturn();
							  
		
	}
	
	@Test
	public void fetchStudents_test() throws Exception{
		
		when(studentService.findAllStud())
							.thenReturn(Arrays.asList(new Student("Arun","A",25,"M")));
		
		RequestBuilder request = MockMvcRequestBuilders.get("/Student/findAllStudent")
								.accept(MediaType.APPLICATION_JSON);
		MvcResult result = mockMvc.perform(request)
									.andExpect(status().isOk())
									.andExpect(content().json("[{name:Arun,grade:A,age:25,gender:M}]",false))
									.andReturn();
	}
	
	@Test
	public void updateStudent_test()throws Exception{
		when(studentService.updateStudent(new Student("Arun","A+",25,"M")))
							.thenReturn(true);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.put("/Student/updateStudent")
							  .accept(MediaType.APPLICATION_JSON)
							  .contentType(MediaType.APPLICATION_JSON)
							  .content("{\"name\":\"Arun\",\"grade\":\"A+\",\"age\":25,\"gender\":\"M\"}");
		
		MvcResult result = mockMvc.perform(request)
				.andExpect(status().is(200))
				.andReturn();
	}
	
	@Test
	public void getByAge_test() throws Exception{
		when(studentService.searchStudentByAge(20))
				.thenReturn(Arrays.asList(new Student("Arun","A+",20,"M")));
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/Student/getByAge/20")
							.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{name:Arun,grade:A+,age:20,gender:M}]",false))
				.andReturn();
	}

	@Test
	public void getByGrade_test() throws Exception{
		when(studentService.searchStudentByGrade("A+"))
				.thenReturn(Arrays.asList(new Student("Arun","A+",20,"M")));
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/Student/getByGrade/A+")
							.accept(MediaType.APPLICATION_JSON);
		
		mockMvc.perform(request)
				.andExpect(status().isOk())
				.andExpect(content().json("[{name:Arun,grade:A+,age:20,gender:M}]",false))
				.andReturn();
	}
}


















