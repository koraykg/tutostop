<%@ include file="../common/header.jspf"%>
<%@ include file="../common/navigation.jspf"%>
<%@page import="org.apache.log4j.Logger"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% Logger logger = Logger.getLogger(this.getClass().getName());%>
	<div class="container">
		<div class="row">
			<h3 class="p-3">TUTOSTOP SEARCH RESULT</h3>
		</div>
		${activelyAssign}

		<table class="table" style="width: 750px">
			<thead>
				<th scope="col">Kalkis Yeri</th>
				<th scope="col">Varis Yeri</th>
				<th scope="col">Kalkis Zamani</th>
				<th scope="col">Ucret</th>
			</thead>
			<tbody>
				<c:forEach items="${propertyList}" var="propertyAllList">
					<tr>
						<td>${propertyAllList.startLocBean}</td>
						<td>${propertyAllList.finLocBean}</td>
						<td>${propertyAllList.tripTimeBean}</td>
						<td>${propertyAllList.priceBean}</td>
						<td>${propertyAllList.tripuid}</td>
						
						<c:set var="protripuid" value="${propertyAllList.tripuid}" />
						<c:set var="reserveflag" value="true"/>
						
						<c:forEach items="${activeList}" var="activeAllList">
							<c:set var="activetripuid" value="${activeAllList.tripuid}" />
							<% System.out.println( "activeList trip uid = " + pageContext.findAttribute("activetripuid") ); %>
							<% System.out.println( "propertyList trip uid = " + pageContext.findAttribute("protripuid") ); %>
							<c:choose>
								<c:when test="${protripuid == activetripuid}">
									<c:set var="reserveflag" value="false"/>
									<% String message = "reserveflag = " + pageContext.findAttribute("reserveflag"); logger.info( message );%>
								</c:when>
							</c:choose>	
						</c:forEach>
						
						<% System.out.println( "reserveflag degeri " + pageContext.findAttribute("reserveflag") ); %>
						
						<c:choose>
							<c:when test="${reserveflag eq 'false'}">
								<td><a href="/Unreserve?tripuid=${propertyAllList.tripuid}">UnReserve</a></td>
							</c:when>
							<c:otherwise>
								<td><a href="/Reserve?tripuid=${propertyAllList.tripuid}">Reserve</a></td>
							</c:otherwise>
						</c:choose>			
						</tr>
					
				</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="container">
		<a class="btn btn-success" href="/TripAnnouncement.jsp">Add New Trip</a> 
		<a class="btn btn-success" href="/LookForTrip.jsp">Find Trip</a>
	</div>
	<%@ include file="../common/footer.jspf"%>
</body>
</html>

<!-- <td ><div
								style="border-radius: 5px; background: #ffc107; width: 90px;">
								<form action="/Reserve.jsp" method="GET">
									&nbsp;&nbsp;
									<button type="button" class="btn btn-link" value="Open popup" onclick="window.open('http://localhost:8080/ReserveServlet','reserve','height=210, width=220, top=400,left=400')"
										style="padding-left: 3px;">Reserve</button>
								</form>
							</div></td> -->