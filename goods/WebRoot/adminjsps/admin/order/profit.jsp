<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>My JSP 'bookdesc.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/book/add.css'/>">
<link rel="stylesheet" type="text/css" href="<c:url value='/jquery/jquery.datepick.css'/>">
<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick.js'/>"></script>
<script type="text/javascript" src="<c:url value='/jquery/jquery.datepick-zh-CN.js'/>"></script>
<script type="text/javascript">
$(function () {
	$("#starttime").datepick({dateFormat:"yy-mm-dd"});
	$("#endtime").datepick({dateFormat:"yy-mm-dd"});
});

</script>
  </head>
  
  <body>
  <div>
   <p style="font-weight: 900; color: red;">近三个月的总利润是： &yen; ${bean.profit }</p>
   <form action="<c:url value='/admin/AdminOrderServlet'/>" enctype="multipart/form-data" method="get" id="form">
    <input type="hidden" name="method" value="findProfitThreeMonth"/>
	开始时间：<input type="text" id="starttime" name="starttime" value="2013-6-1" style="width:100px;"/>

	结束时间：<input type="text" id="endtime" name="endtime" value="2013-6-1" style="width:100px;"/>
	<input type="submit" id="btn" class="btn" value="查看">
   </form>
  </div>

  </body>
</html>
