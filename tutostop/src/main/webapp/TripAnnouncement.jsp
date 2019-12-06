<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trip Announcement</title>
</head>
<body>
	<div class="container" style="margin-top: 20px; ">
		<div class="row">
			<div class="col-lg-4" style="border: 2px solid green;  border-radius: 25px;">
			<div style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro;  border-radius: 25px; margin-top: 10px"><h3 align="center">Add a Trip</h3></div>
				<form action="/InsertTripServlet" method="POST">
					<div style="margin-bottom: 20px;">
						<span>
							<div class="form-group">
								<label for="formGroupExampleInput"  > </label> <input
									name="staloc" type="text" class="form-control"
									id="formGroupExampleInput" placeholder="Begining Point" required>
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
						<div style="margin-bottom: 20px;">
							<span>
								<div class="form-group">
									<label for="formGroupExampleInput"> </label> <input
										name="price" type="datetime-local" class="form-control"
										id="formGroupExampleInput" placeholder="Price" required>
								</div>
							</span>
						</div>
						<div style="margin-bottom: 10px;">
							<button type="submit" class="btn btn-primary btn-sm" value="Yolculuk Ekle">Add Trip</button>
							<button type="reset" class="btn btn-danger btn-sm" value="Formu Temizle">Clean Form</button>
							<button type="button" class="btn btn-success btn-sm" value="Yolculuk Ara"><a style="text-decoration: none;" href="LookForTrip.jsp" ><font color="white">Find Trip</font></a></button>
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



