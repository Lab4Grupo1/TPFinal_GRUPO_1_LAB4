<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import= "entidad.Solicitud" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion Solicitudes</title>
</head>
<body>

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		
		<div class="col">		 
			<h4>Gestion Solicitudes</h4>  
		<form  class="formBusqueda" style="display:flex;" action="servletBancoGestionSolicitudes" method= "get">
			
			<% String numero= request.getParameter("Nsoli");%> 
			 <input type="number" class="form-control col-md-3" value=<%=numero %> name="txtUrl" required>	
			 <input class="btn btn-outline-primary" type="submit"  value="Solicitud" name="url" >
		</form>
			<% Solicitud solicitud= new Solicitud();%>
			<%if(request.getAttribute("solic")!=null){
				solicitud=(Solicitud)request.getAttribute("solic");  %>
		<div>		 
			<tbody>
				<p></p>
			    <p>Numero de solicitud: <%=solicitud.getNumeroSolicitud() %> </p>
			    <p>Numero de cuenta:<%=solicitud.getNumeroCuenta() %> </p>
			    <p>Cantidad de cuotas:<%= solicitud.getCantCuotasSolicitado() %></p>
	      		<p>Monto solicitado:<%= solicitud.getMontoSolicitado() %></p>
	      		<p>Estado: <%= solicitud.getEstadoSolicitud() %></p>
	      		<p></p>
			<%}%>
			</tbody>
		</div>	
			
		</div>	
		<div>
		 <input class="btn btn-primary col-md-2" type="submit" value="Autorizar" id="Aceptar"> 
		 <input class="btn btn-primary col-md-2" type="submit" value="Rechazar" id="Cancelar"> 
	</div>
		
	</div>	
</div>

     

</body>
</html>