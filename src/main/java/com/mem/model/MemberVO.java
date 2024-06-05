package com.mem.model;

import java.sql.Date;

public class MemberVO implements java.io.Serializable{
	private Integer memNo;
	private String memName;
	private String memSex;
	private String memPhone;
	private String memEmail;
	private String memUid;
	private Date memBirthday;
	private String memAccount;
	private String memPassword;
	private byte[] memImg;
	private Byte memStatus;
	
	public Integer getMemNo() {
		return memNo;
	}
	public void setMemNo(Integer memNo) {
		this.memNo = memNo;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemSex() {
		return memSex;
	}
	public void setMemSex(String memSex) {
		this.memSex = memSex;
	}
	public String getMemPhone() {
		return memPhone;
	}
	public void setMemPhone(String memPhone) {
		this.memPhone = memPhone;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemUid() {
		return memUid;
	}
	public void setMemUid(String memUid) {
		this.memUid = memUid;
	}
	public Date getMemBirthday() {
		return memBirthday;
	}
	public void setMemBirthday(Date memBirthday) {
		this.memBirthday = memBirthday;
	}
	public String getMemAccount() {
		return memAccount;
	}
	public void setMemAccount(String memAccount) {
		this.memAccount = memAccount;
	}
	public String getMemPassword() {
		return memPassword;
	}
	public void setMemPassword(String memPassword) {
		this.memPassword = memPassword;
	}
	public byte[] getMemImg() {
		return memImg;
	}
	public void setMemImg(byte[] memImg) {
		this.memImg = memImg;
	}
	public Byte getMemStatus() {
		return memStatus;
	}
	public void setMemStatus(Byte memStatus) {
		this.memStatus = memStatus;
	}
	
	
}
