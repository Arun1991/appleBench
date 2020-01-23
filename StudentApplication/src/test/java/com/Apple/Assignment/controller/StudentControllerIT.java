package com.Apple.Assignment.controller;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.Apple.Assignment.model.Student;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class StudentControllerIT {
	
	@Autowired
	TestRestTemplate restTemplate;
	
	@Test
	public void fetchStudent_test() throws Exception {
		List response = this.restTemplate.getForObject("/Student/findAllStudent", List.class);
		assertTrue(response.size()>0);
		//System.out.println(response);
	}
	
	@Test
	public void createStudent_test(){
		Student stu = new Student("Suresh", "c", 44, "Male");
		HttpHeaders headers = new HttpHeaders();
		headers.set("content-type", "application/json");
		HttpEntity<Student> request = new HttpEntity<>(stu,headers);
		//using postForObject()
		String StringResponse = this.restTemplate.postForObject("/Student/createStudent", request,String.class );
		
		System.out.println(StringResponse);

		//using postForEntity()
		ResponseEntity<String> postForEntity = this.restTemplate.postForEntity("/Student/createStudent", request,String.class);
		assertTrue(postForEntity.getStatusCodeValue()==200);
	}
	
	@Test
	public void deleteStudent_test(){
		//this.restTemplate.delete("Student/deleteById/{id}");
	}

}
