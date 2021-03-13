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
		<c:forEach items="${ reservations }" var="reservation">
			<div class="card" style="width: 930px; padding: 30px;">
			<div class="row">
			<div class="col-7">
				<div class="row no-gutters">
					<div class="col-5 label-bold text-right-label">Reservation Id:</div>
					<div class="col-4">${ reservation.getReservationId() }</div>
				</div>
				<form
					action="editReservation?id=${ reservation.getReservationId() }"
					method="POST">
					<div class="row no-gutters">
						<div class="col-5 label-bold text-right-label">Room Type:</div>
						<div class="col-4">
							<select name="roomId" class="form-select">
								<c:forEach items="${ rooms }" var="room">
									<option value="${ room.getRoomId() }"
										<c:if test="${reservation.getRoomId() == room.getRoomId()}">selected=selected</c:if>>
										${ room.getRoomType() }</option>
								</c:forEach>
							</select>
						</div>
					</div>

					<div class="row no-gutters">
						<div class="col-5 label-bold text-right-label">Arrival Date:</div>
						<div class="col-4">
							<input type="date" value="${ reservation.getArrivalDate() }"
								name="arrivalDate" class="form-control" required />
						</div>
					</div>

					<div class="row no-gutters">
						<div class="col-5 label-bold text-right-label">Departure Date:</div>
						<div class="col-4">
							<input type="date" value="${ reservation.getDepartureDate() }"
								name="departureDate" class="form-control" required />
						</div>
					</div>

					<div class="row no-gutters">
						<div class="col-5 label-bold text-right-label">Number of Nights:</div>
						<div class="col-4">
							<input type="number" value="${ reservation.getTotalNights() }"
								name="totalNights" class="form-control" required />
						</div>
					</div>

					<div class="row no-gutters">
						<div class="col-5 label-bold text-right-label">Number of Guests:</div>
						<div class="col-4">
							<input type="number" value="${ reservation.getTotalGuests() }"
								name="totalGuests" class="form-control" required />
						</div>
					</div>

					<div class="row no-gutters">
						<div class="col-5 label-bold text-right-label">Total price:</div>
						<div class="col-4">$${ reservation.getTotalAmount() }</div>
					</div>

					<div class="row no-gutters justify-content-center">
						<button class="btn btn-success" type="submit">Update</button>
					</div>


				</form>


				<form
					action="deleteReservation?id=${ reservation.getReservationId() }"
					method="POST">
					<div class="row no-gutters justify-content-center">
						<button class="btn btn-danger" type="submit">Delete</button>
					</div>

				</form>
				</div>
				<div class="col-5">
								<img class="reservationListImages"
									src="/img/HotelRooms/${ reservation.getRoom().getRoomImage() }">
				</div>
				</div>
			</div>
		</c:forEach>
	</div>
</body>
</html>