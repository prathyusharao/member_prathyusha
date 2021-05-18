package com.member.service;

import com.member.dto.MemberDto;
import com.member.entity.Member;
import com.member.exception.RegisterMemberException;
/*
 *MemberService interface
 */
public interface MemberService {
	/*
	 * save
	 */
	MemberDto saveMember(MemberDto memberDto) throws RegisterMemberException;
	/*
	 * get
	 */
	 MemberDto getMemberData(String memberid) throws RegisterMemberException;
	/*
	 * update
	 */
	 MemberDto updateMemberData(Member member) throws RegisterMemberException;
	
}
