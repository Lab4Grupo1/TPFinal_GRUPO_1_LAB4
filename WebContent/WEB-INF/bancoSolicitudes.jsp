<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Solicitudes</title>
</head>
<body>
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
					<form class="formBusqueda"  style="display:flex;" action="">
					     <input type="text" class="form-control col-md-5" placeholder="cliente">	     
						 <input type="submit" class="btn btn-primary" value="Buscar"  style="margin-left: 10px;">
					</form>
				</div>
		</div> 
		<div class="col">
			 <label for="cliente">Fecha desde-hasta</label> 
				<div class="busquedaForm"  >	
					<form class="formBusqueda"  style="display:flex;" action="">
					     <input type="text" class="form-control col-md-4" placeholder="desde">
					     <input type="text" class="form-control col-md-4" placeholder="hasta">	     
						 <input type="submit" class="btn btn-primary" value="Buscar"  style="margin-left: 10px;">
					</form>
				</div>
		</div>
		 <div class="col">
			<div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    Filtro solicitudes
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <a class="dropdown-item" href="?ca">Completas</a> 
			    <a class="dropdown-item" href="?cc">Pendientes</a>
			    <a class="dropdown-item" href="?cc">Rechazadas</a>  
			  </div> 
			</div> 
		</div>
	</div>
	
	<br> 
	<h5>Paginacion</h5>
	<table class="table table-sm table-hover table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">N° Solicitud</th>
	      <th scope="col">Cliente</th>
	      <th scope="col">Motivo</th>
	      <th scope="col">Monto</th>
	      <th scope="col">Fecha Emitida</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>1213</td>
	      <td><a href="bancoGestionSolicitudes.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Gestionar</a></td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>123</td>
	      <td><a href="bancoGestionSolicitudes.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Gestionar</a></td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>123</td>
	      <td><a href="bancoGestionSolicitudes.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Gestionar</a></td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>123</td>
	      <td><a href="bancoGestionSolicitudes.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Gestionar</a></td>
	    </tr>
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