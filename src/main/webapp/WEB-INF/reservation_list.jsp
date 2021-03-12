<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation List</title>
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css.map"
	rel="stylesheet">
</head>
<body>
	<div class="card-container"
		style="max-width: 800px; margin-bottom: 50px;">
		<table class="table">
			<thead>
				<tr>
					<th>Room Type</th>
					<th>Total Nights</th>
					<th>Total Guests</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ reservations }" var="reservation">
					<tr>
						<td>${ reservation.totalNights }</td>
						<td>${ reservation.totalGuests }</td>
						<td>${ reservation.totalAmount }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>