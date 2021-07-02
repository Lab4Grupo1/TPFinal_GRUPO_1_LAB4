<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuentas</title>
</head>
<body>

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterCliente.jsp"></jsp:include>	
		</div>		
		<div class="col">			
		 
<h4>Últimos movimientos</h4>
	
<div class="container table-responsive-md">  
	<div class="dropdown">
	  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    Elegir cuenta
	  </button>
	  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
	    <a class="dropdown-item" href="?ca">Caja de ahorro</a>
	    <a class="dropdown-item" href="?ca">Cuenta corriente</a>  
	  </div> 
	</div> 
	
	
	<br>  
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
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>123</td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>123</td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Mark</td>
	      <td>Prestamo</td>
	      <td>@mdo</td>
	      <td>123</td>
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