<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.TipoCuentas"%>
<%@page import="daoImpl.TipoCuentasDaoImpl"%>
<%@page import="entidad.Movimientos"%>
<%@page import="daoImpl.MovimientosDaoImpl"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
</head>
<body>
	<%@ page errorPage="errorCliente.jsp"%>
	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterCliente.jsp"></jsp:include>
			</div>
			<div class="col">

				<div class="container table-responsive-md">
					<br>
					<h4>Últimos movimientos</h4>

					<%
					String tipoCuenta = "";
					String numCuenta = "";

					if (request.getAttribute("tipoCuenta") != null) {
						tipoCuenta = request.getAttribute("tipoCuenta").toString();
					}

					if (request.getAttribute("numCuenta") != null) {
						numCuenta = request.getAttribute("numCuenta").toString();
					}
					%>
					<div  class="dropdown">
						<a class="btn btn-secondary dropdown-toggle" type="button"
							id="dropdownMenuButton" data-toggle="dropdown"
							aria-haspopup="true" aria-expanded="false">Elegir cuenta </a>
						<div class="dropdown-menu" aria-labelledby="dropdownMenuButton">

							<%
							TipoCuentasDaoImpl tip = new TipoCuentasDaoImpl();

							ArrayList<TipoCuentas> Ltip = tip.readAll();

							try {

								if (Ltip != null) {
									for (TipoCuentas list : Ltip) {
							%>
							<a class="dropdown-item"
								href="servletClienteCuentas?idTipoCuenta=<%=list.getId()%>"><%=list.getDescripcion()%></a>
							<%
							}
							}

							} catch (Exception e) {
							}
							%>

						</div>
					</div>
					<br>
					<%
					ArrayList<Movimientos> Lmov = null;
					if (request.getAttribute("Lmov") != null) {
						Lmov = (ArrayList<Movimientos>) request.getAttribute("Lmov");
					%>
					<div>
						<h5><%=tipoCuenta%>
							número:
							<%=numCuenta%></h5>
						<br>
						<table class="table table-sm table-hover table-bordered">
							<thead>
								<tr>
									<th scope="col">Mov</th>
									<th scope="col">Detalle</th>
									<th scope="col">Fecha</th>
									<th scope="col">Monto</th>
									<th scope="col">Tipo</th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<%
									for (Movimientos list : Lmov) {
									%>
									<th scope="row"><%=list.getId()%></th>
									<th scope="row"><%=list.getDetalle()%></th>
									<th scope="row"><%=list.getFecha()%></th>
									<th scope="row"><%=list.getImporte()%></th>
									<th scope="row"><%=list.getTipoMovimiento().getDescripcion()%></th>
								</tr>
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

					<%
					} else {
					%>
					<br>
					<h5>No posee cuentas asociadas</h5>
					<%
					}
					%>
				</div>
			</div>
		</div>
	</div>
</body>
</html>