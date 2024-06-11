package com.noti.model;

import java.util.List;

public interface NotificationDAO_interface {
//          public void insert(NotificationVO notificationVO);
//          public void update(NotificationVO notificationVO);
          public List<NotificationVO> getAll();
          //萬用複合查詢(傳入參數型態Map)(回傳 List)
//        public List<EmpVO> getAll(Map<String, String[]> map); 
}
