<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>Sign In</title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="${pageContext.request.contextPath}/css/styles.css"
	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css"
	rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/bootstrap.min.css.map"
	rel="stylesheet">
</head>
<body>
	 <div class="card-container container">
	 <div class="row justify-content-center row-padding">
                <h1>Sign In</h1>
            </div>
	 	<form action="signin" method="POST">
            <div class="row row-padding">
                <label for="email" class="col-3 col-form-label">Email:</label>
                <div class="col-sm-9">
                    <input id="email" name="email" class="form-control" />
                </div>
            </div>
            <div class="row row-padding">
                <label for="password" class="col-3 col-form-label">Password:</label>
                <div class="col-sm-9">
                    <input id="password" type="password" name="password" class="form-control" />
                </div>
            </div>
            <div class="row justify-content-center row-padding">
                <button type="submit" class="btn btn-success">Sign In</button>
            </div>
        </form>
	 </div>
</body>
</html>