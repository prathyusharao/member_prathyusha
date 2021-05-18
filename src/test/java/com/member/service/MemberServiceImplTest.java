
package com.member.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.dozer.DozerBeanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import com.member.dao.MemberDaoImpl;
import com.member.dto.MemberDto;
import com.member.entity.Member;
import com.member.exception.RegisterMemberException;

@RunWith(SpringRunner.class)
public class MemberServiceImplTest {

	@Autowired
	MemberService memberService;

	@MockBean
	MemberDaoImpl memberDaoImpl;

	@Configuration
	static class MemberServiceConfig {
		@Bean
		public MemberService memberService() {
			return new MemberServiceImpl();
		}
		
	}

	@Test
	public void testSaveMember() throws RegisterMemberException {
		Member member = new Member();
		member.setMembername("prathyusha");
		member.setCountry("INDIA");
		MemberDto memberDto = new DozerBeanMapper().map(member, MemberDto.class);
		when(memberDaoImpl.saveMemberData(member)).thenReturn(member);
		assertNotNull(memberService.saveMember(memberDto));
	}

	@Test
	public void testUpdateMember() throws RegisterMemberException {
		Member member = new Member();
		member.setMembername("prathyusha");
		member.setMemberid("R-456.654");
		when(memberDaoImpl.updateMember(member)).thenReturn(member);
		assertNotNull(memberService.updateMemberData(member));
	}

	@Test
	public void testGetMember() throws RegisterMemberException {
		when(memberDaoImpl.getMember(new Member().getMemberid())).thenReturn(new Member());
		assertNotNull(memberService.getMemberData(new Member().getMemberid()));
	}

}
