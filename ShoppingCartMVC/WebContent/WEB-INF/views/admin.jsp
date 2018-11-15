<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<link href="<c:url value="/resources/css/ahome.css"/>" rel="stylesheet"/>
<title>Insert title here</title>
</head>
<body>
<div>

<a href="ahome">HOME</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="items">SHOW ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="additems">ADD ITEMS</a>
&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="ditems">DELETE ITEMS</a>&nbsp;&nbsp;<span>|</span>&nbsp;&nbsp;<a href="aloginforms">LOGOUT</a>
</div>
<br><br>
<h1>${msg}</h1>
</body>
</html>