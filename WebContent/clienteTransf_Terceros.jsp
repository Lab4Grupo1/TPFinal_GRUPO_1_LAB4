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
				<h4>Transferencias - Terceros</h4>
	

<div class=".container">
	<nav aria-label="Page navigation example">
	  <ul class="pagination pagination-sm">
	    <li class="page-item"><a class="page-link" href="clienteTransf_CuentaPropia.jsp">  Cuenta Propia  </a></li>
	    <li class="page-item active" aria-current="page">
	      <span class="page-link">  Terceros  </span>
	    </li> 
	  </ul>
	</nav>
	
	<div class="row" style="width: 500px">
		<div class="col">
			<div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    Desde cuenta
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="?ca">Caja de Ahorro</a>
		    <a class="dropdown-item" href="?cc">Cuenta Corriente</a> 
			  </div> 
			</div> 
		</div>
		<div class="col">
			<div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    Hacia cuenta
			  </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="?ca">Caja de Ahorro</a>
		    <a class="dropdown-item" href="?cc">Cuenta Corriente</a>
			  </div> 
			</div> 
		</div>
	</div>  
	 
	<br>
      <label for="CBU">CBU</label>
	      <input type="text" class="form-control col-md-3" placeholder="CBU" required>
 
	<br>
  <button class="btn btn-primary" type="submit">Aceptar</button>
  <button class="btn btn-primary" type="submit">Cancelar</button>
</div>
    	
		
		
		</div>		
	</div>	
</div>

     
</body>
</html>