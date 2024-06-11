package com.mem.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class MemberVO implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column (name = "mem_no", updatable = false, insertable = false)
	private Integer memNo;
	
	@Column (name = "mem_name")
	private String memName;
	@Column (name = "mem_sex", columnDefinition = "char")
	private String memSex;
	@Column (name = "mem_phone")
	private String memPhone;
	@Column (name = "mem_email")
	private String memEmail;
	@Column (name = "mem_uid")
	private String memUid;
	@Column (name = "mem_birthday")
	private Date memBirthday;
	@Column (name = "mem_account")
	private String memAccount;
	@Column (name = "mem_password")
	private String memPassword;
	@Column (name = "mem_img", columnDefinition = "longblob")
	private byte[] memImg;
	@Column (name = "mem_status")
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
