<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>

<script type="text/javascript">
function valid(){
var em=document.getElementById("emal");
var len=document.getElementBytId("pswd").length;

if(len!= 8)
alert(em.value);
}
</script>
<link href="<c:url value="resources/css/login.css"/> " rel="stylesheet"/>
<meta charset="UTF-8">
<title>User Login</title>
</head>
<body>

<h2><span>User LogIn</span></h2><br><br>
<form:form action="login" method="post" modelAttribute="u" align="center"><br>
<table roles="all" frame="box" align="center" cellspacing="10px"cellpadding="12px">
<tr>

<tr><td>Email</td><td>:</td><td><form:input path="email" id="emal" placeholder="ex: john@gmail.com" required="true"/></td></tr>
<tr><td>password</td><td>:</td><td><form:password path="password" id="pswd" placeholder="minimum 8 character" required="true"/></td></tr>
<tr><td colspan="3">
<form:button type="submit" onclick="valid()">LOG IN</form:button><br><br><a href="newusers">New User ?</a></td></tr>
</table>
</form:form>
<h3 align="center">${msg}</h3>
</body>
</html>