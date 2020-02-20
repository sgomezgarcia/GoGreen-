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
<link rel="stylesheet" type="text/css" href="./css/index.css">

<script src="https://kit.fontawesome.com/f90d3bf50d.js"
	crossorigin="anonymous"></script>

<title>Agregar producto</title>
</head>
<body>
	<!--Header-->
	<jsp:include page="/common/jumbotron.jsp" />
            <section id="front-office-container">
            
            <form action="${pageContext.request.contextPath}/product?action=insert" method="POST" class="was-validated">
                <input type="hidden" name="action" value="insert">
                <div class="modal-body">
                    <div class="form-group">
                        <label for="nombre">Nombre Producto</label>
                        <input type="text" class="form-control" name="name" required />
                    </div>
                    <div class="form-group">
                            <label for="categoria">Categoria</label>
                            <select class="form-control" name="category" id="categoria">
                                <option>Verdura</option>
                                <option>Carne</option>
                                <option>Fruta</option>
                                <option>Lacteo</option>
                                <option>Cereales y derivados</option>
                            </select>
                            </div>
                                     
                    <div class="form-group">
                        <label for="precio">Precio</label>
                        <input type="text" class="form-control" name="price" required  />
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="button-add-ticket" type="submit">Guardar</button>
                </div>    
            </form>
            	</section>
        </div>
    </div>
</div>
    