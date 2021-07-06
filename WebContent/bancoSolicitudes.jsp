<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="entidad.Solicitud"%>
<%@page import="dao.SolicitudDao"%>
<%@page import="daoImpl.SolicitudDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitudes</title>
</head>
<body>
	<%@ page errorPage="errorBanco.jsp"%>

	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>
			<div class="col">
				<h4>Solicitudes</h4>

				<div class="container table-responsive-md">

					<div class="row">
						<div class="col">
							<label for="cliente">Busqueda cliente</label>
							<div class="busquedaForm">
								<form class="formBusqueda" style="display: flex;"
									action="servletBancoSolicitud" method="get">
									<input type="number" class="form-control col-md-3"
										name="txtCliente" required> <input type="submit"
										class="btn btn-outline-primary" value="Buscar"
										name="btnBuscar" style="margin-left: 10px;">
								</form>
							</div>
						</div>

						<div class="col">
							<div class="dropdown">
								<button class="btn btn-secondary dropdown-toggle" type="button"
									id="dropdownMenuButton" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false">Filtro
									solicitudes</button>
								<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
									<a class="dropdown-item" href="?ca">Completas</a> <a
										class="dropdown-item" href="?cc">Pendientes</a> <a
										class="dropdown-item" href="?cc">Rechazadas</a>
								</div>
							</div>
						</div>
					</div>

					<br>

					<table class="table table-sm table-hover table-bordered ">
						<thead class="thead-dark">
							<tr>
								<th scope="col">N° Solicitud</th>
								<th scope="col">Cliente</th>
								<th scope="col">Cant Cuotas Solic.</th>
								<th scope="col">Monto</th>
								<th scope="col">Estado Solicitud</th>
							</tr>
						</thead>

						<%
							ArrayList<Solicitud> listaSolicitud = null;
							if (request.getAttribute("lista") != null) {
								listaSolicitud = (ArrayList<Solicitud>) request.getAttribute("lista");
						%>
						<tbody>
							<tr>
								<%
									try {
								%>
								<%
									for (Solicitud soli : listaSolicitud) {
								%>
								<td><%=soli.getNumeroSolicitud()%></td>
								<td><%=soli.getNumeroCuenta()%></td>
								<td><%=soli.getCantCuotasSolicitado()%></td>
								<td><%=soli.getMontoSolicitado()%></td>
								<td><%=soli.getEstadoSolicitud()%></td>
								<td>
									<button type="button" class="btn btn-outline-primary"
										onclick="location.href='bancoGestionSolicitudes.jsp?Nsoli=<%=soli.getNumeroSolicitud()%>'"
										name="btnGestionar" style="margin-left: 10px;" Visible=false></button>
								</td>
							</tr>
							<%
								}
							%>
							<td><a href='bancoSolicitudes.jsp'
								class="btn btn-outline-primary" style="margin-right: 10px">Limpiar
									Busqueda</a></td>
							<%
								} catch (Exception e) {
										e.printStackTrace();
									} finally {

									}
							%>

							<%
								} else {
							%>
							<%
								SolicitudDaoImpl soliNeg = new SolicitudDaoImpl();
									ArrayList<Solicitud> lista = soliNeg.readAll();
							%>
							<%
								for (Solicitud soli : lista) {
							%>
							<tr>
								<td><%=soli.getNumeroSolicitud()%></td>
								<td><%=soli.getNumeroCuenta()%></td>
								<td><%=soli.getCantCuotasSolicitado()%></td>
								<td><%=soli.getMontoSolicitado()%></td>
								<td><%=soli.getEstadoSolicitud()%></td>

							</tr>
							<%
								}
							%>
							<%
								}
							%>
						</tbody>
					</table>
					<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
					</ul>
					</nav>
				</div>


			</div>
		</div>
	</div>

</body>
</html>