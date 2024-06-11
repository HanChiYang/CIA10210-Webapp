<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="com.mem.model.*"%>

<% //見com.emp.controller.EmpServlet.java第163行存入req的empVO物件 (此為從資料庫取出的empVO, 也可以是輸入格式有錯誤時的empVO物件)
	MemberVO memberVO = (MemberVO) request.getAttribute("memberVO"); //EmpServlet.java(Concroller), 存入req的empVO物件
%>
<html>
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
<title>會員資料修改 - update_mem_input.jsp</title>

<style>
  body {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);	
  }

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

  table {
	width: 450px;
	background-color: white;
	margin-top: 1px;
	margin-bottom: 1px;
  }
  table, th, td {
    border: 0px solid #CCCCFF;
  }
  th, td {
    padding: 1px;
  }
  
    #preview{
      border: 1px solid lightgray;
      display: flex;
      width: 150px;
      min-height: 150px;
      position: relative;
      justify-content: center; /* 在水平方向上居中对齐 */
      align-items: center; /* 在垂直方向上居中对齐 */
    }

    #preview span.text{
      position: absolute;
      display: inline-block;
      left: 50%;
      top: 50%;
      transform: translate(-50%, -50%);
      z-index: 1;
      color: lightgray;
    }
    #preview img.preview_img{

      max-width: 100%; /* 图片最大宽度为父容器的宽度 */
      max-height: 100%; /* 图片最大高度为父容器的高度 */
      display: block; /* 块级元素 */
      margin: auto; /* 居中显示 */
    }

    .column1{
      width: 100px;
    }

    #td_inputfile {
      width: 300px
    }

    #preview.-uploaded {
      border: none;
      display: flex;
      width: 150px;
      min-height: 150px;
      position: relative;
      justify-content: center; /* 在水平方向上居中对齐 */
      align-items: center; /* 在垂直方向上居中对齐 */
    }

    
   td.align-left {
    text-align: left;
  }

</style>

</head>
<body bgcolor='white'>

<table id="table-1">
	<tr><td>
		 <h3>會員資料修改 - update_mem_input.jsp</h3>
		 <h4><a href="select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></h4>
	</td></tr>
</table>

<h3>資料修改:</h3>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font style="color:red">請修正以下錯誤:</font>
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li style="color:red">${message}</li>
		</c:forEach>
	</ul>
</c:if>

<FORM METHOD="post" ACTION="mem.do" name="form1" enctype="multipart/form-data">
  <table id="preview_table">
    <tr>
	  <td>大頭貼:</td>
	  <td class="align-left"><img src="${pageContext.request.contextPath}/DBGifReader?memNo=${memberVO.memNo}" width="150" height="auto"></td>
      <td>
        <div id="preview">
          <span class="text">預覽圖</span>
        </div>
      </td>

	</tr>
	    <tr>
	      <td class="column1">變更大頭貼:</td>
	      <td colspan="2"><input type="FILE" name="memImg" id="p_file"/></td>
	      <td></td>
	    </tr>
  </table>


<table>

	<tr>
		<td class="column1">姓名:</td>
		<td><input type="TEXT" name="memName" value="<%= (memberVO==null)? "楊翰祁" : memberVO.getMemName()%>" size="45"/></td>
	</tr>
	<tr>
		<td>性別:</td>
		<td>
            <input type="Radio" name="memSex" value="m" <%= (memberVO != null && "m".equals(memberVO.getMemSex())) ? "checked" : "" %>>男
            <input type="Radio" name="memSex" value="f" <%= (memberVO != null && "f".equals(memberVO.getMemSex())) ? "checked" : "" %>>女
		</td>
	</tr>
	<tr>
		<td>生日:</td>
		<td><input name="memBirthday" id="f_date1" type="text" ></td>
	</tr>
	<tr>
		<td>電話:</td>
		<td><input type="TEXT" name=memPhone   value="<%= (memberVO==null)? "0987654321" : memberVO.getMemPhone()%>" size="45"/></td>
	</tr>
	<tr>
		<td>電子信箱:</td>
		<td><input type="TEXT" name="memEmail"   value="<%= (memberVO==null)? "XXX@gmail.com" : memberVO.getMemEmail()%>" size="45"/></td>
	</tr>
	<tr>
		<td>身分證字號:</td>
		<td><input type="TEXT" name="memUid"  value="<%= (memberVO==null)? "a123456789" : memberVO.getMemUid()%>" size="45"/></td>
	</tr>
	<tr>
		<td>帳號:</td>
		<td><input type="TEXT" name="memAccount"  value="<%= (memberVO==null)? "thisIsAccount" : memberVO.getMemAccount()%>" size="45"/></td>
	</tr>
	<tr>
		<td>密碼:</td>
		<td><input type="TEXT" name="memPassword"  value="<%= (memberVO==null)? "thisIsPassword" : memberVO.getMemPassword()%>" size="45"/></td>
	</tr>

	<tr>
	<td>會員狀態</td>
	<td>
         <input type="Radio" name="memStatus" value="1" <%= (memberVO != null && 1 == (memberVO.getMemStatus())) ? "checked" : "" %>>正常
         <input type="Radio" name="memStatus" value="0" <%= (memberVO != null && 0 == (memberVO.getMemStatus())) ? "checked" : "" %>>停權
	</td>
	</tr>
