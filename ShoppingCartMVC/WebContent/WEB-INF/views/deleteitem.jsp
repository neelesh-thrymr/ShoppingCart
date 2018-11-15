<%@page import="org.shopping.model.ItemModel,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
       <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="resources/css/delitem.css"/> " rel="stylesheet"/>
<link href="<c:url value="resources/css/ahome.css"/> " rel="stylesheet"/>
</head>
<body>
<div>
<a href="ahome">HOME</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="items">SHOW ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="additems">ADD ITEMS</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="ditems">DELETE ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="loginforms">LOGOUT</a>
</div>
<br><br>
<h2 align="center">Items Are </h2>

<table border="1" roles="all" frame="box"  align="center" cellspacing="10px"cellpadding="12px" align="center">
<tr>
<th>Id</th><th>Item Name</th><th>Price</th><th>Quantity</th><th>Action</tr>
<form:form action="del" modelAttribute="data">
<c:forEach items="${imodel}" var="itm">
<tr><td>${itm.getId()}</td><td>${itm.getIname()}</td><td>${itm.getPrice()}</td><td>${itm.getQty()}</td><td>
<button name="id" value="${itm.getId()} " type="submit" >DELETE</button></td></tr>
</c:forEach>
</form:form>
</td></tr>
</table>

</body>
</html>