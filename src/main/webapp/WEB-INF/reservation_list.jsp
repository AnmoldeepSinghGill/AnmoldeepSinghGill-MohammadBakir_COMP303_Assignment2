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
		style="max-width: 1000px; margin-bottom: 50px;">
		<div class="row justify-content-center">
			<h3>Your Reservations</h3>
		</div>
		<table class="table-responsive">
			<thead>
				<tr>
					<th>Reservation Id</th>
					<th>Room Type</th>
					<th>Arrival Date</th>
					<th>Departure Date</th>
					<th>Total Nights</th>
					<th>Total Guests</th>
					<th>Total Amount</th>
					<th colspan="2">Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ reservations }" var="reservation"
					varStatus="loop">
					<tr>
						<form
							action="editReservation?id=${ reservation.getReservationId() }"
							method="POST">
						<td>${ reservation.getReservationId() }</td>
						<td><select class="form-select">
								<c:forEach items="${ rooms }" var="room">
									<option value="${ room.getRoomId() }"
										<c:if test="${reservation.getRoomId() == room.getRoomId()}">selected=selected</c:if>>
										${ room.getRoomType() }</option>
								</c:forEach>
						</select></td>
						<td><input type="date"
							value="${ reservation.getArrivalDate() }" name="arrivalDate"
							class="form-control" required /></td>
						<td><input type="date"
							value="${ reservation.getDepartureDate() }" name="arrivalDate"
							class="form-control" required /></td>
						<td><input type="number"
							value="${ reservation.getTotalNights() }" name="totalNights"
							class="form-control" required /></td>
						<td><input type="number"
							value="${ reservation.getTotalGuests() }" name="totalGuests"
							class="form-control" required /></td>
						<td>$${ reservation.getTotalAmount() }</td>
						<td>
							<button class="btn btn-success">Update</button>

						</td>
						</form>
						<td>
							<form
								action="deleteReservation?id=${ reservation.getReservationId() }"
								method="POST">
								<button class="btn btn-danger">Delete</button>
							</form>
						</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>