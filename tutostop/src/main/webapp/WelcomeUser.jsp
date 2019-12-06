<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ana Sayfa</title>
</head>
<body>

	<%
		request.getSession(false);
		if (session == null) {
	%>
	<a href="http://localhost:8080/loginDemo/home.jsp"> Home</a>
	<a href="http://localhost:8080/loginDemo/logout.jsp"> Logout</a>
	<%
		} else {
			// Already created.
	%>
	<%
		}
	%>
	<br>
	<br>
	<div class="container">
	<%
		out.println("Welcome to your Home Page Dear " + session.getAttribute("username"));
	%>
	</div>
	
	<div class="container">
		<div class="col-lg-3">
			<div
				style="border-radius: 25px; padding: 20px; background: #e6f7ff; padding: 20px; margin-top: 20px;">
				<a href="http://localhost:8080/LookForTrip.jsp"> Yolculuk Ara</a>
			</div>
			<div
				style="border-radius: 25px; padding: 20px; background: #e6f7ff; padding: 20px; margin-top: 20px;">
				<a href="http://localhost:8080/TripAnnouncement.jsp"> Yolculuk Ilani Ver</a>
			</div>
			<div
				style="border-radius: 25px; padding: 20px; background: #e6f7ff; padding: 20px; margin-top: 20px;">
				<form action="/Profile" method="GET">
				<button type="submit" class="btn btn-link" style="padding-left: 3px;">Profile Git</button>
				</form>
			</div>
			<div
				style="border-radius: 25px; padding: 20px; background: #e6f7ff; padding: 20px; margin-top: 20px;">
				<a href="http://localhost:8080/rules.jsp"> Kurallar Sayfasi</a>
			</div>
		</div>
		<div class="col-lg-5"></div>
		<div class="col-lg-4"></div>
	</div>
	