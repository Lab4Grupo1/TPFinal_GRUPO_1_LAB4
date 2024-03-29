
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.util.Formatter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="entidad.DatosPersonales"%>
<%@page import="daoImpl.DatosPersonalesDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informacion Personal</title>
<link href="css/estilos.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterCliente.jsp"></jsp:include>
			</div>
			<div class="col">

				<h4>Informacion Personal</h4>
				<%
					HttpSession sesion1 = request.getSession();
					int dni = 33119411;

					DatosPersonalesDaoImpl datImpl = new DatosPersonalesDaoImpl();
				%>
				<br>
				<form class="row" >
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Nombre</label> <input 
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getNombre()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Apellido</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getApellido()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">DNI</label> <input class="form-control"
							type="text" aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getDni()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">CUIL</label> <input class="form-control"
							type="text" aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getCuil()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Sexo</label> <input class="form-control"
							type="text" aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getSexo()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Fecha Nacimiento</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getFechaNacimiento()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Direccion</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getDireccion()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Localidad</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getLocalidad()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Provincia</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getDireccion()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Mail</label> <input class="form-control"
							type="text" aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getMail()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Nacionalidad</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getNacionalidad().getNacionalidad()%>">
					</div>
					<div class="col-md-4 mb-3">
						<label class="form-label" style="font-weight: bold">Telefono</label> <input
							class="form-control" type="text"
							aria-label="readonly input example" readonly
							value="<%=datImpl.buscarDNI(dni).getTelefono().getNumero()%>">
					</div>
				</form>
			</div>
		</div>
	</div>


</body>
</html>