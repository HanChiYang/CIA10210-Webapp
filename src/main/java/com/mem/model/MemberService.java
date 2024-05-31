package com.mem.model;

import java.util.List;

public class MemberService {

	private MemberDAO_interface dao;

	public MemberService() {
		dao = new MemberJDBCDAO();
	}

	public MemberVO addMember(String memName, String memSex, String memPhone, 
			String memEmail, String memUid, java.sql.Date memBirthday,
			String memAccount, String memPassword, Byte memStatus) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMemName(memName);
		memberVO.setMemSex(memSex);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemEmail(memEmail);
		memberVO.setMemUid(memUid);
		memberVO.setMemBirthday(memBirthday);
		memberVO.setMemAccount(memAccount);
		memberVO.setMemPassword(memPassword);
		memberVO.setMemStatus(memStatus);
		dao.insert(memberVO);

		return memberVO;
	}

	public MemberVO updateMember(String memName, String memSex, String memPhone, 
			String memEmail, String memUid, java.sql.Date memBirthday,
			String memAccount, String memPassword, Byte memStatus) {

		MemberVO memberVO = new MemberVO();

		memberVO.setMemName(memName);
		memberVO.setMemSex(memSex);
		memberVO.setMemPhone(memPhone);
		memberVO.setMemEmail(memEmail);
		memberVO.setMemUid(memUid);
		memberVO.setMemBirthday(memBirthday);
		memberVO.setMemAccount(memAccount);
		memberVO.setMemPassword(memPassword);
		memberVO.setMemStatus(memStatus);
		dao.update(memberVO);

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
