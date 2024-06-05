package com.mem.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.mem.model.MemberServiceImg;
import com.mem.model.MemberVO;

@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 5 * 1024 * 1024
				, maxRequestSize = 5 * 5 * 1024 * 1024)
public class MemberServletImg extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		
		
		if ("getOne_For_Display".equals(action)) { // 來自select_page.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
				String str = req.getParameter("memNo");
				if (str == null || (str.trim()).length() == 0) {
					errorMsgs.add("請輸入會員編號");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mem/select_page_img.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				Integer memNo = null;
				try {
					memNo = Integer.valueOf(str);
				} catch (Exception e) {
					errorMsgs.add("會員編號格式不正確");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mem/select_page_img.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************2.開始查詢資料*****************************************/
				MemberServiceImg memSvc = new MemberServiceImg();
				MemberVO memberVO = memSvc.getOneMember(memNo);
				if (memberVO == null) {
					errorMsgs.add("查無資料");
				}
				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mem/select_page_img.jsp");
					failureView.forward(req, res);
					return;//程式中斷
				}
				
				/***************************3.查詢完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // 資料庫取出的empVO物件,存入req
				String url = "/mem/listOneMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 成功轉交 listOneEmp.jsp
				successView.forward(req, res);
		}
		
		
		if ("getOne_For_Update".equals(action)) { // 來自listAllEmp.jsp的請求

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
			
				/***************************1.接收請求參數****************************************/
				Integer memNo = Integer.valueOf(req.getParameter("memNo"));
				
				/***************************2.開始查詢資料****************************************/
				MemberServiceImg memSvc = new MemberServiceImg();
				MemberVO memberVO = memSvc.getOneMember(memNo);
								
				/***************************3.查詢完成,準備轉交(Send the Success view)************/
				req.setAttribute("memberVO", memberVO);         // 資料庫取出的empVO物件,存入req
				String url = "/mem/update_mem_input.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 成功轉交 update_emp_input.jsp
				successView.forward(req, res);
		}
		
		
		if ("update".equals(action)) { // 來自update_emp_input.jsp的請求
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
		
				/***************************1.接收請求參數 - 輸入格式的錯誤處理**********************/
Integer memNo = Integer.valueOf(req.getParameter("memNo").trim());
				
String memName = req.getParameter("memName");
				String memNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
				if (memName == null || memName.trim().length() == 0) {
					errorMsgs.add("員工姓名: 請勿空白");
				} else if(!memName.trim().matches(memNameReg)) { //以下練習正則(規)表示式(regular-expression)
					errorMsgs.add("員工姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
	            }
				
				
String memSex = req.getParameter("memSex").trim();
				if (memSex == null) {
					errorMsgs.add("請選擇性別");
				}	
				
String memPhone = req.getParameter("memPhone").trim();
				if (memPhone == null || memPhone.trim().length() == 0) {
					errorMsgs.add("手機請勿空白");
				}	
				
String memEmail = req.getParameter("memEmail").trim();
				String memEmailReg = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
				if (memEmail == null || memEmail.trim().length() == 0) {
					errorMsgs.add("Email請勿空白");
				}else if(!memEmail.trim().matches(memEmailReg)) {
					errorMsgs.add("Email格式不符");
	            }
				
String memUid = req.getParameter("memUid").trim();
				String memUidReg = "^[A-Za-z][1-2]\\d{8}";
				if (memUid == null || memUid.trim().length() == 0) {
					errorMsgs.add("身份證字號請勿空白");
				}else if(!memUid.trim().matches(memUidReg)) {
					errorMsgs.add("身分證字號格式不符");
	            }
				
				java.sql.Date memBirthday = null;
				try {
memBirthday = java.sql.Date.valueOf(req.getParameter("memBirthday").trim());
				} catch (IllegalArgumentException e) {
					memBirthday=new java.sql.Date(System.currentTimeMillis());
					errorMsgs.add("請輸入生日!");
				}
				
				
String memAccount = req.getParameter("memAccount").trim();
				if (memAccount == null || memAccount.trim().length() == 0) {
					errorMsgs.add("帳號請勿空白");
				}
				
String memPassword = req.getParameter("memPassword").trim();
				if (memPassword == null || memPassword.trim().length() == 0) {
					errorMsgs.add("密碼請勿空白");
				}
Byte memStatus = Byte.valueOf(req.getParameter("memStatus").trim());

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
				
	            Part partMemImg = req.getPart("memImg");
	            byte[] memImg = null;
	            if (partMemImg != null && partMemImg.getSize() > 0) {
	                String contentType = partMemImg.getContentType();
	                if ("image/jpeg".equals(contentType) || "image/png".equals(contentType) || "image/gif".equals(contentType)) {
	                    try (InputStream inputStream = partMemImg.getInputStream()) {
	                        memImg = inputStream.readAllBytes();
	                    }
	                }else {
	                	errorMsgs.add("上傳檔案格式錯誤");
	                }
	            }


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mem/update_mem_input.jsp");
					failureView.forward(req, res);
					return; //程式中斷
				}
				
				/***************************2.開始修改資料*****************************************/
				MemberServiceImg memSvc = new MemberServiceImg();
			    if (memImg != null) {
					memberVO = memSvc.updateMember(memNo, memName, memSex, memPhone, memEmail, memUid,
							memBirthday, memAccount, memPassword, memStatus, memImg);
			    } else {
					memberVO = memSvc.updateWithoutImg(memNo, memName, memSex, memPhone, memEmail, memUid,
							memBirthday, memAccount, memPassword, memStatus);
			    }

				
				/***************************3.修改完成,準備轉交(Send the Success view)*************/
				req.setAttribute("memberVO", memberVO); // 資料庫update成功後,正確的的empVO物件,存入req
				String url = "/mem/listOneMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 修改成功後,轉交listOneEmp.jsp
				successView.forward(req, res);
		}

        if ("insert".equals(action)) { // 來自addEmp.jsp的請求  
			
			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);

				/***********************1.接收請求參數 - 輸入格式的錯誤處理*************************/			
			String memName = req.getParameter("memName");
							String memNameReg = "^[(\u4e00-\u9fa5)(a-zA-Z0-9_)]{2,10}$";
							if (memName == null || memName.trim().length() == 0) {
								errorMsgs.add("會員姓名: 請勿空白");
							} else if(!memName.trim().matches(memNameReg)) { //以下練習正則(規)表示式(regular-expression)
								errorMsgs.add("會員姓名: 只能是中、英文字母、數字和_ , 且長度必需在2到10之間");
				            }
							
							
			String memSex = req.getParameter("memSex");
							if (memSex == null) {
								errorMsgs.add("性別請勿空白");
							}	
							
			String memPhone = req.getParameter("memPhone").trim();
							if (memPhone == null || memPhone.trim().length() == 0) {
								errorMsgs.add("手機請勿空白");
							}	
							
			String memEmail = req.getParameter("memEmail").trim();
							String memEmailReg = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
							if (memEmail == null || memEmail.trim().length() == 0) {
								errorMsgs.add("Email請勿空白");
							}else if(!memEmail.trim().matches(memEmailReg)) {
								errorMsgs.add("Email格式不符");
				            }
							
			String memUid = req.getParameter("memUid").trim();
							String memUidReg = "^[A-Za-z][1-2]\\d{8}";
							if (memUid == null || memUid.trim().length() == 0) {
								errorMsgs.add("身份證字號請勿空白");
							}else if(!memUid.trim().matches(memUidReg)) {
								errorMsgs.add("身分證字號格式不符");
				            }
							
							java.sql.Date memBirthday = null;
							try {
			memBirthday = java.sql.Date.valueOf(req.getParameter("memBirthday").trim());
							} catch (IllegalArgumentException e) {
								memBirthday=new java.sql.Date(System.currentTimeMillis());
								errorMsgs.add("請輸入生日!");
							}
							
							
			String memAccount = req.getParameter("memAccount").trim();
							if (memAccount == null || memAccount.trim().length() == 0) {
								errorMsgs.add("帳號請勿空白");
							}
							
			String memPassword = req.getParameter("memPassword").trim();
							if (memPassword == null || memPassword.trim().length() == 0) {
								errorMsgs.add("密碼請勿空白");
							}
//			Byte memStatus = Byte.valueOf(req.getParameter("memStatus").trim());
			
			

			MemberVO memberVO = new MemberVO();
			memberVO.setMemName(memName);
			memberVO.setMemSex(memSex);
			memberVO.setMemPhone(memPhone);
			memberVO.setMemEmail(memEmail);
			memberVO.setMemUid(memUid);
			memberVO.setMemBirthday(memBirthday);
			memberVO.setMemAccount(memAccount);
			memberVO.setMemPassword(memPassword);
			
			//圖片上傳
            Part partMemImg = req.getPart("memImg");
            byte[] memImg = null;
            if (partMemImg != null && partMemImg.getSize() > 0) {
                String contentType = partMemImg.getContentType();
                if ("image/jpeg".equals(contentType) || "image/png".equals(contentType) || "image/gif".equals(contentType)) {
                    try (InputStream inputStream = partMemImg.getInputStream()) {
                        memImg = inputStream.readAllBytes();
                    }
                } else {
                	errorMsgs.add("上傳檔案格式錯誤");
                }
            }


				// Send the use back to the form, if there were errors
				if (!errorMsgs.isEmpty()) {
req.setAttribute("memberVO", memberVO); // 含有輸入格式錯誤的empVO物件,也存入req
					RequestDispatcher failureView = req
							.getRequestDispatcher("/mem/addMemPreImg.jsp");
					failureView.forward(req, res);
					return;
				}
				
				/***************************2.開始新增資料***************************************/
				MemberServiceImg memSvc = new MemberServiceImg();
				
				memberVO = memSvc.addMember(memName, memSex, memPhone, memEmail, memUid,
						memBirthday, memAccount, memPassword, memImg);
				
				/***************************3.新增完成,準備轉交(Send the Success view)***********/
				String url = "/mem/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url); // 新增成功後轉交listAllEmp.jsp
				successView.forward(req, res);				
		}
        

		
		if ("delete".equals(action)) { // 來自listAllEmp.jsp

			List<String> errorMsgs = new LinkedList<String>();
			// Store this set in the request scope, in case we need to
			// send the ErrorPage view.
			req.setAttribute("errorMsgs", errorMsgs);
	
				/***************************1.接收請求參數***************************************/
				Integer memNo = Integer.valueOf(req.getParameter("memNo"));
				
				/***************************2.開始刪除資料***************************************/
MemberServiceImg memSvc = new MemberServiceImg();
				memSvc.deleteMember(memNo);
				
				/***************************3.刪除完成,準備轉交(Send the Success view)***********/								
				String url = "/mem/listAllMem.jsp";
				RequestDispatcher successView = req.getRequestDispatcher(url);// 刪除成功後,轉交回送出刪除的來源網頁
				successView.forward(req, res);
		}
	}
}
