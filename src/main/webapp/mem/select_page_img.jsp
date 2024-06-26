<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>Member: Home</title>

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
   <tr><td><h3>Member: Home</h3><h4>( MVC )</h4></td></tr>
</table>

<p>This is the Home page for Member: Home</p>

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
  <li><a href='listAllMem.jsp'>List</a> all Members.  <br><br></li>
  
  
  <li>
    <FORM METHOD="post" ACTION="memimg.do" >
        <b>輸入會員編號 (如1001):</b>
        <input type="text" name="memNo">
        <input type="hidden" name="action" value="getOne_For_Display">
        <input type="submit" value="送出">
    </FORM>
  </li>

  <jsp:useBean id="memSvc" scope="page" class="com.mem.model.MemberServiceImg" />
   
  <li>
     <FORM METHOD="post" ACTION="memimg.do" >
       <b>選擇會員編號:</b>
       <select size="1" name="memNo">
         <c:forEach var="memberVO" items="${memSvc.all}" > 
          <option value="${memberVO.memNo}">${memberVO.memNo}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
    </FORM>
  </li>
  
  <li>
     <FORM METHOD="post" ACTION="memimg.do" >
       <b>選擇會員姓名:</b>
       <select size="1" name="memNo">
         <c:forEach var="memberVO" items="${memSvc.all}" > 
          <option value="${memberVO.memNo}">${memberVO.memName}
         </c:forEach>   
       </select>
       <input type="hidden" name="action" value="getOne_For_Display">
       <input type="submit" value="送出">
     </FORM>
  </li>
</ul>


<h3>會員管理</h3>

<ul>
  <li><a href='addMemPreImg.jsp'>Add</a> a new Member.</li>
</ul>
</body>
</html>