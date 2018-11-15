<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserProfile</title>
<link href="<c:url value="resources/css/uhome.css"/> " rel="stylesheet"/>
</head>
<body>
<div>

<a href="userhome">HOME</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="profile">PROFILE</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="totalitems">ITEMS LIST</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="citems">CART ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="uloginforms">LOGOUT</a>
</div>
<br>
<h2 align="center">Profile</h2><br>
<table roles="all" frame="box"   align="center" cellspacing="10px"cellpadding="12px">
<tr>
<td>Name</td><td>:</td><td>${user.getName()}</td></tr>
<tr><td>Email</td><td>:</td><td>${user.getEmail()}</td></tr>
<tr><td>password</td><td>:</td><td>${user.getPassword()}</td></tr>
<tr><td>Address</td><td>:</td><td>${user.getAddress()}</td></tr>
<tr><td colspan="3">
</table>


</body>
</html>