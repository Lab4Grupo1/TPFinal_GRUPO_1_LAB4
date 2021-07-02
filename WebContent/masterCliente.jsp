<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css"
	integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l"
	crossorigin="anonymous">
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Nunito&display=swap"
	rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<link href="css/estilos.css" rel="stylesheet" type="text/css" /> 
</head>
<body>


<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">
			<div class="col">
				<img class="rounded mx-auto d-block logo" src="image/steam2.png">
				<br> <br> <label class="UserName">Usuario: Sesion</label>
				<hr>
			</div>
			<div class="row row-opciones">
				<div class="btn-group-vertical" style="width: 100%;" role="group" aria-label="Basic outlined example">
							<a class="btn btn-dark" href="clienteCuentas.jsp">Cuentas</a> 
						<a class="btn btn-dark" href="clientePagos.jsp">Pagos</a> 
						<a class="btn btn-dark" href="clienteTransf_CuentaPropia.jsp">Transferencias</a>
						<a class="btn btn-dark" href="clientePrestamos.jsp">Prestamos</a>
						<a class="btn btn-dark" href="clienteInfo.jsp">Informacion Personal</a>			
						</div>
			  </div>
				<div class="row row-sesion">
					<a class="btn btn-dark"  href="google.com">Cerrar sesion</a>
				</div>
		</div>
	</div>
</div>

</body>
</html>