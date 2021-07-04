package servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.DatosPersonalesDaoImpl;
import daoImpl.NacionalidadDaoImpl;
import daoImpl.RolDaoImpl;
import daoImpl.TelefonosDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.DatosPersonales;
import entidad.Telefonos;
import entidad.Usuario;
import negocioImpl.DatosPersonalesNegocioImpl;
 
@WebServlet("/servletBancoModificacionCliente")
public class servletBancoModificacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public servletBancoModificacionCliente() {
        super(); 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnBuscar")!=null)
		{ 
			int dni = Integer.parseInt(request.getParameter("DNICliente"));
			String NombreCliente = request.getParameter("NombreCliente");
			
			DatosPersonalesDaoImpl dpB = new DatosPersonalesDaoImpl();			
			DatosPersonales dpBusqueda = dpB.buscarDNI(dni);
			
			UsuarioDaoImpl uB = new UsuarioDaoImpl();
			Usuario uBusqueda = uB.obtenerUnUsuario(dni, NombreCliente);
			
			TelefonosDaoImpl tB = new TelefonosDaoImpl(); 
			Telefonos tBusqueda = tB.buscarId(dpBusqueda.getTelefono().getId());  
			
		     
			if(dpBusqueda.getDni() == dni && uBusqueda.getNombreUsuario().toLowerCase().equals(NombreCliente.toLowerCase()))
			{ 
				request.setAttribute("DatosPersonales", dpBusqueda);
				request.setAttribute("Usuario", uBusqueda);
				request.setAttribute("Telefono", tBusqueda);
				
				//REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("bancoModificarCliente.jsp");
				rd.forward(request, response); 
			}
			else {
				System.out.println("No hay cliente");
			} 
		}	
			
		if(request.getParameter("btnAceptar")!=null)		
		{	    
			/*Convertir datos */
			int DNIentero = Integer.parseInt(request.getParameter("DNI"));
			
			String FechaNacimiento = (String) request.getParameter("FechaNacimiento");
		    String yyyyy = FechaNacimiento.substring(0, 4);
		    String mmm = FechaNacimiento.substring(5, 7);
		    String dd = FechaNacimiento.substring(8, 10); 
			LocalDate FechaNac = LocalDate.of(Integer.parseInt(yyyyy),Integer.parseInt(mmm),Integer.parseInt(dd));	
			
			/*Update en Telefono*/
			Telefonos num = new Telefonos();
			TelefonosDaoImpl tel = new TelefonosDaoImpl();				
			num.setId(Integer.parseInt(request.getParameter("idtel")));
			num.setNumero(request.getParameter("Telefono"));
			int idTel = tel.update(num);
		 
			/*Update en Datos Personales*/ 
			DatosPersonalesDaoImpl dpDao = new DatosPersonalesDaoImpl();
			DatosPersonales dp = new DatosPersonales();
			dp.setDni(DNIentero);
			dp.setCuil(request.getParameter("CUIL")); 
			dp.setNombre(request.getParameter("Nombre"));
			dp.setApellido(request.getParameter("Apellido")); 
			dp.setFechaNacimiento(FechaNac);
			dp.setDireccion(request.getParameter("Direccion"));
			dp.setLocalidad(request.getParameter("Localidad"));
			dp.setProvincia(request.getParameter("Provincia"));
			dp.setMail(request.getParameter("Email")); 
			dp.setTelefono(num);
			
			int FilaDP= dpDao.update(dp);  
			
			/*Inserto en usuario*/
			UsuarioDaoImpl usuario = new UsuarioDaoImpl(); 
			int FilaU = usuario.updateDNI(dp);			

			System.out.println(idTel +"-"+ FilaDP +"-"+ FilaU);
			
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoModificarCliente.jsp");
			rd.forward(request, response);
		}
		 
	} 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
