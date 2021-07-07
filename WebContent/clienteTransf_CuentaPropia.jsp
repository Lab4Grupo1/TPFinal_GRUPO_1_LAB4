<%@page import="entidad.Cuentas"%>
<%@page import="java.util.ArrayList"%>
<%@page import="negocioImpl.CuentasNegocioImpl"%>
<%@page import="negocio.CuentasNegocio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transferencias</title>
</head>
<body>
	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterCliente.jsp"></jsp:include>
			</div>
			<div class="col">
				<h4>Transferencias - Cuenta propia</h4>
				<div class=".container">
					<nav aria-label="Page navigation example">
					<ul class="pagination pagination-sm">
						<li class="page-item active" aria-current="page"><span
							class="page-link"> Cuenta Propia </span></li>
						<li class="page-item"><a class="page-link"
							href="clienteTransf_Terceros.jsp"> Terceros </a></li>
					</ul>
					</nav>
				<form action="servletClienteTransf_CuentaPropia" method="get">
					<div class="row" style="width: 500px">
						<div class="col-md-3 mb-3" style="margin-right: 100px; padding: 10px;">
							<label for="CuentaDesde">Desde cuenta</label> 
							<select name="CuentaDesde">
								<%
									HttpSession sessionUsuario = request.getSession();

									CuentasNegocio cNimpDesde = new CuentasNegocioImpl();
									String dni = sessionUsuario.getAttribute("SesionDNI").toString();
									int dniEntero = Integer.parseInt(dni);
									ArrayList<Cuentas> ListCDesde = cNimpDesde.ListarCuentas(dniEntero);

									if (cNimpDesde != null) {
										for (Cuentas tpcListaDesde : ListCDesde) {
								%><option value="<%=tpcListaDesde.getNumeroCuenta() %>"><%=tpcListaDesde.getTipoCuenta().getDescripcion()%>-<%=tpcListaDesde.getNumeroCuenta()%>
								</option>
								<%
									}
									}
								%>
							</select>
						</div>
						<div class="col-md-3 mb-3" style="margin-right: 60px; padding: 10px;">
							<label for="CuentaHasta">Hacia cuenta</label> 
							<select	name="CuentaHasta">
								<%
									CuentasNegocioImpl cNimpHasta = new CuentasNegocioImpl();
									String dni2 = sessionUsuario.getAttribute("SesionDNI").toString();
									int dniEntero2 = Integer.parseInt(dni2);
									ArrayList<Cuentas> ListCHasta = cNimpHasta.ListarCuentas(dniEntero2);

									if (cNimpHasta != null) {
										for (Cuentas tpcListaHasta : ListCHasta) {
								%><option value="<%=tpcListaHasta.getNumeroCuenta() %>"><%=tpcListaHasta.getTipoCuenta().getDescripcion()%>-<%=tpcListaHasta.getNumeroCuenta()%>
								</option>
								<%
									}
									}
								%>
							</select>
						</div>
					</div>
					<label for="Monto">Monto</label> 
					<input type="text" class="form-control col-md-3" name="monto" placeholder="monto" required>
					<br>
					<input class="btn btn-outline-primary" type="submit" value="Aceptar" name="btnAceptar">
					<input class="btn btn-outline-primary" type="submit" value="Cancelar" name="btnCancelar">
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>