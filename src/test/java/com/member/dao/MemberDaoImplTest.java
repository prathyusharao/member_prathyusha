package com.member.dao;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import com.member.entity.Member;
import com.member.exception.RegisterMemberException;
import com.member.repo.MemberRepository;

@RunWith(SpringRunner.class)
public class MemberDaoImplTest {
	@MockBean
	MemberRepository memberRepository;
	@MockBean
    MongoTemplate mongoTemplate;
	@Autowired
	MemberDao memberDao;

	@Configuration
	static class MemberDaoConfig {
		@Bean
		public MemberDao memberDao() {
			return new MemberDaoImpl();
		}
		
	}
	@Test
	public void testSaveMember() throws RegisterMemberException {
		Member member = new Member();
		member.setMembername("prathyusha");
		member.setCountry("INDIA");
		when(memberRepository.save(member)).thenReturn(member);
		assertNotNull(memberDao.saveMemberData(member));
	}
	@Test
	public void testGetMember() throws RegisterMemberException {
		when(memberRepository.findMemberBymemberid(new Member().getMemberid())).thenReturn(new Member());
		assertNotNull(memberDao.getMember(new Member().getMemberid()));
	}
	@Test
	public void testUpdateMember() throws RegisterMemberException {
		Query query = new Query();
		//Member member=new Member();
		//member.setMembername("prathyusha");
		query.addCriteria(Criteria.where("member.getmMemberid()").is("R-456.986"));
		Update update = new Update();
		update.set("membername","prathyusha");
		Member member = mongoTemplate.findAndModify(query, update, Member.class);
		when( mongoTemplate.findAndModify(query, update, Member.class)).thenReturn(member);
		assertNotNull(memberDao.updateMember(member));
	}
	
}
