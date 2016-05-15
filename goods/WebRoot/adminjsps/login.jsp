<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>管理员登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="<c:url value='/adminjsps/admin/css/login/bootstrap.min.css'/>">
	<style type="text/css">
	  * {
    margin: 0px ;
    padding: 0px ;
    text-decoration: none ;
    list-style: none;
    font-size: 12px ;
    font-family: Arial ;
}
.login_div{width:500px;height:500px; top: 50%; left: 50%; color: black; margin-top: -250px; margin-left: -250px; position:fixed;border-radius:10px; z-index: 9999; background: #FFFFFF; opacity: 0.7; box-shadow: 5px 5px 10px 5px rgba(0, 0, 0, 0.5);}
.login_div .login_title{text-align: center; font-size: 35px; margin-top: 30px; letter-spacing: 5px; font-weight: bold;}
.login_nav{margin-top: 140px;}
.login_username{text-align: right; height: 40px; line-height: 40px; font-size: 20px; font-weight: bold;}
.login_usernameInput{height: 40px; padding: 0px;margin-top:10px;}
#name{font-size: 12px; height: 40px; outline: 0px; border-radius: 10px; border: 1px solid #CCCCCC; width: 95%;}
.ok_gou{height: 40px; color: #5CB85C; font-size: 35px; display: none; text-align: center; border-radius: 10px;padding: 0px; line-height: 37px; border: 2px solid  #5CB85C;}
.error_cuo{height: 40px; color: red; font-size: 40px;  display: none; text-align: center; border-radius: 10px;padding: 0px; line-height: 30px; border: 2px solid red;}
.login_psdNav{margin-top: 30px;}
.login_psdNav .col-xs-4{text-align: left; height: 40px; line-height: 40px; font-size: 20px; font-weight: bold;}
.login_psdNav .col-xs-6{height: 40px; padding: 0px;}
#psd{height: 40px; font-size: 12px; outline: 0px; border-radius: 10px; border: 1px solid #CCCCCC; width: 95%; }
.login_btn_div{text-align: center; margin-top: 30px; padding-left: 50px;}
#login{outline: 0px; border: 0px; width: 200px; height: 40px; border-radius: 10px; color: white; font-weight: bold; font-size: 20px;}
.barter_btnDiv{text-align: center; position: absolute; bottom: 0; margin-bottom: 10px;}
.barter_btn{border: 0px; background: transparent; outline: 0px;}
.sub_btn{background: #d2a679;}
.sub_btn:hover{background: #31B0D5;}

.login_username{ text-align: left;}
.col-xs-4{margin-left: 80px;}
#adminname{height: 30px; width: 250px;}
#adminpwd{height: 30px; width: 250px;}
	</style>
	<script type="text/javascript" src="<c:url value='/jquery/jquery-1.5.1.js'/>"></script>
	<script type="text/javascript">
		function checkForm() {
			if(!$("#adminname").val()) {
				alert("管理员名称不能为空！");
				return false;
			}
			if(!$("#adminpwd").val()) {
				alert("管理员密码不能为空！");
				return false;
			}
			return true;
		}
	</script>
  </head>
  
  <body class="login_body" style="background: #009933">
<!--  <h1>管理员登录页面</h1>
<hr/>
  <p style="font-weight: 900; color: red">${msg }</p>
<form action="<c:url value='/AdminServlet'/>" method="post" onsubmit="return checkForm()" target="_top">
	<input type="hidden" name="method" value="login"/>
	管理员账户：<input type="text" name="adminname" value="" id="adminname"/><br/>
	密　　　码：<input type="password" name="adminpwd" id="adminpwd"/><br/>
	<input type="submit" value="进入后台"/>
</form> -->

<div class="login_div">
	<div class="col-xs-12 login_title">管理员登录</div>
	<form action="<c:url value='/AdminServlet'/>" class="login" method="post"  onsubmit="return checkForm()" target="_top">
	<input type="hidden" name="method" value="login"/>
		<div class="nav">
			<div class="nav login_nav">
				<div class="col-xs-4 login_username">
					账&nbsp;&nbsp;&nbsp;号:
					<input type="text" name="adminname" id="adminname" value="" placeholder="&nbsp;&nbsp;用户名"  onblur="javascript:ok_or_errorBylogin(this)" />
				</div>
			</div>
			<div class="nav login_psdNav">
				<div class="col-xs-4">
					密&nbsp;&nbsp;&nbsp;码:
					<input type="password" name="adminpwd" id="adminpwd" value="" placeholder="&nbsp;&nbsp;密码" onBlur="javascript:ok_or_errorBylogin(this)" />
				</div>
			</div>
			<div class="col-xs-12 login_btn_div">
				<input type="submit" class="sub_btn" value="登录" id="login"/>
			</div>
		</div>
	</form>
</div>
  </body>
</html>
