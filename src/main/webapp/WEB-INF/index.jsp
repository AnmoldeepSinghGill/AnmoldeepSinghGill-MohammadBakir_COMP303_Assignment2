<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!--
  Submitted By: Anmoldeep Singh Gill, Mohammad Bakir
  Student Number: 301044883, 300987420
  Submission date: 12th March 2021
  -->

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Sign In</title>
<meta name="description" content="">

<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath}/css/bootstrap.min.css.map"
	rel="stylesheet">
</head>
<body>
	<div class="card-container">
		<div class="row navbar-custom">
			<div class="col-4" style="align-self: center;">
				<h3><a href="/" style="color: black; text-decoration: none;">CENTENNIAL HOTEL</a></h3>
			</div>
			<div class="col-2 navbar-columns text-right">
				<h5><a href="/searchRooms">Book Rooms</a></h5>
			</div>
			<div class="col-4 navbar-columns">
				<h5><a href="/showReservations">View Your Booked Rooms</a></h5>
			</div>
			<div class="col-1 navbar-columns">
				<a class="btn btn-danger" href="logout">Logout</a>
			</div>
    		<div class="col-1">
			<a href="/profile"><img id="profile-icon" style="margin-top: 13px;"
							src="/img/profileIcon.png"></a>
			</div>
		</div>
		<c:if test="${error != null}">
			<p class="alert alert-danger">${error}</p>
		</c:if>
		<div class="row justify-content-center row-padding">
			<h1>Sign In</h1>
		</div>
		<form action="signIn" method="POST">
			<div class="row row-padding">
				<label for="email" class="col-3 col-form-label">Email:</label>
				<div class="col-sm-9">
					<input id="email" name="email" class="form-control" />
				</div>
			</div>
			<div class="row row-padding">
				<label for="password" class="col-3 col-form-label">Password:</label>
				<div class="col-sm-9">
					<input id="password" type="password" name="password"
						class="form-control" />
				</div>
			</div>
			<div class="row justify-content-center row-padding">
				<button type="submit" class="btn btn-success">Sign In</button>
			</div>
			<div class="row justify-content-center">
				<a href="/signUp">Don't Have a Account? Sign Up</a>
			</div>
		</form>
	</div>
</body>
</html>