<%@page import="entidad.Rol"%>
<%@page import="daoImpl.RolDaoImpl"%>
<%@page import="java.util.ArrayList"%>
<%@page import="daoImpl.NacionalidadDaoImpl"%>
<%@page import="entidad.Nacionalidad"%> 
<%@page import="negocio.NacionalidadNegocio"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Alta Usuario</title>
</head>
<body>


<div class=".container">
	<div class="row row-principal">
		<div class="col-2 col-menu">	
			<jsp:include page="masterBanco.jsp"></jsp:include>	
		</div>		
		<div class="col">			  
						<h4>Alta Usuario</h4>	
				<div class=".container-sm" style="width: 90%">
				 
				<form action="servletBancoAltaCliente" method="get">
				
				  <div class="form-row">
				    <div class="col-md mb">
				      <label for="Nombre">Nombre</label>
				      <input type="text" class="form-control" name="Nombre" placeholder="Nombre" required>
				    </div>
				    <div class="col-md mb-3">
				      <label for="Apellido">Apellido</label>
				      <input type="text" class="form-control" name="Apellido" placeholder="Apellido" required>
				    </div>
				  </div>
				  
				  <div class="form-row">
				     <div class="col-md-3 mb-3">
				      <label for="FechaNacimiento">Fecha Nacimiento</label>
				      <input type="text" class="form-control" name="FechaNacimiento" placeholder="DD/MM/YYYY" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">DNI</label>
				      <input type="text" class="form-control" name="DNI" placeholder="DNI" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Apellido">CUIL</label>
				      <input type="text" class="form-control" name="CUIL" placeholder="CUIL" required>
				    </div>
				  </div>
				  
				  
				  <div class="form-row">
				    <div class="col-md-5mb">
				      <label for="Direccion">Direccion</label>
				      <input type="text" class="form-control" name="Direccion" placeholder="Direccion" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Localidad">Localidad</label>
				      <input type="text" class="form-control" name="Localidad" placeholder="Localidad" required>
				    </div>
				    <div class="col-md-3 mb-3">
				      <label for="Provincia">Provincia</label>
				      <input type="text" class="form-control" name="Provincia" placeholder="Provincia" required>
				    </div>   
					<div class="col-md-3 mb-3">
					   <label for="Nacionalidad">Nacionalidad</label> 
					   <select name="Nacionalidad"> 
						   <%	NacionalidadDaoImpl Naca = new NacionalidadDaoImpl();
					 			ArrayList<Nacionalidad> ListaN =  Naca.readAll();
								if(Naca != null)
								{
									for(Nacionalidad nac : ListaN){
								       %><option value="<%=nac.getId() %>"><%=nac.getNacionalidad() %> </option><%
								       }		
								}			
							%> 
						</select>
					</div>				    
				</div>
				    
				  <div class="form-row">
				    <div class="col-md-4 mb">
				      <label for="Telefono">Telefono</label>
				      <input type="text" class="form-control" name="Telefono" placeholder="Telefono" required>
				    </div>
				    <div class="col-md-4 mb-3">
				      <label for="Email">Email</label>
				      <input type="email" class="form-control" name="Email" placeholder="Email" required>
				    </div>
					<div class="col-md-3 mb-3">
					   <label for="Rol">Rol</label> 
					   <br>
					   <select name="Rol" > 
						   <%	RolDaoImpl Rol = new RolDaoImpl();
					 			ArrayList<Rol> ListaRol =  Rol.readAll();
								if(ListaRol != null)
								{
									for(Rol List : ListaRol){
								       %><option value="<%=List.getId() %>"><%=List.getDescripcion() %> </option><%
								       }		
								}			
							%> 
						</select>
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
					<input class="btn btn-primary col-md-1" type="submit" value="Aceptar" name="btnAceptar">
					<input class="btn btn-primary col-md-1" type="submit" value="Cancelar" name="btnCancelar">
				</form>
				</div> 
		
		</div>		
	</div>	
</div>




	
	
	
	
</body>
</html>