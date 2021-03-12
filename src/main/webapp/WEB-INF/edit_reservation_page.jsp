<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Reservation</title>
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
		<div class="container-fluid text-center">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8 justify-content-center">
					<h1>Edit Reservation</h1>
				</div>
				<div class="col-2">
					<a href="/profile"><img id="profile-icon"
						src="/img/profileIcon.png"></a>
				</div>
			</div>
			<div class="row">
				<div class="col-2 text-right label-aling label-bold">
					<label>Arrival Date:</label>
				</div>
				<div class="col-3">${ reservation.getArrivalDate() }</div>
				<div class="col-1"></div>
				<div class="col-2 label-aling label-bold">
					<label>Departure Date:</label>
				</div>
				<div class="col-3">${ reservation.getDepartureDate() }</div>
				<div class="col-1"></div>
			</div>

			<div class="row">
				<div class="col-5 label-bold" style="margin-top: 5px;">Number
					of Nights:</div>
				<div class="col-4">
					<input type="number" value="${ reservation.getTotalNights() }" name="numberOfNights"
						class="form-control" required />
				</div>
			</div>

			<div class="row">
				<div class="col-5 label-bold" style="margin-top: 5px;">Number
					of Guests:</div>
				<div class="col-4">
					<input type="number" value="${ reservation.getTotalGuests() }" name="numberOfGuests"
						class="form-control" required />
				</div>
			</div>
			<c:forEach items="${ rooms }" var="room">
				<form action="bookReservation" method="POST">
					<div class="card" style="width: 930px;">
						<div class="row no-gutters">
							<div class="col-sm-7">
								<div class="card-body">
									<h5 class="card-title">
										<label class="label-bold">Room Type:</label> ${ room.getRoomType() }
									</h5>
									<p class="card-text">
										<label class="label-bold">Price:</label>
										$${room.getPrice()}/Night
									</p>
									<input type="hidden" value="${ room.getRoomId() }" name="id">
									<input type="hidden" value="${ room.getPrice() }" name="price">
									<div class="row" style="margin-top: 25px;">
										<div class="col-4 text-left label-bold">
											<input type="radio" name="roomSelection"
												value="${ room.getRoomId() }"
												<c:if test="${reservation.getRoomId() == room.getRoomId()}">checked="checked"</c:if>>
										</div>
										<div class="col-4"></div>
										<div class="col-4"></div>
									</div>
								</div>
							</div>
							<div class="col-sm-5">
								<img class="card-img"
									src="/img/HotelRooms/${ room.getRoomImage() }">
							</div>
						</div>
					</div>
				</form>
			</c:forEach>
		</div>
	</div>
</body>
</html>