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
			<div class="container-fluid text-center">
				<div class="row">
					<div class="col-2"></div>
					<div class="col-8 justify-content-center">
						<h1>Search Rooms</h1>
					</div>
							<c:if test="${error != null}">
			<p class="alert alert-danger">${error}</p>
		</c:if>
					<div class="col-2">
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