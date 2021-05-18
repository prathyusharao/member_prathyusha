package com.member.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import com.member.entity.Member;
import com.member.exception.RegisterMemberException;
import com.member.repo.MemberRepository;
/*
 * Dao
 */
@Component

public class MemberDaoImpl implements MemberDao {
	/*
	 * log statements
	 */
	
	Logger logger = LogManager.getLogger(MemberDaoImpl.class);

	@Autowired
	private MemberRepository memberRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	/*
	 * saveMember
	 */
	public Member saveMemberData(Member member) throws RegisterMemberException {
		logger.info("Member details... ");
		try {
			member = memberRepository.save(member);
		} catch (Exception e) {
			logger.error(e);
			throw new RegisterMemberException("100","Register Member");
		}
		return member;
	}
     /*
      * Retrive
      */
	public Member getMember(String memberid) throws RegisterMemberException {
		logger.info("Get Member details... ");
		Member member = null;
		try {
			member = memberRepository.findMemberBymemberid(memberid);
		} catch (Exception e) {
			logger.error(e);
			throw new RegisterMemberException("200","Retrive Member Details");
		}
		return member;
	}
	/*
	 * update
	 */

	public Member updateMember(Member member) throws RegisterMemberException {
		logger.info(" Update Member... ");
		Member updatedMember = null;
		try {
			Query query = new Query();
			query.addCriteria(Criteria.where("memberid").is(member.getMemberid()));
			Update update = new Update();
			update.set("membername", member.getMembername());
			update.set("address", member.getAddress());
			update.set("pan", member.getPan());
			update.set("emailaddress", member.getEmailaddress());
			update.set("dependent1name", member.getDependent1name());
			update.set("dependent2name", member.getDependent2name());
			update.set("dependent1dob", member.getDependent1dob());
			update.set("dependent2dob", member.getDependent2dob());
			updatedMember = mongoTemplate.findAndModify(query, update, Member.class);
		} catch (Exception e) {
			logger.error(e);
			throw new RegisterMemberException("200","Retrive Member Details");
		}
		return updatedMember;
	}

}
