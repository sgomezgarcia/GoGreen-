<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>

<!-- Bootstrap CSS -->
<link rel="stylesheet" type="text/css" href="./css/index.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f90d3bf50d.js"
	crossorigin="anonymous"></script>

<title>GoGreen</title>
</head>

<body>
	<form class="form-signin" method="POST"
		action="${pageContext.request.contextPath}/product?action=login">
		<img class="logo" src="https://image.winudf.com/v2/image/Y29tLnNocmVlLmhlYWx0aHlmb29kX2ljb25fMTUzODM5ODk4OF8wOTg/icon.png?w=170&fakeurl=1">
		<h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
		<label for="inputEmail" class="sr-only">Username</label> <input
			name="name" id="inputEmail" class="form-control"
			placeholder="Username" required="" autofocus=""> <label
			for="inputPassword" class="sr-only">Password</label> <input
			type="password" name="password" id="inputPassword"
			class="form-control" placeholder="Password" required="">
		<div class="checkbox mb-3">
			<label> <input type="checkbox" value="remember-me">
				Remember me
			</label>
		</div>
		<button class="btn btn-lg btn-primary btn-block" type="submit"
			name="btnUser" style=" width: 100%; background-color: green; border-color: none;">Sign in</button>
		<a href="http://localhost:8080/gogreen/frontOffice.jsp" class="guest" type="submit">Sign as guest</a>
		<p class="mt-5 mb-3 text-muted">© 2020-2021</p>
	</form>
</body>
</html>