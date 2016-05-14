<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>组合查询</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
	table {
		color: #404040;
		border: 1px solid #386495;
        border-radius: 3px;
        padding: 40px;
        margin-left: 245px;
        margin-top: 50px;
        font-family: "微软雅黑";
	}
	input{
	    font-family:"微软雅黑";
	}
</style>
  </head>
  
  <body>
  <form action="<c:url value='/BookServlet'/>" method="get">
  	<input type="hidden" name="method" value="findByCombination"/>
<table align="center">
	<tr>
		<td>书名：</td>
		<td><input type="text" name="bname"/></td>
	</tr>
	<tr>
		<td>作者：</td>
		<td><input type="text" name="author"/></td>
	</tr>
	<tr>
		<td>出版社：</td>
		<td><input type="text" name="press"/></td>
	</tr>
	<tr>
	   <td></td>
	   <td></td>
	   <td></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
			<input type="submit" value="搜　　索"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<input type="reset" value="重新填写"/>
		</td>
	</tr>
</table>
	</form>
  </body>
</html>
