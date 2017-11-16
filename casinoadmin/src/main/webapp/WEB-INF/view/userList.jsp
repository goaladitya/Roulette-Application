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
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.3/umd/popper.min.js"
	integrity="sha384-vFJXuSJphROIrBnz7yo7oB41mKfc8JzQZiCq4NCceLEaO4IHwicKwpJf9c9IpFgh"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/js/bootstrap.min.js"
	integrity="sha384-alpBpkh1PFOepccYVYDB4do5UnbKysX5WZXm3XxPqe5iKTfUKjNkCk9SaVuEZflJ"
	crossorigin="anonymous"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">

<script type="text/javascript">
$(document).on("click", ".recharge-popup", function () {
    var userName = $(this).attr('user-name');
    $(".modal-header #user-name").html(userName);
    var userId = $(this).attr('user-id');
    $(".modal-body #id").val( userId );
  
});
    </script>

<title>Hello</title>
</head>
<body>
	<%@include file="rechargeModal.jsp"%>
	<nav class="navbar navbar-expand-lg navbar-light bg-light fixed-top" style="position:fixed">
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="nav nav-pills">
				<li class="nav-item"><a class="nav-link" style="color: #ff1493;" href="/home">Home
				</a></li>
				<li class="nav-item"><a class="nav-link" style="color: #ff1493;" href="/register" >Register</a></li>
				<li class="nav-item"><a class="nav-link active" style="background-color: #ff1493;"
					href="/userList">User List<span class="sr-only">(current)</span>
				</a></li>
			</ul>
		</div>
		<span class="navbar-brand mb-0 h1" style="color: #ff1493;">Welcome to Casino Admin App!</span>
	</nav>
	<br>
	<br>
	<br>
	<br>
	<br>
	<spring:url value="/userList" var="action" />
	<form:form action="${action}" method="POST" modelAttribute="search">
		<div class="form-group row">
			<div class="col-sm-2"></div>
			<label for="name" class="col-sm-1 col-form-label">Name</label>
			<div class="col-sm-3">
				<form:input type="text" class="form-control" id="name"
					placeholder="Name" path="name"></form:input>
			</div>
			<label for="contact" class="col-sm-1 col-form-label">Contact</label>
			<div class="col-sm-3">
				<form:input type="number" class="form-control date" id="contact"
					placeholder="conatct" path="contact"></form:input>
			</div>			
		</div>

		<div class="form-group row">
			<div class="col-sm-2"></div>
			<label for="email" class="col-sm-1 col-form-label">Email</label>
			<div class="col-sm-3">
				<form:input type="text" class="form-control" id="email"
					placeholder="Email" path="email"></form:input>
			</div>
			<div class="col-sm-1"></div>
			<div class="d-flex justify-content-center col-sm-2">
				<button type="submit" class="btn btn-block" style="background-color:#ff1493">Search</button>
			</div>
		</div>
	</form:form>
	<br>
	<div class="row">
	<div class="col-sm-1"></div>
	<div class="col-sm-10">
	<table class="table table-bordered table-striped table-danger">
		<thead>
			<tr>
				<th scope="col">S.No</th>
				<th scope="col">Name</th>
				<th scope="col">DOB</th>
				<th scope="col">Contact</th>
				<th scope="col">Email</th>
				<th scope="col">Balance</th>
				<th scope="col">Recharge</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user" varStatus="loop">
				<tr>
					<td>${loop.count}</td>
					<td>${user.name}</td>
					<td>${user.dob}</td>
					<td>${user.contact}</td>
					<td>${user.email}</td>
					<td>${user.balance}</td>
					<td><a href="#" data-toggle="modal" user-name="${user.name}" user-id="${user.id}" class="recharge-popup"
						data-target="#rechargeModal"> <span class="fa fa-plus text-danger"
							aria-hidden="true"></span>
					</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</div>
	</div>
</body>
</html>