<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import= "entidad.Prestamos" %>
<%@page import="dao.PrestamosDao" %>
<%@page import= "negocioImpl.PrestamosNegocioImpl" %>
<%@page import="java.util.ArrayList"%>   
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pagos</title>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js" ></script> 
<script type="text/javascript"  src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js" defer ></script>
<script type="text/javascript"  src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js" defer ></script>
 
<script type="text/javascript"  src="https://cdnjs.cloudflare.com/ajax/libs/jszip/2.5.0/jszip.min.js" defer ></script>
<script type="text/javascript" src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/pdfmake.min.js" defer  ></script>
<script type="text/javascript"  src="https://cdn.rawgit.com/bpampuch/pdfmake/0.1.24/build/vfs_fonts.js" defer    ></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.4/js/buttons.html5.min.js" defer ></script>
<script type="text/javascript" src="https://cdn.datatables.net/buttons/1.2.1/js/buttons.print.min.js" defer ></script> 

<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css"></link>
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css"></link>

<script type="text/javascript">
	$(document).ready(function() {
		$('#table1').DataTable();
	});
</script>
</head>
<body>

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterCliente.jsp"></jsp:include>	
		</div>		
		<div class="col">		
		
		 
<h4>Pagos pendientes</h4>
     

<div class=".container table-responsive-md">  
	<form class="formBusqueda"  style="display:flex;" action="servletclientesPagos" method= "get">
		<input type="number" class="form-control col-md-3" name="txtNprestamo" required>	     
		<input type="submit" class="btn btn-outline-primary" value="Buscar" name= "btnBuscarPrest" style="margin-left: 10px;">
	</form>
	<br>  
	<%ArrayList<Prestamos> ListarPrestamos = new ArrayList<Prestamos>();%>
	<table id="table1" class="table table-sm table-hover table-bordered">
	  <thead>
	    <tr>
	      <th scope="col">N° Solicitud</th>
	      <th scope="col">cuotas Pagas</th>
	      <th scope="col">Cuotas Total</th>
	      <th scope="col">Importe Cuota</th>
	     
	    </tr>
	  </thead>
	  	<%ArrayList<Prestamos> listaFiltrada= null;
	  	if(request.getAttribute("listafiltrada")!=null){
	  		listaFiltrada =(ArrayList<Prestamos>)request.getAttribute("listafiltrada");%>
	  <tbody>
	  	<tr>
	  	<%try{
	  		 for(Prestamos pre : listaFiltrada){%>
	  		<td><%=pre.getId() %></td>
	  		<td><%=pre.getCuotasPagas() %></td>
	  		<td><%=pre.getCuotasPagas() %></td>
	  		<td><%=pre.getCuotasTotal() %></td>	 
	  		<td><%=pre.getImportePedidoTotal() %></td>
	  		<td><a href="clientePagos.jsp" class="btn btn-primary"  role="button" aria-disabled="true">Pagar</a></td>
	  		
	  	<%}%>
	  	<%}catch(Exception e ){%>
	  	<% %>
	  	<%}finally{}%>
	  	
	  	
	  	<%}else{%>
	  	<%PrestamosNegocioImpl dao = new PrestamosNegocioImpl();
	  	 ListarPrestamos = dao.readAll(); %>
	    <tr>
	    <%for(Prestamos pres : ListarPrestamos){ %>
	      <td><%=pres.getId() %></td>
	      <td><%=pres.getCuotasPagas() %></td> 
	      <td><%=pres.getCuotasTotal() %></td>
	      <td><%=pres.getImportePedidoTotal() %></td>
	      
	    </tr>
	      <%}%>
	    <%}%>
	     
	  </tbody>
	</table>
</div> 
 	
		
		
		</div>		
	</div>	
</div>

     
</body>
</html>