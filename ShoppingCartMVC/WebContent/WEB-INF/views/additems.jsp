<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
          <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="resources/css/additem.css"/> " rel="stylesheet"/>
<title>Insert title here</title>
</head>

<body>
<div>

<a href="ahome">HOME</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="items">SHOW ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="additems">ADD ITEMS</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="ditems">DELETE ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="aloginforms">LOGOUT</a>
</div><br><br>
<h2><span>New Item Registration</span></h2>

<form:form action="add" method="post" modelAttribute="ai" align="center"><br>

<table roles="all" frame="box"   align="center" cellspacing="10px"cellpadding="12px">
<tr>
<td>Id</td><td>:</td><td><form:input path="id"/></td></tr>
<tr><td>Item Name</td><td>:</td><td><form:input path="iname"/></td></tr>
<tr><td>Price</td><td>:</td><td><form:input path="price"/></td></tr>
<tr><td>Quantity</td><td>:</td><td><form:input path="qty"/></td></tr>
<tr><td colspan="3">
<form:button type="submit">Submit</form:button></td></tr>
</table>
</form:form>
</body>
</html>