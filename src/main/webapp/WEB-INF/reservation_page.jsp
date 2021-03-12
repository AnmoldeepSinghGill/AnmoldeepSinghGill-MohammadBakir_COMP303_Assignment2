<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation Page</title>
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
		<div class="container-fluid text-center">
			<div class="row">
				<div class="col-2"></div>
				<div class="col-8 justify-content-center">
					<h1>Hotel Reservation Page</h1>
				</div>
				<div class="col-2">
					<a href="/profile"><img id="profile-icon"
						src="/img/profileIcon.png"></a>
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<h2>Accommodations</h2>
				</div>
			</div>
			<c:forEach items="${ rooms }" var="room">

				<div class="card" style="width: 725px;">
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
								<form action="bookReservation" method="POST">
									<input type="hidden" value="${ room.roomId }" name="id">
									<input type="hidden" value="${ room.price }" name="price">
									<div class="row" style="margin-top: 25px;">
										<div class="col-5 text-left label-bold"
											style="margin-top: 5px;">Number of Nights:</div>
										<div class="col-4 text-left">
											<select name="numberOfNights" class="form-control" required>
												<option value="1">1</option>
												<option value="2">2</option>
												<option value="3">3</option>
												<option value="4">4</option>
												<option value="5">5</option>
											</select>
										</div>
									</div>
									<div class="row">
										<div class="col-5 label-bold" style="margin-top: 5px;">Number
											of Guests:</div>
										<div class="col-4">
											<input type="number" name="numberOfGuests"
												class="form-control" required />
										</div>
									</div>
									<div class="row justify-content-center"
										style="margin-top: 20px;">
										<button type="submit" class="btn btn-success">Book
											Room</button>
									</div>
								</form>
							</div>
						</div>
						<div class="col-sm-5">
							<img class="card-img"
								src="/img/HotelRooms/${ room.getRoomImage() }">
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</body>
</html>