package com.member.service;

import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.member.dao.MemberDaoImpl;
import com.member.dto.MemberDto;
import com.member.entity.Member;
import com.member.exception.RegisterMemberException;
/*
 * Member Service
 */

@Service
public class MemberServiceImpl implements MemberService {
	Logger logger = LogManager.getLogger(MemberServiceImpl.class);
	@Autowired
	private MemberDaoImpl memberDao;

	/*
	 * save
	 */
	public MemberDto saveMember(MemberDto memberDto) throws RegisterMemberException {
		MemberDto response = new MemberDto();
		logger.info("Member Details......");

		try {
			Random random = new Random();
			String memberid = "R-" + random.nextInt(1000) + "." + random.nextInt(1000);
			memberDto.setMemberid(memberid);
			Member member = new Member();
			member = new DozerBeanMapper().map(memberDto, Member.class);
			member = memberDao.saveMemberData(member);
			if (null != member) {
				response = new DozerBeanMapper().map(member, MemberDto.class);
				response.setMemberid(memberid);
				response.setStatus("SUCCESS");
			} else {
				response.setStatus("FAILURE");
			}
		} catch (Exception e) {
			logger.error("Exception in classnme methodname");
			throw new RegisterMemberException("1000", "An error occurred");
		}
		return response;
	}


	/*
	 * get
	 */
	public MemberDto getMemberData(String memberid) throws RegisterMemberException {
		logger.info("Get memeber details...");
		MemberDto memberDto = null;
		Member member = null;
		try {
			member = memberDao.getMember(memberid);
			memberDto = new MemberDto();
			memberDto = new DozerBeanMapper().map(member, MemberDto.class);
			memberDto.setStatus("SUCCESS");
		} catch (Exception e) {
			memberDto.setStatus("FAILURE");
			logger.error(e);
			throw new RegisterMemberException("1000", "An error occurred");
		}
		return memberDto;
	}

	/*
	 * update
	 */
	public MemberDto updateMemberData(Member member) throws RegisterMemberException {
		logger.info("update details.......");
		MemberDto memberDto = null;
		try {
			member = memberDao.updateMember(member);
			memberDto = new MemberDto();
			memberDto = new DozerBeanMapper().map(member, MemberDto.class);
			memberDto.setStatus("SUCCESS");
		} catch (Exception e) {
			memberDto.setStatus("FAILURE");
			logger.error(e);
			throw new RegisterMemberException("1000", "An error occurred");
		}
		return memberDto;
	}

}
