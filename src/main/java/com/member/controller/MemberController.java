
package com.member.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.member.dto.MemberDto;
import com.member.entity.Member;
import com.member.exception.RegisterMemberException;
import com.member.service.MemberServiceImpl;

/*
 * This is Member controller
 */
@RestController
@RequestMapping("/member")
@CrossOrigin("http://localhost:4200")
public class MemberController {
	public  Logger logger = LogManager.getLogger(MemberController.class);
	@Autowired
	private MemberServiceImpl memberService;

	/*
	 * save member
	 * 
	 */

	@PostMapping(path = "/register", consumes = "application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public ResponseEntity<MemberDto> saveId(@RequestBody MemberDto memberDto) throws RegisterMemberException{
		logger.info("regitsering Member details... ");
		MemberDto newMember = null;
		try {
			newMember = memberService.saveMember(memberDto);
			return new ResponseEntity<>(newMember, HttpStatus.OK);

		} catch (RegisterMemberException e) {
			logger.error("Failed to register", e.getMessage());
			throw new RegisterMemberException("500","InternalServerError");
		}
	}

	/*
	 * member retrival
	 * 
	 */

	@GetMapping("/getMember/{memberid}")
	public ResponseEntity<MemberDto> getMember(@PathVariable String memberid) throws RegisterMemberException {
		logger.info("retriving Member details... ");
		MemberDto memberDto = null;
		try {
			memberDto = memberService.getMemberData(memberid);
			return new ResponseEntity<>(memberDto, HttpStatus.OK);
		} catch (Exception e) {
			logger.error("Failed to retrive", e.getMessage());
			throw new RegisterMemberException("500","InternalServerError");
		}

	}
	/*
	 * update member
	 * 
	 */

	@PutMapping(path="/updateMember",consumes ="application/json;charset=UTF-8", produces = "application/json;charset=UTF-8")
	public ResponseEntity<MemberDto> updateData(@RequestBody Member member) throws RegisterMemberException  {
		logger.info("updating Member details... ");
		MemberDto memberDto = null;
		try {
			memberDto = memberService.updateMemberData(member);
			return new ResponseEntity<>(memberDto, HttpStatus.OK);
		} catch (RegisterMemberException e) {
			logger.error("Failed to update....", e.getMessage());
			throw new RegisterMemberException("500","InternalServerError");
		}
	}

}
