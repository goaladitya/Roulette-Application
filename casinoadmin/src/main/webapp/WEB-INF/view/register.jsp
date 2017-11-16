<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css"
	integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb"
	crossorigin="anonymous">
<title>Hello</title>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="nav nav-pills">
				<li class="nav-item"><a class="nav-link" style="color: #ff1493;" href="/home">Home
				</a></li>
				<li class="nav-item" ><a class="nav-link active" style="background-color: #ff1493;"
					href="/register">Register<span class="sr-only">(current)</span></a></li>
				<li class="nav-item" ><a class="nav-link" style="color: #ff1493;" href="/userList">User
						List</a></li>
			</ul>
		</div>
		<span class="navbar-brand mb-0 h1" style="color: #ff1493;">Welcome to Casino Admin App!</span>
	</nav>
	<div></div>
	<br>
	<br>
	<spring:url value="/register" var="action" />
	<div class="row">
	<div class="col-sm-4"></div>
	<form:form action="${action}" method="POST" class="col-sm-4" modelAttribute="user" style="border: 1px solid #ccc; border-radius: 4px; border-color: #ff1493">
		<br>
		<br>
		<div class="form-group row">
			<label for="name" class="col-sm-4 col-form-label">Name</label>
			<div class="col-sm-8">
				<form:input type="text" class="form-control" id="name"
					placeholder="Name" path="name"></form:input>
				<form:errors path="name" class="alert alert-danger"></form:errors>
			</div>
		</div>
		<br>
		<div class="form-group row">
			<label for="dob" class="col-sm-4 col-form-label">Date of
				Birth</label>
			<div class="col-sm-6">
				<form:input type="date" class="form-control" id="dob" placeholder=""
					path="dob"></form:input>
				<form:errors path="dob" class="alert alert-danger"></form:errors>
			</div>
		</div>
		<br>
		<div class="form-group row">
			<label for="contact" class="col-sm-4 col-form-label">Contact</label>
			<div class="col-sm-8">
				<form:input type="number" min="1000000000" max="9999999999" class="form-control number" id="contact"
					placeholder="contact" path="contact"></form:input>
				<form:errors path="contact" class="alert alert-danger"></form:errors>
			</div>
		</div>
		<br>
		<div class="form-group row">
			<label for="email" class="col-sm-4 col-form-label">Email</label>
			<div class="col-sm-8">
				<form:input type="email" class="form-control email" id="email"
					placeholder="Email" path="email"></form:input>
				<form:errors path="email" class="alert alert-danger"></form:errors>
			</div>
		</div>
		<br>
		<div class="form-group row">
			<div class="col-sm-4"></div>
			<button type="submit" class="btn col-sm-3" style="margin-left:13px; background-color:#ff1493;">Register</button>
		</div>
		<br>

	</form:form>
	</div>
</body>
</html>