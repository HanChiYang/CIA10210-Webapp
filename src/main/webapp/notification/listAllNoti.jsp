<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.noti.model.*"%>
<%-- 此頁練習採用 EL 的寫法取值 --%>

<%
    NotificationService notiSvc = new NotificationService();
    List<NotificationVO> list = notiSvc.getAll();
    pageContext.setAttribute("list", list);
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>所有通知資料 - listAllNoti.jsp</title>

<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f4f4f9;
        margin: 0;
        padding: 0;
    }

    header {
        background-color: #4CAF50;
        color: white;
        padding: 10px 0;
        text-align: center;
        margin-bottom: 20px;
    }

    header h3 {
        margin: 0;
    }

    header a {
        color: white;
        text-decoration: none;
        margin-left: 15px;
        font-size: 16px;
    }

    table {
        width: 80%;
        margin: 0 auto;
        border-collapse: collapse;
        box-shadow: 0 2px 4px rgba(0,0,0,0.1);
        background-color: white;
    }

    th, td {
        padding: 12px;
        border: 1px solid #ddd;
        text-align: left;
    }

    thead {
        background-color: #f2f2f2;
    }

    tbody tr:nth-child(even) {
        background-color: #f9f9f9;
    }

    tbody tr:nth-child(odd) {
        background-color: #ffffff;
    }

    tbody tr:hover {
        background-color: #f1f1f1;
    }

    th {
        background-color: #4CAF50;
        color: white;
        text-align: center;
    }

    .container {
        text-align: center;
        margin-bottom: 20px;
    }

    .container h4 {
        color: blue;
        display: inline;
        margin-right: 15px;
    }
</style>

</head>
<body>

<header>
    <h2>所有通知資料 - listAllNoti.jsp</h2>
    <h3>Connect DB by Hibernate</h3>
    <a href="noti_select_page.jsp">回首頁</a>
</header>

<div class="container">
    <h4>此頁練習採用 EL 的寫法取值:</h4>
</div>

<table>
    <thead>
        <tr>
            <th>通知內容</th>
            <th>通知時間</th>
            <th>狀態</th>
        </tr>
    </thead>
    <tbody>
        <%@ include file="page1.file" %>
        <c:forEach var="notiVO" items="${list}">
            <tr>
                <td>${notiVO.notiContent}</td>
                <td>${notiVO.notiTime}</td>
                <td>${notiVO.notiStatus == '0' ? '未讀' : '已讀'}</td>
            </tr>
        </c:forEach>
        <%@ include file="page2.file" %>
    </tbody>
</table>

</body>
</html>
