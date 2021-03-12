<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Rooms</title>
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
						<h1>Hotel Reservation Page</h1>
					</div>
					<div class="col-2">
						<a href="/profile"><img id="profile-icon"
							src="/img/profileIcon.png"></a>
					</div>
				</div>
				<form action="searchRooms" method="POST">
				<div class="row">
					<div class="col-2 text-right label-aling label-bold">
						<label>Arrival Date:</label>
					</div>
					<div class="col-3">
						<input type="date" name="arrivalDate"class="form-control"
							required />
					</div>
					<div class="col-2 label-aling label-bold">
						<label>Departure Date:</label>
					</div>
					<div class="col-3">
						<input type="date" name="departureDate"class="form-control"
							required />
					</div>
					<div class="col-2"><button type="submit" class="btn btn-success">Search</button></div>
				</div>
				</form>
			</div>
	</div>
</body>
</html>