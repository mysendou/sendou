<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>分类列表</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/category/list.css'/>">
	<link rel="stylesheet" type="text/css" href="<c:url value='/css/css.css'/>">
  </head>
  
  <body>
    <!--  <h1 style="text-align: center;">分类列表</h1> -->
    <table align="center" border="0" cellpadding="0" cellspacing="0">
    	<caption class="captionAddOneLevel">
    	  <span style="font-weight:bold;">分类列表 </span><span>|</span>
    	  <a href="<c:url value='/adminjsps/admin/category/add.jsp'/>">添加一级分类</a>
    	</caption>
    	<tr class="trTitle">
    		<th style="padding-right:150px;">分类名称</th>
    		<th style="padding-right:190px;">描述</th>
    		<th>操作</th>
    	</tr>
    	<tr>
    	   <td></td>
    	   <td></td>
    	   <td></td>
    	</tr>
<c:forEach items="${parents }" var="parent"> 	
    	<tr class="trOneLevel">
    		<td width="400px;">${parent.cname }</td>
    		<td>${parent.desc }</td>
    		<td width="200px;">
    		  <a href="<c:url value='/admin/AdminCategoryServlet?method=addChildPre&pid=${parent.cid }'/>">添加二级分类</a>
    		  <a href="<c:url value='/admin/AdminCategoryServlet?method=editParentPre&cid=${parent.cid }'/>">修改</a>
    		  <a onclick="return confirm('您是否真要删除该一级分类？')" href="<c:url value='/admin/AdminCategoryServlet?method=deleteParent&cid=${parent.cid }'/>">删除</a>
    		</td>
    	</tr>
   <c:forEach items="${parent.children }" var="child">
    	<tr class="trTwoLevel">
    		<td>${child.cname }</td>
    		<td>${child.desc }</td>
    		<td width="200px;" align="center">
    		  <a href="<c:url value='/admin/AdminCategoryServlet?method=editChildPre&cid=${child.cid }'/>">修改</a>
    		  <a onclick="return confirm('您是否真要删除该二级分类？')" href="<c:url value='/admin/AdminCategoryServlet?method=deleteChild&cid=${child.cid }'/>">删除</a>
    		</td>
    	</tr>
   </c:forEach>
</c:forEach>


    </table>
  </body>
</html>
