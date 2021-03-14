<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	<!--
  Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
  Student Number: 301044883, 300987420
  Submission date: 12th March 2021
  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Successful</title>
<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css.map"
	rel="stylesheet">
</head>
<body>
	<div class="card-container" style="max-width: 630px;">
		<div class="row navbar-custom">
			<div class="col-4" style="align-self: center;">
				<h3><a href="/" style="color: black; text-decoration: none;">CENTENNIAL HOTEL</a></h3>
			</div>
			<div class="col-2 navbar-columns text-right">
				<h5>
					<a href="/searchRooms">Book Rooms</a>
				</h5>
			</div>
			<div class="col-4 navbar-columns">
				<h5>
					<a href="/showReservations">View Your Booked Rooms</a>
				</h5>
			</div>
			<div class="col-2">
				<a href="/profile"><img id="profile-icon"
					style="margin-top: 13px;" src="/img/profileIcon.png"></a>
			</div>
		</div>
		<div class="row justify-content-center">
			<h1>Payment Successful</h1>
		</div>
		<div class="row justify-content-center">
			<a class="btn btn-success" href="showReservations">Show All
				Reservations</a>
		</div>
	</div>
</body>
</html>