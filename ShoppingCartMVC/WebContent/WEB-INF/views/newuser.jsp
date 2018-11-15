<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="resources/css/regform.css"/> " rel="stylesheet"/>
</head>
<body>

<h2><span>New User Registration</span></h2>
<form:form action="newuser" method="post" modelAttribute="nu" align="center"><br>
<table roles="all" frame="box"   align="center" cellspacing="10px"cellpadding="12px">
<tr>
<td>Name</td><td>:</td><td><form:input path="name"/></td></tr>
<tr><td>Email</td><td>:</td><td><form:input path="email"/></td></tr>
<tr><td>password</td><td>:</td><td><form:input path="password"/></td></tr>
<tr><td>Address</td><td>:</td><td><form:input path="address"/></td></tr>
<tr><td colspan="3">
<form:button type="submit">Submit</form:button></td></tr>
</table>
</form:form>
</body>
</html>