<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<div class="card-container" style="max-width: 700px;">
		<div class="container-fluid text-center">
			<h1>Hotel Reservation Page</h1>
			<form method="post" action="showReservation">
				<!-- <div class="row">
					<div class="col-4 text-right label-aling label-bold">
						<label>Full Name <span class="required-label">*</span></label>
					</div>
					<div class="col-4">
						<input type="text"  name="firstName"
						aria-describedby="firstNameHelp" class="form-control" required="required" />
						<small id="firstNameHelp" class="form-text text-muted">First Name</small>
					</div>
					<div class="col-4">
						<input type="text" name="lastName"
						aria-describedby="lastNameHelp" class="form-control" required="required" />
						<small id="lastNameHelp" class="form-text text-muted">Last Name</small>
					</div>
				</div>
				<div class="row">
					<div class="col-4 text-right label-aling label-bold">
						<label>Phone Number <span class="required-label">*</span></label>
					</div>
					<div class="col-4">
						<input type="number" name="areaCode"
						aria-describedby="areaCodeHelp" class="form-control" required="required" />
						<small id="areaCodeHelp" class="form-text text-muted">Area Code</small>
					</div>
					<div class="col-4">
						<input type="number" name="phoneNumber"
						aria-describedby="phoneNumberHelp" class="form-control" required="required" />
						<small id="phoneNumberHelp" class="form-text text-muted">Phone Number</small>
					</div>
				</div>
				<div class="row">
					<div class="col-4 text-right label-aling label-bold">
						<label>Email <span class="required-label">*</span></label>
					</div>
					<div class="col-8">
						<input type="text" name="email"
						placeholder="example@email.com" 
						class="form-control" required="required" />
					</div>
				</div>
				<div class="row">
					<div class="col-4 text-right label-aling label-bold">
						<label>Address <span class="required-label">*</span></label>
					</div>
					<div class="col-8">
						<input type="text" name="streetAddress"
						aria-describedby="streetAddressHelp" class="form-control" required="required" />
						<small id="streetAddressHelp" class="form-text text-muted">Street Address</small>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
					</div>
					<div class="col-8">
						<input type="text" name="streetAddressLine2"
						aria-describedby="streetAddressLine2Help" class="form-control"/>
						<small id="streetAddressLine2Help" class="form-text text-muted">Street Address Line 2</small>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
					</div>
					<div class="col-4">
						<input type="text" name="city"
						aria-describedby="cityHelp" class="form-control" required="required" />
						<small id="cityHelp" class="form-text text-muted">City</small>
					</div>
					<div class="col-4">
						<input type="text" name="state"
						aria-describedby="stateHelp" class="form-control" required="required" />
						<small id="stateHelp" class="form-text text-muted">State / Province</small>
					</div>
				</div>
				<div class="row">
					<div class="col-4">
					</div>
					<div class="col-4">
						<input type="text" name="postalCode"
						aria-describedby="postalCodeHelp" class="form-control" required="required" />
						<small id="postalCodeHelp" class="form-text text-muted">Postal / Zip Code</small>
					</div>
					<div class="col-4">
						<select name="country" class="form-control" aria-describedby="countryHelp" required="required">
							<option value="Canada">Canada</option>
							<option value="USA">USA</option>
							<option value="United Kingdom">United Kingdom</option>
							<option value="Australia">Australia</option>
						</select>
						<small id="countryHelp" class="form-text text-muted">Country</small>
					</div>
				</div> -->
				<div class="row">
					<div class="col-12">
						<h2>Accommodations</h2>
					</div>
				</div>
				<div class="row">
					<div class="col-2"></div>
					<div class="col-4 label-bold">Arrival - Date</div>
					<div class="col-4 label-bold">Departure - Date</div>
					<div class="col-2"></div>
				</div>
				<div class="row">
					<div class="col-2"></div>
					<div class="col-4 text-right">
						<input type="date" name="arrivalDate" class="form-control"
							required />
					</div>
					<div class="col-4">
						<input type="date" name="departureDate" class="form-control"
							required />
					</div>
					<div class="col-2"></div>
				</div>
				<c:forEach items="${ rooms }" var="room">
					<div class="row">
					<input type="radio" name="roomTypesAndPrice" id="mountainView"
						class="form-check-input" value="100" required checked="checked" />
					<label for="mountainView" class="form-check-label">${room.getPrice()}/Night
						- ${ room.getRoomType() } ${ room.getPrice() }</label>
						<img src="/img/HotelRooms/${ room.getRoomImage() }">
				</div>
				</c:forEach>
				<!-- <div class="row">
					<div class="col-4 label-aling">
						<label for="mountainViewNumberOfNights">Number of Nights:
						</label>
					</div>
					<div class="col-8">
						<select id="mountainViewNumberOfNights"
							name="mountainViewNumberOfNights" class="form-control">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
							<option value="5">5</option>
						</select>
					</div>
				</div>-->
				<div class="row" style="margin-top: 25px;">
					<div class="col-4 text-left label-bold">Number of Adults</div>
					<div class="col-8 text-left label-bold">Number of Kids (If
						there are any)</div>
				</div>
				<div class="row">
					<div class="col-3">
						<input type="number" name="numberOfAdults" class="form-control"
							required />
					</div>
					<div class="col-1"></div>
					<div class="col-3">
						<input type="number" name="numberOfKids" class="form-control" />
					</div>
					<div class="col-5"></div>
				</div>
				<div class="row">
					<div class="col-6 text-left">
						<h3>Payment method</h3>
					</div>
					<div class="col-6"></div>
				</div>
				<div class="row">
					<div class="col-4 text-left">
						<h4>Pay by</h4>
					</div>
					<div class="col-8"></div>
				</div>
				<div class="row">
					<div class="col-4 text-left" style="margin-left: 20px;">
						<input type="radio" name="paymentMethod" id="creditCard"
							class="form-check-input" value="creditcard" required /> <label
							for="creditCard" class="form-check-label">Credit Card</label>
					</div>
					<div class="col-8"></div>
				</div>
				<div class="row">
					<div class="col-4 text-left" style="margin-left: 20px;">
						<input type="radio" name="paymentMethod" id="paypal"
							class="form-check-input" value="paypal" /> <label for="paypal"
							class="form-check-label">Paypal</label>
					</div>
					<div class="col-8"></div>
				</div>
				<div class="row">
					<div class="col-4 text-left" style="margin-left: 20px;">
						<input type="radio" name="paymentMethod" id="debitCard"
							class="form-check-input" value="debitCard" /> <label
							for="debitCard" class="form-check-label">Debit Card</label>
					</div>
					<div class="col-8"></div>
				</div>
				<div class="row justify-content-center">
					<div class="col-12">
						<button class="btn btn-success" type="submit">Submit</button>
						<button class="btn btn-success" type="reset">Clear Form</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>