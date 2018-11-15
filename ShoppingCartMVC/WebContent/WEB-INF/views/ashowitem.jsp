<%@page import="org.shopping.model.ItemModel,java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="<c:url value="resources/css/ahome.css"/> " rel="stylesheet"/>
</head>
<body>
<div>
<a href="ahome">HOME</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="items">SHOW ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="additems">ADD ITEMS</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="ditems">DELETE ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="aloginforms">LOGOUT</a>
</div>
<br><br>
<h2 align="center">Items Are </h2>
<table roles="all" frame="box"   align="center" cellspacing="10px"cellpadding="12px" align="center">
<tr>
<th>Id</th><th>Item Name</th><th>Price</th><th>Quantity</th></tr>


<c:forEach items="${imodel}" var="itm">
<tr><td>${itm.getId()}</td><td>${itm.getIname()}</td><td>${itm.getPrice()}</td><td>${itm.getQty()}</td></tr>
</c:forEach>
</table>
</body>
</html>
