package com.demo.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
//import static org.hamcrest.core.Is.isA;
//import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = App.class)
@SpringBootTest
//@SpringBootTest
//@WebMvcTest(value=CustomerOperations.class, secure=false)
public class CustomerTest {
	
	private MockMvc mockMvc;
	
	@Autowired
    private WebApplicationContext wac;

	@Before
	public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();

	}
	
	//@Autowired
	
	
/*	@InjectMocks
	private CustomerOperations customerOperations;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerOperations).build();
	}*/

	/*@Mock
	private CustomerServiceImpl service;*/
	
	/*@Test
	public void verifyToDoById() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/todo/3").accept(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$.id").exists())
		.andExpect(jsonPath("$.text").exists())
		.andExpect(jsonPath("$.completed").exists())
		.andExpect(jsonPath("$.id").value(3))
		.andExpect(jsonPath("$.text").value("Build the artifacts"))
		.andExpect(jsonPath("$.completed").value(false))
		.andDo(print());
	}*/
	
	@Test
	public void viewCustomerTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/view/205")
		       // .contentType(MediaType.APPLICATION_JSON)
		        /*.content("{\"text\" : \"New ToDo Sample\", \"completed\" : \"false\" }")*/
/*		        customerName, long contactNumber, String emailId, String dateOfBirth,String url
*/				.accept(MediaType.APPLICATION_JSON))
				/*.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customer.contactNumber").exists())
				.andExpect(jsonPath("$.customer.emailId").exists())
				.andExpect(jsonPath("$.customer.dateOfBirth").exists())
				.andExpect(jsonPath("$.url").exists())*/
				.andExpect(jsonPath("$.customerName").value("Sahyyali"))
				.andExpect(jsonPath("$.contactNumber").value(986968043))
				.andExpect(jsonPath("$.emailId").value("abc@b2.com"))
				.andExpect(jsonPath("$.dateOfBirth").value("2/10/1996"))
				.andExpect(jsonPath("$.url").value("abc.xyz2.jpg"))
/*				.andReturn().getResponse().getContentAsString()
*/				.andDo(print());

	}
	
	@Test
	public void verifySaveToDo() throws Exception {
//		long num=88795210;
		mockMvc.perform(MockMvcRequestBuilders.post("/customer/add")
        .contentType(MediaType.APPLICATION_JSON)
        .content("{\"customerName\" : \"SayaliMartal\", \"contactNumber\" : \"8894582\", \"emailId\" : \"s@m.in\", \"dateOfBirth\" : \"20/10/1998\", \"url\" : \"a@b.com\" }")
		.accept(MediaType.APPLICATION_JSON))
		/*.andExpect(jsonPath("$.customerId").exists())*/
		.andExpect(jsonPath("$.customerName").exists())
		.andExpect(jsonPath("$.contactNumber").exists())
		.andExpect(jsonPath("$.emailId").exists())
		.andExpect(jsonPath("$.dateOfBirth").exists())
		.andExpect(jsonPath("$.url").exists())
		.andExpect(jsonPath("$.customerName").value("SayaliMartal"))
		.andExpect(jsonPath("$.contactNumber").value(8894582))
		.andExpect(jsonPath("$.emailId").value("s@m.in"))
		.andExpect(jsonPath("$.dateOfBirth").value("20/10/1998"))
		.andExpect(jsonPath("$.url").value("a@b.com"))
		.andDo(print());
	}


}
