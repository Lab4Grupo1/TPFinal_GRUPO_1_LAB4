<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar cliente</title>
</head>
<body>
<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">		
						 
				<h4>Modificar cliente</h4>
				
			<div class=".container-sm" style="width: 90%">
			
			<label for="cliente">Busqueda cliente</label> 
				<div class="busquedaForm">	
					<form class="formBusqueda"  style="display:flex;" action="">
					     <input type="text" class="form-control col-md-3" placeholder="cliente">	     
						 <input type="submit" class="btn btn-primary" value="Buscar"  style="margin-left: 10px;">
					</form>
				</div>
				 
			
				<form>
				
				  <div class="form-row">
				    <div class="col-md mb">
				      <label for="Nombre">Nombre</label>
				      <input type="text" class="form-control" id="Nombre" placeholder="Nombre" required>
				    </div>
				    <div class="col-md mb-3">
				      <label for="Apellido">Apellido</label>
				      <input type="text" class="form-control" id="Apellido" placeholder="Apellido" required>
				    </div>
				  </div>
				  
				  <div class="form-row">
				     <div class="col-md-3 mb-3">
				      <label for="FechaNacimiento">Fecha Nacimiento</label>
				      <input type="text" class="form-control" id="FechaNacimiento" placeholder="FechaNacimiento" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">DNI</label>
				      <input type="text" class="form-control" id="DNI" placeholder="DNI" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">CUIL</label>
				      <input type="text" class="form-control" id="CUIL" placeholder="CUIL" required>
				    </div>
				  </div>
				  
				  
				  <div class="form-row">
				    <div class="col-md-5mb">
				      <label for="Direccion">Direccion</label>
				      <input type="text" class="form-control" id="Direccion" placeholder="Direccion" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Localidad">Localidad</label>
				      <input type="text" class="form-control" id="Localidad" placeholder="Localidad" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Provincia">Provincia</label>
				      <input type="text" class="form-control" id="Provincia" placeholder="Provincia" required>
				    </div>
			    <div class="col-md-3 mb-3">
			      <label for="Nacionalidad">Nacionalidad</label>
			      <input type="text" class="form-control" id="Nacionalidad" placeholder="Nacionalidad" required>
			    </div>
				</div>
				    
				  <div class="form-row">
				    <div class="col-md-4 mb">
				      <label for="Telefono">Telefono</label>
				      <input type="text" class="form-control" id="Telefono" placeholder="Telefono" required>
				    </div>
				    <div class="col-md-6 mb-3">
				      <label for="Email">Email</label>
				      <input type="email" class="form-control" id="Email" placeholder="Email" required>
				    </div>
				  </div>   
				  
				  <div class="form-group">
				    <div class="form-check">
				      <input class="form-check-input" type="radio" name="sexo" id="Masculino" required>
				      <label class="form-check-label" for="Masculino">Masculino</label>
				      <br>
				      <input class="form-check-input" type="radio" name="sexo" id="Femenino" required>
				      <label class="form-check-label" for="Femenino">Femenino</label>
				    </div>
				  </div> 
				  <button class="btn btn-primary" type="submit">Aceptar</button>
				  <button class="btn btn-primary" type="submit">Cancelar</button>
				  <button class="btn btn-primary" type="submit">Modificar Contraseña</button>
				</form>
			 
			</div>  	
		 
		</div>		
	</div>	
</div>


</body>
</html>