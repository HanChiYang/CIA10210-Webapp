<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Notification connected DB by Hibernate</title>

<style>
  body {
  position: absolute;
  top: 40%;
  left: 50%;
  transform: translate(-50%, -50%);	
  
  }
  
  li {
   list-style-type: none;
  }

  table#table-1 {
	width: 450px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
    border: 3px ridge Gray;
    height: 80px;
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

</head>
<body bgcolor='white'>

<table id="table-1">
   <tr><td><h3>Notification connected DB by Hibernate</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Notification: Home</p>

<h3>資料查詢:</h3>
	
<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
	    <c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<ul>
  <li><a href='listAllNoti.jsp'>List</a> all Notifications.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="noti.do" >
        <b>輸入通知編號 (如1):</b>
        <input type="text" name="notiNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="notiSvc" scope="page" class="com.noti.model.NotificationService" />
   
  <li>
     <FORM METHOD="post" ACTION="noti.do" >
       <b>選擇通知編號:</b>
       <select size="1" name="notiNo">
         <c:forEach var="notificationVO" items="${notiSvc.all}" > 
          <option value="${notificationVO.notiNo}">${notificationVO.notiNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="noti.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="notiNo">
         <c:forEach var="notificationVO" items="${memSvc.all}" > 
          <option value="${notificationVO.memNo}">${notificationVO.memNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>訊息管理</h3>

<ul>
  <li><a href='addNoti.jsp'>Add</a> a new Notification.</li>
</ul>
</body>
</html>