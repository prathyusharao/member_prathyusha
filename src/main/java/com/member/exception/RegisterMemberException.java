package com.member.exception;
/*
 * custom Exception
 */

public class RegisterMemberException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String messageCode;
	
	private String messageText;

	/*
	 * message
	 */
	public RegisterMemberException(String messageCode, String messageText) {
		this.messageCode = messageCode;
		this.messageText = messageText;
	}

	/**
	 * @return the messageCode
	 */
	public String getMessageCode() {
		return messageCode;
	}

	/**
	 * @param messageCode the messageCode to set
	 */
	public void setMessageCode(String messageCode) {
		this.messageCode = messageCode;
	}

	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}

	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

}
