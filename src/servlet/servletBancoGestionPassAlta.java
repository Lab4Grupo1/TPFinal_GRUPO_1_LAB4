package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Telefonos;
import entidad.Usuario;
 
@WebServlet("/servletBancoGestionPassAlta")
public class servletBancoGestionPassAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public servletBancoGestionPassAlta() {
        super(); 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{			
			HttpSession sesionAltaCliente = request.getSession(); 
			
			Object Nombre = (String) sesionAltaCliente.getAttribute("Nombre");
			Object Apellido = (String) sesionAltaCliente.getAttribute("Apellido");
			Object FechaNacimiento = (Date) sesionAltaCliente.getAttribute("FechaNacimiento");
			Object DNI = (String) sesionAltaCliente.getAttribute("DNI");
			Object CUIL = (String) sesionAltaCliente.getAttribute("CUIL");
			Object Direccion = (String) sesionAltaCliente.getAttribute("Direccion");
			Object Localidad = (String) sesionAltaCliente.getAttribute("Localidad");
			Object Provincia = (String) sesionAltaCliente.getAttribute("Provincia");
			Object Nacionalidad = (String) sesionAltaCliente.getAttribute("Nacionalidad");
			Object Telefono = (Number) sesionAltaCliente.getAttribute("Telefono");
			Object Email = (String) sesionAltaCliente.getAttribute("Email");
			Object Tipo = (String) sesionAltaCliente.getAttribute("Tipo");
			Object Sexo = (String) sesionAltaCliente.getAttribute("Sexo"); 

			

		 
			Usuario u  =  new Usuario(null, null, null, null, false); 
			
			Telefonos t = new Telefonos(null, null);
  
			
			
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoClienteAlta.jsp");
			rd.forward(request, response);
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
