<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/f90d3bf50d.js" crossorigin="anonymous"></script>
</head>
<body>
	<form name="frmLogin" method="post" action="/startup/action-login">
		<p>
			<label>Nom usuari (nick):</label>
			<input name="userName" type="text" value="" required="required" />
		</p>
		<p>
			<label>Password:</label>
			<input name="userPassword" type="password" value="" required="required" />
		</p>
		<button type="submit">Entrar</button>		
	</form>

</body>
</html>