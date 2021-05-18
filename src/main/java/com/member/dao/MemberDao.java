package com.member.dao;

import com.member.entity.Member;
import com.member.exception.RegisterMemberException;
/*
 * MemberDao interface
 */

public interface MemberDao {
	/*
	 * save
	 */
	 Member saveMemberData(Member member) throws RegisterMemberException;
      /*
       * get
       */
	 Member getMember(String memberid) throws RegisterMemberException;
	 /*
	  * update
	  */

	 Member updateMember(Member member) throws RegisterMemberException;
}
