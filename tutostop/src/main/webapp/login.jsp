<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title >Giris Sayfasi</title>
<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet">
<style>
.footer {
	position: absolute;
	bottom: 0;
	width: 100%;
	height: 60px;
	background-color: #f5f5f5;
}
</style>
</head>

<body>
	<div class="container">
		<div class="row">
			<div class="col-lg-10">
			</div>
			<div class="col-lg-2" style="border-radius: 25px; padding: 20px; background:  #e6f7ff; padding: 20px; margin-top: 20px;">
				<span>
					<form action="/LoginTutostop" method="POST">
						<div style="margin-bottom: 20px;">
							<span> 
								Name  <br><input name="username" type="text" size="12" />
							</span>
						</div>
						<div style="margin-bottom: 20px;">
							<span>
								Password  <input name="password" type="password" size="12" />
							</span>
						</div>
						<div style="margin-bottom: 10px;">
							<button type="submit" class="btn btn-primary btn-sm">Enter</button>
							<button type="button" class="btn btn-primary btn-sm" ><a style="text-decoration: none;" href="/RegistirationPage.jsp"><font color="white">Register</font></a></button>
						</div>
						</form>
				</span>
				<p style="font-size: 10px;">Forget password? Click here.</p>
			</div>
			
		</div>
	</div>

	<footer class="footer">
		<p>footer content</p>
	</footer>

	<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
	<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>

</body>
</html>
