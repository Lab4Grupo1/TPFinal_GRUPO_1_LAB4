<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion de contraseñas</title>
</head>
<body>
<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">			
		  
		<h4>Gestion de contraseñas</h4>
		 					
		<div class=".container-sm" style="width: 90%">
		 
			<form action="servletBancoGestionPassAlta" method="get">	 
				<div class="form-row">
				    <div class="col-md-5 mb-3">
				      <label for="NuevaPass">Nueva Contraseña</label>
				      <input type="password" class="form-control" name="NuevaPass" placeholder="Nueva Contraseña" required>
				    </div>   
			 	</div>   
				<div class="form-row">
				    <div class="col-md-5 mb-3">
				      <label for="NuevaPassRepetir">Repetir Nueva Contraseña</label>
				      <input type="password" class="form-control" name="NuevaPassRepetir" placeholder="Repetir Nueva Contraseña" required>
				   </div>     
				</div>    
			  
			   <br>
			<input class="btn btn-primary col-md-1" type="submit" value="Aceptar" name="btnAceptar">
			<input class="btn btn-primary col-md-1" type="submit" value="Cancelar" name="btnCancelar">
			</form>
		</div>     
		
		</div>		
	</div>	
</div>

     

</body>
</html>