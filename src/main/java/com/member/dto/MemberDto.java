package com.member.dto;

import java.util.Date;

/*
 * MemberDto
 */

public class MemberDto {
	/*
	 * member id
	 */
	protected String memberid;
	/*
	 * member name
	 */
	protected String membername;
	/*
	 * address
	 */
	protected String address;
	/*
	 * state
	 */
	protected String state;
	/*
	 * country
	 */
	protected String country;
	/*
	 * email address
	 */
	protected String emailaddress;
	/*
	 * date of birth
	 */
	protected Date dob;
	/*
	 * pan
	 */
	protected String pan;
     /*
      * contact no
      */
	protected String contactno;
	 /*
     * dependent1name 
     */
	protected String dependent1name;
	/*
     * dependent1dob 
     */
	protected Date dependent1dob;
	/*
     * dependent2name
     */
	protected String dependent2name;
	/*
     * dependent2dob
     */
	protected String dependent2dob;
	/*
	 * status
	 */
	protected String status;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMemberid() {
		return memberid;
	}
	public void setMemberid(String memberid) {
		this.memberid = memberid;
	}
	public String getMembername() {
		return membername;
	}
	public void setMembername(String membername) {
		this.membername = membername;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getEmailaddress() {
		return emailaddress;
	}
	public void setEmailaddress(String emailaddress) {
		this.emailaddress = emailaddress;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public String getContactno() {
		return contactno;
	}
	public void setContactno(String contactno) {
		this.contactno = contactno;
	}
	public String getDependent1name() {
		return dependent1name;
	}
	public void setDependent1name(String dependent1name) {
		this.dependent1name = dependent1name;
	}
	public Date getDependent1dob() {
		return dependent1dob;
	}
	public void setDependent1dob(Date dependent1dob) {
		this.dependent1dob = dependent1dob;
	}
	public String getDependent2name() {
		return dependent2name;
	}
	public void setDependent2name(String dependent2name) {
		this.dependent2name = dependent2name;
	}
	public String getDependent2dob() {
		return dependent2dob;
	}
	public void setDependent2dob(String dependent2dob) {
		this.dependent2dob = dependent2dob;
	}
	@Override
	public String toString() {
		return "MemberDto [memberid=" + memberid + ", membername=" + membername + ", address=" + address + ", state="
				+ state + ", country=" + country + ", emailaddress=" + emailaddress + ", dob=" + dob + ", pan=" + pan
				+ ", contactno=" + contactno + ", dependent1name=" + dependent1name + ", dependent1dob=" + dependent1dob
				+ ", dependent2name=" + dependent2name + ", dependent2dob=" + dependent2dob + ", status=" + status
				+ "]";
	}
	
	
	
	
	
	
		
}