</table>
<br>
<input type="hidden" name="action" value="update">
<input type="hidden" name="memNo" value="<%=memberVO.getMemNo()%>">
<input type="submit" value="送出修改"></FORM>

</body>



<!-- =========================================以下為 datetimepicker 之相關設定========================================== -->

<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.css" />
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.js"></script>
<script src="<%=request.getContextPath()%>/datetimepicker/jquery.datetimepicker.full.js"></script>

<style>
  .xdsoft_datetimepicker .xdsoft_datepicker {
           width:  300px;   /* width:  300px; */
  }
  .xdsoft_datetimepicker .xdsoft_timepicker .xdsoft_time_box {
           height: 151px;   /* height:  151px; */
  }
</style>

<script>

let preview_zone = document.getElementById("preview");
let file_btn = document.getElementById("p_file");

let preview_file = function(file) {
      let reader = new FileReader();
      reader.readAsDataURL(file);
      reader.addEventListener("load", function () {
        let src_str = "<img src='" + this.result + "' class='preview_img'>";
        preview_zone.innerHTML = src_str;
      });
    }


file_btn.addEventListener("change", function () {
      if (this.files.length > 0) {
        preview_file(this.files[0]);  //呼叫預覽函式
        preview_zone.classList.add("-uploaded");
      }else {
        preview_zone.classList.remove("-uploaded");

        preview_zone.innerHTML = '<span class="text">預覽圖</span>';
      }
    });
        $.datetimepicker.setLocale('zh');
        $('#f_date1').datetimepicker({
           theme: '',              //theme: 'dark',
 	       timepicker:false,       //timepicker:true,
 	       step: 1,                //step: 60 (這是timepicker的預設間隔60分鐘)
 	       format:'Y-m-d',         //format:'Y-m-d H:i:s',
 		   value: '<%=memberVO.getMemBirthday()%>', // value:   new Date(),
           //disabledDates:        ['2017/06/08','2017/06/09','2017/06/10'], // 去除特定不含
           //startDate:	            '2017/07/10',  // 起始日
           //minDate:               '-1970-01-01', // 去除今日(不含)之前
           //maxDate:               '+1970-01-01'  // 去除今日(不含)之後
        });
        
        
   
        // ----------------------------------------------------------以下用來排定無法選擇的日期-----------------------------------------------------------

        //      1.以下為某一天之前的日期無法選擇
        //      var somedate1 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});

        
        //      2.以下為某一天之後的日期無法選擇
        //      var somedate2 = new Date('2017-06-15');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});


        //      3.以下為兩個日期之外的日期無法選擇 (也可按需要換成其他日期)
        //      var somedate1 = new Date('2017-06-15');
        //      var somedate2 = new Date('2017-06-25');
        //      $('#f_date1').datetimepicker({
        //          beforeShowDay: function(date) {
        //        	  if (  date.getYear() <  somedate1.getYear() || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() <  somedate1.getMonth()) || 
        //		           (date.getYear() == somedate1.getYear() && date.getMonth() == somedate1.getMonth() && date.getDate() < somedate1.getDate())
        //		             ||
        //		            date.getYear() >  somedate2.getYear() || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() >  somedate2.getMonth()) || 
        //		           (date.getYear() == somedate2.getYear() && date.getMonth() == somedate2.getMonth() && date.getDate() > somedate2.getDate())
        //              ) {
        //                   return [false, ""]
        //              }
        //              return [true, ""];
        //      }});
        
</script>
</html>