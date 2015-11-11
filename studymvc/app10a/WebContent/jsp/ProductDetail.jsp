<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@IMPORT url("css/main.css");</style>
<title>Save Product</title>
</head>
<body>
	<div id="global">
		<h4>The product has been saved</h4>
		<p>
		<h5>Details:</h5>
		Product Name: ${prodct.name}<br>
		Product Description: ${prodct.description}<br>
		Product Price: $${prodct.price}<br>
		<p>
	</div>
</body>
</html>