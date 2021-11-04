<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
</head>
<body>

<h3>Log In</h3>
<h3><span class="error">${errors.action}</span></h3>
<form action="<c:url value="/member/login.controller" />" method=post>
<table>
	<tr>
		<td>帳號 : </td>
		<td><input type="text" name="account" value="${param.useraccount}"></td>
		<td><span class="error">${errors.useraccount}</span></td>
	</tr>
	<tr>
		<td>密碼 : </td>
		<td><input type="password" name="password" value="${param.userpassword}"></td>
		<td><span class="error">${errors.userpassword}</span></td>
	</tr>
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" value="Login"></td>
	</tr>
</table>
</form>


</body>
</html>