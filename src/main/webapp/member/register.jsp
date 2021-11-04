<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>註冊頁面</title>
</head>
<body>

<h3>Register</h3>


<form action="<c:url value="/member/register.controller" />" method=post>

<table>
	
	<tr>
		<td>帳號 : </td>
		<td><input type="text" name="account" value="${param.account}"></td>
		<td><span class="error">${errors.account}</span></td>
	</tr>
	
	<tr>
		<td>密碼 : </td>
		<td><input type="password" name="password" value="${param.password}"></td>
		<td><span class="error">${errors.password}</span></td>
	</tr>
	
	<tr>
		<td>密碼確認 : </td>
		<td><input type="password" name="password2" value="${param.password2}"></td>
		<td><span class="error">${errors.password2}</span></td>
	</tr>
	
	<tr>
		<td>姓名 : </td>
		<td><input type="text" name="name" value="${param.name}"></td>
		<td><span class="error">${errors.name}</span></td>
	</tr>
	
	<tr>
		<td>地址 : </td>
		<td><input type="text" name="address" value="${param.address}"></td>
		<td><span class="error">${errors.address}</span></td>
	</tr>
	
	<tr>
		<td>電子信箱: </td>
		<td><input type="text" name="email" value="${param.email}"></td>
		<td><span class="error">${errors.email}</span></td>
	</tr>
	
	<tr>
		<td>生日 : </td>
		<td><input type="date" name="birth" value="${param.birth}"></td>
		<td><span class="error">${errors.birth}</span></td>
	</tr>
	
	<tr>
		<td>市話 : </td>
		<td><input type="text" name="tel" value="${param.tel}"></td>
		<td><span class="error">${errors.tel}</span></td>
	</tr>
	
	<tr>
		<td>手機 : </td>
		<td><input type="text" name="phone" value="${param.phone}"></td>
		<td><span class="error">${errors.phone}</span></td>
	</tr>
	
	
	
	<tr>
		<td>　</td>
		<td align="right"><input type="submit" name="register" value="sent"></td>
	</tr>
	
</table>
</form>


<h3><span class="error">${errors.action}</span></h3>
<c:if test="${not empty sent}">
<h3>註冊成功</h3>
<table border="1">
	<tr><td>帳號</td><td>${sent.account}</td></tr>
	<tr><td>姓名</td><td>${sent.name}</td></tr>
	<tr><td>電子信箱</td><td>${sent.email}</td></tr>	
</table>
</c:if>





</body>
</html>