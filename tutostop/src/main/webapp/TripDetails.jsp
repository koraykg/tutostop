<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Trip Details</title>
</head>
<body>
	<div class="container-fluid" >
		<div class="row">
			<h3 class="p-3">TUTOSTOP TRIPS DETAILS</h3>
		</div>
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-5"
					style="border-radius: 25px; border: 5px solid #ffffff; background: #e6f7ff; padding: 10px; margin-top: 20px;">
					<div
						style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro; border-radius: 25px;">
						<h3 align="center"
							style="font: 20px arial, sans-serif; margin-top: 5px">Detailed Trip Info</h3>
					</div>
					<form action="/TripDetails" method="GET">
					<table class="table">
						<thead>
							<th scope="col">Kod</th>
							<th scope="col">Start</th>
							<th scope="col">Finish</th>
							<th scope="col">Trip Date</th>
							<th scope="col">Price</th>
							<th scope="col">Owner</th>
							<th scope="col">Pass Number</th>
						</thead>
						<tbody>
							<c:forEach items="${propertyList}" var="propertyAllList">
								<tr>
									<td>${propertyAllList.tripuid}</td>
									<td>${propertyAllList.startLocBean}</td>
									<td>${propertyAllList.finLocBean}</td>
									<td>${propertyAllList.tripTimeBean}</td>
									<td>${propertyAllList.priceBean}</td>
									<td>${propertyAllList.tripOwnerBean}</td>
									<td align="center">${propertyAllList.totalPassengerBean}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
				<div class="col-lg-1"
					style="border-radius: 25px; border: 5px solid #ffffff; background: #e6f7ff; padding: 10px; margin-top: 20px;">
					<div
						style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro; border-radius: 25px;">
						<h3 align="center"
							style="font: 20px arial, sans-serif; margin-top: 5px">Goners</h3>
					</div>
					<form action="/TripDetails" method="GET">
					<table class="table">
						<thead>
							<th scope="col">Name</th>
						</thead>
						<tbody>
							<c:forEach items="${passengerList}" var="passengerAllList">
								<tr>
									<td>${passengerAllList.passenger}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					</form>
				</div>
				<div class="col-lg-6" style="border-radius: 25px; border: 5px solid #ffffff; background: #e6f7ff; padding: 10px; margin-top: 20px;">
					<div style="font-weight: bold; background-color: gainsboro; border: 2px solid gainsboro; border-radius: 25px;">
						<h3 align="center"
							style="font: 20px arial, sans-serif; margin-top: 5px">Photos</h3>
					</div>
					<!-- ${tripuid} -->
			        <form method="post" action="uploadServlet" enctype="multipart/form-data">
			            <table style="border-radius: 25% 25% 25% 25%; border: 2px solid #000000; margin-top: 10px; margin-left: 5px; ">
			                <tr>
			                    <td style="padding-top:10px;">Portrait Photo: </td>
			                    <td><input type="file" name="photo" size="50"/></td>
			                    <td><input type="hidden" name="tripuid" value="${tripuid}" /></td>
			                </tr>
			                <tr>
			                    <td colspan="2">
			                    	<br>
			                        <input type="submit" value="Save">
			                    </td>
			                </tr>
			            </table>
			        </form>
				</div>
			</div>
		</div>
</body>
</html>

