<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
			
			<br>
			 
			<ul class="list-group">
			  <li class="list-group-item col-md-4">
			    Numero solicitud 
			    <span class="badge"><%=request.getParameter("Nsoli").toString()%></span>
			  </li>
			</ul>
			<br> 
			<ul class="list-group">
			  <li class="list-group-item col-md-4">
			    Numero cliente 
			    <span class="badge">14</span>
			  </li>
			</ul> 
			<br> 
			<ul class="list-group">
			  <li class="list-group-item col-md-4">
			    Monto pedido 
			    <span class="badge">14</span>
			  </li>
			</ul> 
			<br> 
			<ul class="list-group">
			  <li class="list-group-item col-md-4">
			    Cuotas pedidas 
			    <span class="badge">14</span>
			  </li>
			</ul> 
			<br> 
				
			  <input class="btn btn-primary col-md-2" type="submit" value="Autorizar" id="Aceptar"> 
			  <input class="btn btn-primary col-md-2" type="submit" value="Rechazar" id="Cancelar"> 
		</div>		
	</div>	
</div>

     

</body>
</html>