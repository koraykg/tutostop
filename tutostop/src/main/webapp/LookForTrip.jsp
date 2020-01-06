<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Yolculuk Ara</title>
</head>
<body>
	<div class="container" style="margin-top: 20px;">
		<div class="row">
			<div class="col-lg-4"
				style="border: 2px solid red; border-radius: 25px;">
				<div
					style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro; border-radius: 25px; margin-top: 10px">
					<h3 align="center">Find a Trip</h3>
				</div>
				<form action="/ShowTripsServlet" method="POST">
					<div style="margin-bottom: 20px;">

						<span>
							<div class="form-group">
								<label for="formGroupExampleInput"> </label> <input
									name="staloc" type="text" class="form-control"
									id="formGroupExampleInput" placeholder="Begining Point"
									size="12" required>
							</div>
						</span>

						<div style="margin-bottom: 20px;">
							<span>
								<div class="form-group">
									<label for="formGroupExampleInput"> </label> <input
										name="finloc" type="text" class="form-control"
										id="formGroupExampleInput" placeholder="End Point" required>
								</div>
							</span>
						</div>
						<div style="margin-bottom: 20px;">
							<span>
								<div class="form-group">
									<label for="formGroupExampleInput"> </label> <input
										name="tripdatetime" type="datetime-local" class="form-control"
										id="datetimepicker1" placeholder="Trip Date"  required>
								</div>
							</span>
						</div>
						<div style="margin-bottom: 10px;">
							<span >
								<div class="form-group ">
									<label for="formGroupExampleInput"> </label> <input
										name="PassengerBaggage" type="text" class="form-control"
										id="formGroupExampleInput" placeholder="Baggage Checkout"
										pattern="loaded|handbag"
										list="choices" autocomplete="on" required>
									<datalist id="choices" class="doseinput">
										<option value="loaded">
										<option value="handbag">
									</datalist>
								</div>
							</span>
						</div>
						<div style="margin-bottom: 20px;">
							<span>
								<div class="form-group">
									<label for="formGroupExampleInput"> </label> <input
										name="PossibleBoardingPoint" type="text" class="form-control"
										id="formGroupExampleInput" placeholder="Possible Boarding Point" required>
								</div>
							</span>
						</div>
						<div style="margin-bottom: 10px;">
							<button type="submit" class="btn btn-primary btn-sm" value="Yolculuk Ara">Find Trip</button>
							<button type="reset" class="btn btn-danger btn-sm" value="Formu Temizle">Clean Form</button>
							<button type="button" class="btn btn-success btn-sm" value="Yolculuk Ekle">
								<a style="text-decoration: none;" href="TripAnnouncement.jsp"><font color="white">Add Trip</font></a>
							</button>
							<button type="button" class="btn btn-secondary btn-sm"
								value="Ana Sayfa">
								<a style="text-decoration: none;" href="WelcomeUser.jsp"><font
									color="white">Home Page</font></a>
							</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-lg-4"></div>
			<div class="col-lg-4"></div>
		</div>
	</div>
</body>
</html>



