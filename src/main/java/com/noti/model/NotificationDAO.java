package com.noti.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.util.HibernateUtil;

public class NotificationDAO implements NotificationDAO_interface {

	// 一個應用程式中,針對一個資料庫 ,共用一個DataSource即可
	private SessionFactory factory;

	public NotificationDAO() {
		factory = HibernateUtil.getSessionFactory();
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	public List<NotificationVO> getAll() {
		return getSession().createQuery("from NotificationVO", NotificationVO.class).list();
	}

	public static void main(String[] args) {
		NotificationDAO dao = new NotificationDAO();

		List<NotificationVO> list = dao.getAll();
		for (NotificationVO aEmp : list) {
			System.out.println(aEmp.getNotiNo() + ",");
			System.out.println(aEmp.getMemNo() + ",");
			System.out.println(aEmp.getNotiContent() + ",");

		}
	}
}