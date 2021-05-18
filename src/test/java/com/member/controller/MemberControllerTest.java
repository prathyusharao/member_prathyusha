package com.member.controller;

import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.member.dto.MemberDto;
import com.member.service.MemberServiceImpl;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
public class MemberControllerTest {

	@MockBean
	MemberServiceImpl memberServiceImpl;

	@Autowired
	WebApplicationContext context;
	@Autowired
	MockMvc mockMvc;

	/*
	 * @Before public void setUp() { mockMvc =
	 * MockMvcBuilders.webAppContextSetup(context).apply(springSecurity()).build();
	 * }
	 */

	@WithMockUser("/prathyusha")
	@Test
	public void testRegisterMember() throws Exception {
		String memberJson = "{\"membername\":\"test\"}";

		when(memberServiceImpl.saveMember(new MemberDto())).thenReturn(new MemberDto());
		this.mockMvc.perform(post("/member/register").contentType(MediaType.APPLICATION_JSON).content(memberJson))
				.andExpect(status().isOk());
	}

	@WithMockUser("/prathyusha")
	@Test
	public void testUpdateMember() throws Exception {
		String memberJson = "{\"pan\":\"DTVP567\"}";

		when(memberServiceImpl.saveMember(new MemberDto())).thenReturn(new MemberDto());
		this.mockMvc.perform(put("/member/updateMember").contentType(MediaType.APPLICATION_JSON).content(memberJson))
				.andExpect(status().isOk());

	}
	@WithMockUser("/prathyusha")
	@Test
	public void testGetMember() throws Exception {
		when(memberServiceImpl.saveMember(new MemberDto())).thenReturn(new MemberDto());
		this.mockMvc.perform(get("/member/getMember/R-456.123").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andReturn();

	}

}
