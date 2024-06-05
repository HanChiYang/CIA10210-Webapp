package com.mem.model;

import java.util.List;

public class MemberServiceImg {

	private MemberDAO_interface dao;

	public MemberServiceImg() {
		dao = new MemberJNDIDAOImg();
	}

	public MemberVO addMember(String memName, String memSex, String memPhone, 
			String memEmail, String memUid, java.sql.Date memBirthday,
			String memAccount, String memPassword, byte[] memImg) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemName(memName);
		memberVO.setMemSex(memSex);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemEmail(memEmail);
		memberVO.setMemUid(memUid);
		memberVO.setMemBirthday(memBirthday);
		memberVO.setMemAccount(memAccount);
		memberVO.setMemPassword(memPassword);
		memberVO.setMemImg(memImg);
		dao.insert(memberVO);
		
		return memberVO;
	}

	public MemberVO updateMember(Integer memNo, String memName, String memSex, String memPhone, 
			String memEmail, String memUid, java.sql.Date memBirthday,
			String memAccount, String memPassword, Byte memStatus, byte[] memImg) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMemNo(memNo);
		memberVO.setMemName(memName);
		memberVO.setMemSex(memSex);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemEmail(memEmail);
		memberVO.setMemUid(memUid);
		memberVO.setMemBirthday(memBirthday);
		memberVO.setMemAccount(memAccount);
		memberVO.setMemPassword(memPassword);
		memberVO.setMemStatus(memStatus);
		memberVO.setMemImg(memImg);
		dao.update(memberVO);

		return memberVO;
	}
	public MemberVO updateWithoutImg(Integer memNo, String memName, String memSex, String memPhone, 
			String memEmail, String memUid, java.sql.Date memBirthday,
			String memAccount, String memPassword, Byte memStatus) {
		
		MemberVO memberVO = new MemberVO();
		
		memberVO.setMemNo(memNo);
		memberVO.setMemName(memName);
		memberVO.setMemSex(memSex);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemEmail(memEmail);
		memberVO.setMemUid(memUid);
		memberVO.setMemBirthday(memBirthday);
		memberVO.setMemAccount(memAccount);
		memberVO.setMemPassword(memPassword);
		memberVO.setMemStatus(memStatus);
		dao.updateWithoutImg(memberVO);
		
		return memberVO;
	}
	
	

	public void deleteMember(Integer memNo) {
		dao.delete(memNo);
	}
	

	public MemberVO getOneMember(Integer memNo) {
		return dao.findByPrimaryKey(memNo);
	}

	public List<MemberVO> getAll() {
		return dao.getAll();
	}
}
