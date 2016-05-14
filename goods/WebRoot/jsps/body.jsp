<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="">
    
    <title>body</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta http-equiv="content-type" content="text/html;charset=utf-8">
	
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style type="text/css">
a {text-decoration: none;}
h2{text-align:center;font-family:"微软雅黑";color: #404040;}
</style>
  </head>
  
  <body>
    <h2>欢迎进入IT图书销售系统</h2>
 
    <link rel="stylesheet" type="text/css" href="css/style.css">


<script type="text/javascript" src="js/banner/koala.min.1.5.js"></script>
<script type="text/javascript">
Qfast.add('widgets', { path: "js/banner/terminator2.2.min.js", type: "js", requires: ['fx'] });  
Qfast(false, 'widgets', function () {
	K.tabs({
		id: 'decoroll2',//焦点图包裹id  
		conId: "decoimg_a2",//大图域包裹id  
		tabId:"deconum2",//小圆点数字提示id
		tabTn:"a",
		conCn: '.decoimg_b2',//大图域配置class       
		auto: 1,//自动播放 1或0
		effect: 'fade',//效果配置
		eType: 'mouseover',// 鼠标事件
		pageBt:true,//是否有按钮切换页码
		bns: ['.prev', '.next'],//前后按钮配置class                          
		interval: 3000// 停顿时间  
	}) 
}) 
</script>
<div id="decoroll2" class="imgfocus">

	<div id="decoimg_a2" class="imgbox">
		<div class="decoimg_b2"><img src="../images/1.jpg"></a></div>
		<div class="decoimg_b2"><img src="../images/2.jpg"></a></div>
		<div class="decoimg_b2"><img src="../images/3.jpg"></a></div>
		<div class="decoimg_b2"><img src="../images/4.jpg"></a></div>
	</div>
	
	<ul id="deconum2" class="num_a2">
		<li><a href="javascript:void(0)" hidefocus="true" target="_self"></a></li>
		<li><a href="javascript:void(0)" hidefocus="true" target="_self"></a></li>
		<li><a href="javascript:void(0)" hidefocus="true" target="_self"></a></li>
		<li><a href="javascript:void(0)" hidefocus="true" target="_self"></a></li>
	</ul>
	
</div>
    <iframe style="padding: 0px; width: 100%; height: 100%;" src='/goods/BookServlet?method=findByCategory&cid=5F79D0D246AD4216AC04E9C5FAB3199E'></iframe>
    
  </body>
</html>
