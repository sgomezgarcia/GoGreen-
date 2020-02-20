<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta http-equiv=”Content-Type” content=”text/html; charset=UTF-8″>
<!--Si volen que la pàgina es carregui cada 5 segons  -->
<!--<meta http-equiv="refresh" content="5;url=${pageContext.request.contextPath}/client">-->

<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<script src="https://kit.fontawesome.com/f90d3bf50d.js"
	crossorigin="anonymous"></script>
		<link rel="stylesheet" type="text/css" href="./css/index.css">
	
</head>
<body>
	<!--Header-->
	<jsp:include page="/common/jumbotron.jsp" />
	<jsp:include page="/common/header.jsp" />


	<!--Botones de navegacion-->
	<section id="actions" class="py-4 mb-4 bg-light">
		<div class="container">
			<div class="row">
			<div class="buttons">
					<a href="${pageContext.request.contextPath}/addProduct.jsp"
						class="btn"> <i class="fas fa-plus"></i>
						Add products
					</a>
				</div>
				<div class="buttons">
					<a href="${pageContext.request.contextPath}/product?action=list"
						class="btn"> <i class="fas fa-eye"></i>
						Display products
					</a>
				</div>
				<div class="buttons">
					<a href="${pageContext.request.contextPath}/client?action=list"
						class="btn"> <i class="fas fa-eye"></i>
						Display clients
					</a>
				</div>
				<div class="buttons">
					<button onclick="getClients()" class="btn">
						<i class="fas fa-eye"></i> Display clients AJAX
					</button>
				</div>
				<div class="buttons">
					<a href="${pageContext.request.contextPath}/addClient.jsp"
						class="btn"> <i class="fas fa-plus"></i>
						Add client
					</a>
				</div>
			</div>
		</div>
	</section>

	<!--Listado Clientes -->
	<jsp:include page="/listClients.jsp" />

	<jsp:include page="/addProduct.jsp" />

	<!--Footer-->
	<jsp:include page="/common/footer.jsp" />

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
	<script src="js/ajax.js">
        </script>
</body>
</html>
