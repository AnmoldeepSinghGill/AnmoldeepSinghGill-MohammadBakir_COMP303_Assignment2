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
<title>Profile Page</title>

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
		<div class="row justify-content-center row-padding">
			<h1>Profile</h1>
		</div>
		<form action="profile" method="POST">
			<div class="row row-padding">
				<div class="col-4 text-right label-aling label-bold">
					<label>Email <span class="required-label">*</span></label>
				</div>
				<div class="col-8">
					<input type="text" value="${ email }" name="email"
						placeholder="example@email.com" class="form-control"
						required="required" disabled />
				</div>
			</div>
			<div class="row row-padding">

				<div class="col-4 text-right label-aling label-bold">
					<label>Full Name <span class="required-label">*</span></label>
				</div>
				<div class="col-4">
					<input type="text" name="firstName" value="${ firstName }"
						aria-describedby="firstNameHelp" class="form-control"
						required="required" /> <small id="firstNameHelp"
						class="form-text text-muted">First Name</small>
				</div>
				<div class="col-4">
					<input type="text" name="lastName" aria-describedby="lastNameHelp"
						class="form-control" required="required" value="${ lastName }" />
					<small id="lastNameHelp" class="form-text text-muted">Last
						Name</small>
				</div>
			</div>
			<div class="row row-padding">
				<div class="col-4 text-right label-aling label-bold">
					<label>Phone Number <span class="required-label">*</span></label>
				</div>
				<div class="col-8">
					<input type="number" name="phoneNumber"
						aria-describedby="phoneNumberHelp" class="form-control"
						required="required" value="${ phoneNumber }" /> <small
						id="phoneNumberHelp" class="form-text text-muted">Phone
						Number</small>
				</div>
			</div>
			<div class="row row-padding">
				<div class="col-4 text-right label-aling label-bold">
					<label>Address <span class="required-label">*</span></label>
				</div>
				<div class="col-8">
					<input type="text" name="address"
						aria-describedby="streetAddressHelp" class="form-control"
						required="required" value="${ address }" /> <small
						id="streetAddressHelp" class="form-text text-muted">Street
						Address</small>
				</div>
			</div>
			<div class="row row-padding">
				<div class="col-4"></div>
				<div class="col-4">
					<input type="text" name="city" aria-describedby="cityHelp"
						class="form-control" required="required" value="${ city }" /> <small
						id="cityHelp" class="form-text text-muted">City</small>
				</div>
				<div class="col-4">
					<input type="text" name="state" aria-describedby="stateHelp"
						value="${ state }" class="form-control" required="required" /> <small
						id="stateHelp" class="form-text text-muted">State /
						Province</small>
				</div>
			</div>
			<div class="row row-padding">
				<div class="col-4"></div>
				<div class="col-4">
					<input type="text" name="postalCode" value="${ postalCode }"
						aria-describedby="postalCodeHelp" class="form-control"
						required="required" /> <small id="postalCodeHelp"
						class="form-text text-muted">Postal / Zip Code</small>
				</div>
				<div class="col-4">
					<select name="country" class="form-control"
						aria-describedby="countryHelp" required="required">
						<option value="Canada">Canada</option>
						<option value="USA">USA</option>
						<option value="United Kingdom">United Kingdom</option>
						<option value="Australia">Australia</option>
					</select> <small id="countryHelp" class="form-text text-muted">Country</small>
				</div>
			</div>
			<div class="row row-padding justify-content-center">
				<button class="btn btn-success" type="submit">Update
					Profile</button>
			</div>
		</form>
	</div>
</body>
</html>