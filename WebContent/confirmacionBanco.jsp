<%@page import="java.util.concurrent.TimeUnit"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>
			<div class="col">
				<div class="col-md-8">
					<br>
					<div class="alert alert-danger" role="alert">
						<h4 class="alert-heading">Operación finalizada</h4>
						<a class="btn btn-primary col-md-2" name="btnContinuar"
							href="bancoSolicitudes.jsp">Continuar</a>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>