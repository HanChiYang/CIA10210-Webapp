<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.mem.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
	List<MemberVO> list = (List) request.getAttribute("list");
%>


<html>
<head>
<title>模糊查詢</title>

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

<h4>此頁練習採用 EL 的寫法取值:</h4>
<table id="table-1">
	<tr><td>
		 <h3>所有會員資料 - listBySearhing.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
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
		<th>修改</th>
		<th>刪除</th>
	</tr>
	<%@ include file="page1.file" %> 
	<c:forEach var="memberVO" items="${list}" begin="<%=pageIndex%>" end="<%=pageIndex+rowsPerPage-1%>">
		
		<tr>
			
			<td><img src="${pageContext.request.contextPath}/DBGifReader?memNo=${memberVO.memNo}" width="100" height="auto"></td>
			<td>${memberVO.memNo}</td>
			<td>${memberVO.memName}</td>
			<td>${memberVO.memSex == 'f' ? '女' : '男'}</td>
			<td>${memberVO.memPhone}</td>
			<td>${memberVO.memEmail}</td>
			<td>${memberVO.memUid}</td> 
			<td>${memberVO.memBirthday}</td>
			<td>${memberVO.memAccount}</td>
			<td>${memberVO.memPassword}</td>
			<td>${memberVO.memStatus == '0' ? '停權' : '正常'}</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/mem_hibernate/mem.do" style="margin-bottom: 0px;">
			     <input type="submit" value="修改">
			     <input type="hidden" name="memNo"  value="${memberVO.memNo}">
			     <input type="hidden" name="action"	value="getOne_For_Update"></FORM>
			</td>
			<td>
			  <FORM METHOD="post" ACTION="<%=request.getContextPath()%>/mem_hibernate/mem.do" style="margin-bottom: 0px;">
			     <input type="submit" value="刪除">
			     <input type="hidden" name="memNo"  value="${memberVO.memNo}">
			     <input type="hidden" name="action" value="delete"></FORM>
			</td>
		</tr>
	</c:forEach>
</table>
<%@ include file="page2.file" %>

</body>
</html>