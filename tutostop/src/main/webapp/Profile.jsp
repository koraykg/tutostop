<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-color: ccff99;
}
</style>
</head>
<body>
	<div class="container-fluid" >
		<div class="row">
			<h3 class="p-3">TUTOSTOP PROFILE</h3>
		</div>
		<div class="row">
			<p class="p-3">
				Welcome to your profile Dear
				<%
				out.println(session.getAttribute("username"));
			%>
			</p>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-2"
					style="border-radius: 25px; border: 5px solid #ffffff; background: #e6f7ff; padding: 10px; margin-top: 20px;">
					<div
						style="font-weight: bold; background-color: gainsboro; border: 1px solid gainsboro; border-radius: 25px;">
						<h3 align="center"
							style="font: 20px arial, sans-serif; margin-top: 5px">
							Profil Info</h3>
					</div>

				</div>
				<div class="col-lg-5"
					style="border-radius: 25px; border: 5px solid #ffffff; background: #e6f7ff; padding: 10px; margin-top: 20px;">
					<div
						style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro; border-radius: 25px;">
						<h3 align="center"
							style="font: 20px arial, sans-serif; margin-top: 5px">@Driver's Seat</h3>
					</div>
					<form action="/Profile" method="GET">
					<table class="table">
						<thead>
							<th scope="col">Start</th>
							<th scope="col">Finish</th>
							<th scope="col">Trip Date</th>
							<th scope="col">Price</th>
						</thead>
						<tbody>
							<c:forEach items="${propertyList}" var="propertyAllList">
								<tr>
									<td>${propertyAllList.startLocBean}</td>
									<td>${propertyAllList.finLocBean}</td>
									<td>${propertyAllList.tripTimeBean}</td>
									<td>${propertyAllList.priceBean}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
				<div class="col-lg-5"
					style="border-radius: 25px; border: 5px solid #ffffff; background: #e6f7ff; padding: 10px; margin-top: 20px;">
					<div
						style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro; border-radius: 25px;">
						<h3 align="center"
							style="font: 20px arial, sans-serif; margin-top: 5px">@Passenger's Seat</h3>
					</div>
					<form action="/Profile" method="GET">
					<table class="table">
						<thead>
							<th scope="col">Start</th>
							<th scope="col">Finish</th>
							<th scope="col">Trip Date</th>
							<th scope="col">Price</th>
						</thead>
						<tbody>
							<c:forEach items="${passengerList}" var="passengerAllList">
								<tr>
									<td>${passengerAllList.startLocBean}</td>
									<td>${passengerAllList.finLocBean}</td>
									<td>${passengerAllList.tripTimeBean}</td>
									<td>${passengerAllList.priceBean}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
			</div>
		</div>
</body>
</html>

