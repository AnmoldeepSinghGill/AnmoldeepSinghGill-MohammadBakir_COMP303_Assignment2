<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
		
		<div class="row justify-content-center row-padding">
			<h1>Sign In</h1>
		</div>
		<p class="alert alert-danger" th:if="${error != null}" th:text="${error}">${error}</p>
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
			<a href="/signUp">Don't Have a Account? Sign Up</a>
		</form>
	</div>
</body>
</html>