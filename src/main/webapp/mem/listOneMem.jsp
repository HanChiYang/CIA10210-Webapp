<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.mem.model.*"%>
<%-- 此頁暫練習採用 Script 的寫法取值 --%>

<%
  MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>

<html>
<head>
<title>會員資料 - listOneMem.jsp</title>

<style>
  table#table-1 {
	background-color: #CCCCFF;
    border: 2px solid black;
    text-align: center;
  }
  table#table-1 h4 {
    color: red;
    display: block;
    margin-bottom: 1px;
  }
  h4 {
    color: blue;
    display: inline;
  }
</style>

<style>


  table {
    width: 90%;
    border-collapse: collapse;
	background-color: white;
	margin-top: 5px;
	margin-bottom: 5px;
  }
  table, th, td {
    border: 1px solid #CCCCFF;
  }
  th, td {
    padding: 5px;
    text-align: center;
  }
</style>

</head>
<body bgcolor='white'>

<h4>此頁暫練習採用 Script 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>員工資料 - listOneMem.jsp</h3>
		 <h4><a href="select_page_img.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<table>
	<tr>
		<th>會員圖片</th>
		<th width ="70">會員編號</th>
		<th width ="50">姓名</th>
		<th width ="50">性別</th>
		<th>電話</th>
		<th>電子信箱</th>
		<th>身份證字號</th>
		<th width ="100">生日</th>
		<th>帳號</th>
		<th>密碼</th>
		<th>狀態</th>

	</tr>
	<tr>
		<td><img src="DBGifReader4?memNo=${memberVO.memNo}" width="100" height="auto"></td>
		<td><%=memberVO.getMemNo()%></td>
		<td><%=memberVO.getMemName()%></td>
		<td><%= memberVO.getMemSex().equals("m") ? "男" : "女" %></td>
		<td><%=memberVO.getMemPhone()%></td>
		<td><%=memberVO.getMemEmail()%></td>
		<td><%=memberVO.getMemUid()%></td>
		<td><%=memberVO.getMemBirthday()%></td>
		<td><%=memberVO.getMemAccount()%></td>
		<td><%=memberVO.getMemPassword()%></td>
		<td><%= memberVO.getMemStatus().equals("0") ? "停權" : "正常" %></td>
	</tr>
</table>

</body>
</html>