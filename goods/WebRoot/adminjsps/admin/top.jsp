<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>top</title>
    <base target="body">
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	body {font-size: 10pt;}
	a {color: #aaa; text-decoration:none; font-weight: 100;color: green; font-family: '微软雅黑'}
</style>
  </head>
  
  <body style="background-image: url('top.gif'); background-repeat: no-repeat;">
<h1 style="text-align: center; line-height: 30px;"></h1>
<div style="line-height: 10px; padding-top: 80px">
	<span>管理员：${sessionScope.admin.adminname }</span>
	<a target="_top" href="<c:url value='/adminjsps/login.jsp'/>">退出</a>
	<span style="padding-left:50px;">
		<a href="<c:url value='/admin/AdminCategoryServlet?method=findAll'/>">图书类型管理</a>
		<a href="<c:url value='/adminjsps/admin/book/main.jsp'/>">图书管理</a>
		<a href="<c:url value='/admin/AdminOrderServlet?method=findAll'/>">订单管理</a>
		<a href="<c:url value='/admin/AdminOrderServlet?method=findAllCategoryBook'/>">信息统计</a>
		<a href="<c:url value='/admin/AdminOrderServlet?method=findProfitThreeMonth'/>">查看利润</a>
	</span>
</div>
  </body>
</html>
