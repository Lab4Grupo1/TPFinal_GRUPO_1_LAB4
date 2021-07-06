<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Prestamos</title>
</head>
<body>
<%@ page errorPage="errorCliente.jsp"%> 

<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterCliente.jsp"></jsp:include>	
		</div>		
		<div class="col">			
		 
<h4>Prestamos</h4>

	
<div class=".container-sm" style="width: 90%"> 
<form>
  
  <div class="form-row">
     <div class="col-md-3 mb-3">
      <label for="Importe">Importe</label>
      <input type="text" class="form-control" id="Importe" placeholder="Importe" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="CantidadCuotas">Cantidad de cuotas</label>
      <input type="text" class="form-control" id="CantidadCuotas" placeholder="Cantidad de cuotas" required>
    </div>
    <div class="col-md-3 mb-3">
      <label for="CantidadCuotas">Vista previa</label>
      <br>
      <label for="CantidadCuotas">"coutas"x"montos"</label>
    </div>
    
  </div>
  <div class="dropdown">
	  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
	    Elegir cuenta a depositar
	  </button>
	  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
		    <a class="dropdown-item" href="?ca">Caja de Ahorro</a>
		    <a class="dropdown-item" href="?cc">Cuenta Corriente</a>
	  </div> 
	</div> 
	
	<br>
   
  <button class="btn btn-primary" type="submit">Aceptar</button>
  <button class="btn btn-primary" type="submit">Cancelar</button> 
</form>
</div> 
 
		
		</div>		
	</div>	
</div>

     
</body>
</html>