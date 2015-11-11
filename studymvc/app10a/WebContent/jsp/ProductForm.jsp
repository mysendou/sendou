<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style type="text/css">@IMPORT url(css/main.css);</style>
<title>Input Product</title>
</head>
<body>
    <div id="global">
        <h3>Add a product</h3>
        <form action="product_save" method="post">
            <table>
                <tr><td>Product Name: </td><td><input type="text" name="name"/></td></tr>
                <tr><td>Product Description: </td><td><input type="text" name="description"/></td></tr>
                <tr><td>Product Price: </td><td><input type="text" name="price"/></td></tr>
                <tr><td><input type="reset"></td><td><input type="submit" name="Add Product"/></td></tr>
            </table>
        </form>
    </div>
</body>
</html>