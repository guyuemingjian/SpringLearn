package com.hu.LearnSpringBoot.web;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class HelloControllerTest {

	private MockMvc mockMvc;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void test1() throws Exception {
		ResultActions resule = mockMvc.perform(MockMvcRequestBuilders.get("/hello?param=1&param2=2"));
		resule.andDo(print());
	}

	@Test
	public void test2() throws Exception {
		ResultActions resule = mockMvc.perform(MockMvcRequestBuilders.get("/getUser"));
		System.out.println(resule.andReturn().getResponse().getContentAsString());

		resule = mockMvc.perform(MockMvcRequestBuilders.post("/getUser"));
		System.out.println(resule.andReturn().getResponse().getContentAsString());
	}

	@Test
	public void test3() throws Exception {

		ResultActions resule = mockMvc.perform(MockMvcRequestBuilders.post("/getUser2").param("param", "小明")
				.param("param2", "12").param("param3", "Aaaa1111"));
//		ResultActions resule = mockMvc.perform(MockMvcRequestBuilders.post("/getUser2").param("name", "小明")
//				.param("age", "12").param("pasw", "Aaaa1111"));
		System.out.println(resule.andReturn().getResponse().getContentAsString());
	}

	@Test
	public void test4() throws Exception {
		ResultActions resule = mockMvc.perform(MockMvcRequestBuilders.post("/getUser3").param("name", "小明")
				.param("age", "12").param("pasw", "Aaaa1111"));
		System.out.println(resule.andReturn().getResponse().getContentAsString());
	}
	
	@Test
	public void test5() throws Exception {
		ResultActions resule = mockMvc.perform(MockMvcRequestBuilders.post("/getUser4/小明/12/Aaaa1111"));
		System.out.println(resule.andReturn().getResponse().getContentAsString());
	}
}
