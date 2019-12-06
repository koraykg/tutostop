<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>TUTOSTOP Registration Form</title>
</head>
<body>
	<div class="container">
	<h1>Register Form</h1>
	<div class="col-lg-3" style="border-radius: 25px; padding: 20px; background: #e6f7ff; padding: 20px; margin-top: 20px;">
		<span>
			<form action="/Register" method="POST">
				<div style="margin-bottom: 10px;">
					<span> Name <br><input name="name" type="text" required /></span>
				</div>
				<div style="margin-bottom: 10px;">
					<span> Last Name <br><input name="last_name" type="text" required /></span>
				</div>
				<div style="margin-bottom: 20px;">
					<span> User Name <br><input name="username" type="text" required /></span>
				</div>
				<div style="margin-bottom: 20px;">
					<span> Password <br><input name="password" type="text" required /></span>
				</div>
				<div style="margin-bottom: 20px;">
					<span> Address <br><input name="address" type="text" required /></span>
				</div>
				<div style="margin-bottom: 20px;">
					<span> Contact No <br><input name="contact" type="text" required /></span>
				</div>
				<div style="margin-bottom: 10px;">
					<button type="submit" class="btn btn-primary btn-sm">Register</button>
					<button type="button" class="btn btn-primary btn-sm" ><a style="text-decoration: none;" href="login.jsp" ><font color="white">Login Page</font></a></button>
				</div>
			</form>
		</span>
	</div>
	<div class="col-lg-6">
	</div>
	</div>
	
	<footer class="footer">
	<p>footer content</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>
