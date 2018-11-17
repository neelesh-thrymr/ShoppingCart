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
<link href="<c:url value="resources/css/uhome.css"/> " rel="stylesheet"/>
</head>
<body>
<div>
<a href="userhome">HOME</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="profile">PROFILE</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="totalitems">ITEMS LIST</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="citems">CART ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="uloginforms">LOGOUT</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="del">DELETE ACCOUNT</a>
</div>
<h3>${msg }</h3>
<br><br>

<h2 align="center">Items Are </h2>
<table roles="all" frame="box"   align="center" cellspacing="10px"cellpadding="12px" align="center">
<tr>
<th>Check<th>Id</th><th>Item Name</th><th>Price</th><th>Available Quantity</th><th>Required Quantity</th></tr>
<form:form action="cart" method="post" >
<c:forEach items="${titem}" var="itm">
<tr><td><input type="checkbox" name="ids" value="${itm.getId()}"></td><td>${itm.getId()}</td><td>${itm.getIname()}</td><td>${itm.getPrice()}</td>
<td>${itm.getQty()}</td><td><input type="number" min="0" name="${itm.getId()}qty" /></td> </tr>
</c:forEach>
<tr align="right" ><td colspan="5"><button type="submit">Add</button></td></tr>
</form:form>
</table>
</body>
</html>