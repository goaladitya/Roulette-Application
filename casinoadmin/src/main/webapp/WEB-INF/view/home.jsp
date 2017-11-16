<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
				<li class="nav-item"><a class="nav-link active" style="background-color: #ff1493;" href="/home">Home
						<span class="sr-only">(current)</span>
				</a></li>
				<li class="nav-item"><a class="nav-link" style="color: #ff1493;" href="/register">Register</a>
				</li>
				<li class="nav-item"><a class="nav-link" style="color: #ff1493;" href="/userList">User List</a></li>
			</ul>
		</div>
		<span class="navbar-brand mb-0 h1" style="color: #ff1493;">Welcome to Casino Admin App!</span>
	</nav>
	<div>
		<img class="rounded mx-auto d-block" alt="big casino img" style="width:100%; height:550px"
			src="<c:url value="/images/casino-big.png"/>">
	</div>
</body>
</html>