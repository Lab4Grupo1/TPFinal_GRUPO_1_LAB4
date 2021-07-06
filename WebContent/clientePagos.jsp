<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagos</title>
</head>
<body>
<%@ page errorPage="errorCliente.jsp"%> 

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterCliente.jsp"></jsp:include>	
		</div>		
		<div class="col">		
		
		 
<h4>Pagos pendientes</h4>
     

<div class=".container table-responsive-md">  
	 
	<br>  
	<table class="table table-sm table-hover table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">N° Solicitud</th>
	      <th scope="col">Motivo</th>
	      <th scope="col">Estado</th>
	      <th scope="col">Fecha Emitida</th>
	      <th scope="col">Fecha Emitida</th>
	    </tr>
	  </thead>
	  <tbody>
	    <tr>
	      <th scope="row">1</th>
	      <td>Prestamo</td>
	      <td>Pendiente</td> 
	      <td>09/12/2018</td>
	      <td><a href="clientePagos.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Pagar</a></td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Prestamo</td>
	      <td>Pendiente</td> 
	      <td>09/12/2018</td>
	      <td><a href="clientePagos.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Pagar</a></td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Prestamo</td>
	      <td>Pendiente</td> 
	      <td>09/12/2018</td>
	      <td><a href="clientePagos.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Pagar</a></td>
	    </tr>
	    <tr>
	      <th scope="row">1</th>
	      <td>Prestamo</td>
	      <td>Pendiente</td> 
	      <td>09/12/2018</td>
	      <td><a href="clientePagos.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Pagar</a></td>
	    </tr>
	  </tbody>
	</table>
</div> 
 	
		
		
		</div>		
	</div>	
</div>

     
</body>
</html>