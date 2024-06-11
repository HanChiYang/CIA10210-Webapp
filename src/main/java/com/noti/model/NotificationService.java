package com.noti.model;

import java.util.List;

public class NotificationService {

	private NotificationDAO_interface dao;

	public NotificationService() {
		dao = new NotificationDAO();
	}

	public List<NotificationVO> getAll() {
		return dao.getAll();
	}
}
