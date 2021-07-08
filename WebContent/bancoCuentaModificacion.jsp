<%@page import="negocioImpl.TiposCuentaNegocioImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entidad.TipoCuentas"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
</head>
<body>
<%@ page errorPage="errorBanco.jsp" %> 

	<div class=".container">
		<div class="row row-principal">
			<div class="col-2 col-menu">
				<jsp:include page="masterBanco.jsp"></jsp:include>
			</div>
			<div class="col">
				<h4>Cuentas</h4>
				<div class=".container-sm" style="width: 90%">
					<label for="cliente">Busqueda cliente</label>
					<form action="servletbancoModificacionCuenta" method="post">
						<div class="busquedaForm">

							<input type="text" class="form-control col-md-3"
								placeholder="DNI" name="DNI"> <input type="submit"
								class="btn btn-primary" value="Buscar" name="btnBuscar"
								style="margin-left: 10px;">
						</div>
					</form>
					<br>

					<form action="servletbancoModificacionCuenta" method="post">
						<div class="col-md-3 mb-3">
							<label for="TipoCuenta">Cuenta activa</label> <br> <select
								name="TipoCuenta">
								<%
									
								%>
							</select>
						</div>
						<br>
						<div class="form-row">
							<div class="col-md-3 mb-3">
								<label for="TipoCuenta">Numero de cuenta</label> <br> <select
									name="NroCuenta">
									<%
										
									%>
								</select>
							</div>

							<div class="col-md-3 mb-3">
								<label for="DNICliente">DNI Cliente</label> <input type="text"
									class="form-control" name="DNICliente"
									placeholder="DNI Cliente" required>
							</div>

						</div>

						<div class="form-row">
							<div class="col-md-3 mb-3">
								<label for="TipoCuenta">Tipo Cuenta</label> <br> <select
									name="TipoCuenta">
									<%
										TiposCuentaNegocioImpl tp = new TiposCuentaNegocioImpl();
																								ArrayList<TipoCuentas> Listatp = tp.readAll();
																								if (tp != null) {
																									for (TipoCuentas ltp : Listatp) {
									%><option value="<%=ltp.getId()%>"><%=ltp.getDescripcion()%>
									</option>
									<%
										}
										}
									%>
								</select>
							</div>
							<div class="col-md-3 mb-3">
								<label for="Saldo">Saldo</label> <input type="text"
									class="form-control" name="Saldo" placeholder="Saldo" required>
							</div>


						</div>

						<br> <input class="btn btn-outline-primary" type="submit"
							value="Aceptar" name="btnAceptar"> <input
							class="btn btn-outline-primary" type="submit" value="Dar de baja"
							name="tbnDardebaja"> <input
							class="btn btn-outline-primary" type="submit" value="Cancelar"
							name="btnCancelar">
					</form>
				</div>
			</div>
		</div>
	</div>


</body>
</html>