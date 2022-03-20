package com.example.firstms.controller;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.firstms.model.Person;
import com.example.firstms.repository.PersonRepo;
@WebMvcTest(PersonController.class)
class PersonControllerTest {

	@Autowired
	private MockMvc mockMvc; 
	@MockBean
	private PersonRepo personRepo;

	@Test
	void testListPersons_emptyResponse() throws Exception {
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/persons");
        mockMvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(personRepo, Mockito.times(1)).findAll();
	}

	@Test
	void testListPersons_WithContent() throws Exception {
		Person james=new Person();
		james.setId(1);
		james.setName("James Bond");
		james.setAge(50L);
		james.setNickName("Bond");
		ArrayList<Person> personlist=new ArrayList<>();
		personlist.add(james);
		
		Mockito.when(personRepo.findAll()).thenReturn(personlist);
		
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/persons");
		mockMvc.perform(request)
        .andDo(MockMvcResultHandlers.print())
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.content().contentType("application/json"))
        .andExpect(MockMvcResultMatchers.content().json("[{\"id\":1,\"name\":\"James Bond\",\"age\":50,\"nickName\":\"Bond\"}]"))
;
		Mockito.verify(personRepo, Mockito.times(1)).findAll();
	}
}
