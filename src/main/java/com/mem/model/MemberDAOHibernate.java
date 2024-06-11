package com.mem.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

public class MemberDAOHibernate implements MemberDAO_interface {
	private SessionFactory factory;

	public MemberDAOHibernate() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@Override
	public List<MemberVO> getAll() {
		return getSession().createQuery("from MemberVO", MemberVO.class).list();
	}

	@Override
	public List<MemberVO> findBySearching(String input) {
		return getSession()
				.createQuery("from MemberVO where memName like '%" + input + "%' order by memNo"
				, MemberVO.class)
				.list();
	}

	@Override
	public MemberVO findByPrimaryKey(Integer memNo) {
		return getSession().get(MemberVO.class, memNo);
	}

	@Override
	public void delete(Integer memNo) {
		MemberVO memberVO = getSession().get(MemberVO.class, memNo);
		getSession().delete(memberVO);
	}

	@Override
	public void insert(MemberVO memberVO) {
		getSession().save(memberVO);
	}

	@Override
	public void update(MemberVO memberVO) {
		getSession().update(memberVO);
	}

	@Override
	public void updateWithoutImg(MemberVO memberVO) {
		getSession().update(memberVO);
	}

}