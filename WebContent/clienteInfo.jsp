<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Informacion Personal</title>
</head>
<body>

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterCliente.jsp"></jsp:include>	
		</div>		
		<div class="col">			
		 
<h4>Informacion Personal</h4>
 
		<br>
		<ul class="list-group">
			  <li class="list-group-item col-md-4">
		    Nombre: 
		    <span class="badge">Gaston</span>
		  </li>
		</ul>
		<br> 
		<ul class="list-group">
			  <li class="list-group-item col-md-4">
		    Apellido: 
		    <span class="badge">Gonzalez</span>
		  </li>
		</ul>
		<br> 
		<ul class="list-group">
			  <li class="list-group-item col-md-4">
		    DNI: 
		    <span class="badge">3542204</span>
		  </li>
		</ul>
 
		
		</div>		
	</div>	
</div>


</body>
</html>