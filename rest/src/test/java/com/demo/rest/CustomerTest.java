package com.demo.rest;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

//import static org.hamcrest.core.Is.isA;
import static org.hamcrest.Matchers.*;
import com.demo.rest.controller.CustomerOperations;
import com.demo.rest.service.CustomerServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
//@WebMvcTest(value=CustomerOperations.class, secure=false)
public class CustomerTest {
	
	//@Autowired
	private MockMvc mockMvc;
	
	@InjectMocks
	private CustomerOperations customerOperations;
	
	@Before
	public void setUp() throws Exception {
		mockMvc = MockMvcBuilders.standaloneSetup(customerOperations).build();
	}

	@Mock
	private CustomerServiceImpl service;
	
	@Test
	public void viewCustomerTest() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.get("/customer/view/205")
		        .contentType(MediaType.APPLICATION_JSON)
		        /*.content("{\"text\" : \"New ToDo Sample\", \"completed\" : \"false\" }")*/
/*		        customerName, long contactNumber, String emailId, String dateOfBirth,String url
*/				.accept(MediaType.APPLICATION_JSON))
				/*.andExpect(jsonPath("$.customerName").exists())
				.andExpect(jsonPath("$.customer.contactNumber").exists())
				.andExpect(jsonPath("$.customer.emailId").exists())
				.andExpect(jsonPath("$.customer.dateOfBirth").exists())
				.andExpect(jsonPath("$.url").exists())*/
				.andExpect(jsonPath("$[0].customerName",is("Sahyyali"))
				.andExpect(jsonPath("$[1].contactNumber",is(986968043)).;
				/*.andExpect(jsonPath("$[2].emailId").value("abc@b2.com"))
				.andExpect(jsonPath("$.dateOfBirth").value("2/10/1996"))
				.andExpect(jsonPath("$.url").value("abc.xyz2.jpg"))*/
/*				.andReturn().getResponse().getContentAsString()
*/				/*.andDo(print());*/

	}

}
