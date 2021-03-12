<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment Page</title>

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
		<form action="processPayment" method="POST">
			<div class="row justify-content-center">
				<h3>Payment method</h3>
			</div>
			<div class="row">
				<div class="col-4 text-left">
					<h4>Pay by</h4>
				</div>
				<div class="col-4">
					<input type="radio" name="paymentMethod" id="creditCard"
						class="form-check-input" value="creditCard" required /> <label
						for="creditCard" class="form-check-label">Credit Card</label>
				</div>
				<div class="col-4 text-left">
					<input type="radio" name="paymentMethod" id="debitCard"
						class="form-check-input" value="debitCard" /> <label
						for="debitCard" class="form-check-label">Debit Card</label>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<input type="text" name="firstName"
						aria-describedby="firstNameHelp" class="form-control"
						required="required" /> <small id="firstNameHelp"
						class="form-text text-muted">First Name</small>
				</div>
				<div class="col-6">
					<input type="text" name="lastName" aria-describedby="lastNameHelp"
						class="form-control" required="required" /> <small
						id="lastNameHelp" class="form-text text-muted">Last Name</small>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<input type="number" name="cardNumber"
						aria-describedby="cardNumberHelp" class="form-control"
						required="required" minlength="16" maxlength="16" /> <small id="cardNumberHelp"
						class="form-text text-muted">Card Number</small>
				</div>
				<div class="col-6">
					<input type="number" name="securityCode"
						aria-describedby="securityCodeHelp" class="form-control"
						required="required" maxlength="3" placeholder="CVC" /> <small
						id="securityCodeHelp" class="form-text text-muted">Security
						Code</small>
				</div>
			</div>
			<div class="row">
				<div class="col-6">
					<input type="text" name="cardExpiry"
						aria-describedby="cardExpiryHelp" class="form-control"
						required="required" placeholder="MM / YY" /> <small
						id="cardExpiryHelp" class="form-text text-muted">Card
						Expiration</small>
				</div>
				<div class="col-6"></div>
			</div>
			<div class="row justify-content-center">
				<button class="btn btn-success" type="submit">Pay</button>
			</div>
		</form>
	</div>
</body>
</html>