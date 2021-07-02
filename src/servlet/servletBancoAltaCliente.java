package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession; 

@WebServlet("/servletBancoAltaCliente")
public class servletBancoAltaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public servletBancoAltaCliente() {}
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("btnAceptar")!=null)
		{			
			
			//Validar
			
			// negocio.validacion(FechaNacimiento);
			
			HttpSession sesionAltaCliente = request.getSession(); 
			
			sesionAltaCliente.setAttribute("Nombre", request.getParameter("Nombre")); 
			sesionAltaCliente.setAttribute("Apellido", request.getParameter("Apellido"));
			sesionAltaCliente.setAttribute("FechaNacimiento", request.getParameter("FechaNacimiento"));
			sesionAltaCliente.setAttribute("DNI", request.getParameter("DNI")); 
			sesionAltaCliente.setAttribute("CUIL", request.getParameter("CUIL")); 
			sesionAltaCliente.setAttribute("Direccion", request.getParameter("Direccion")); 
			sesionAltaCliente.setAttribute("Localidad", request.getParameter("Localidad")); 
			sesionAltaCliente.setAttribute("Provincia", request.getParameter("Provincia")); 
			sesionAltaCliente.setAttribute("Nacionalidad", request.getParameter("Nacionalidad")); 
			sesionAltaCliente.setAttribute("Telefono", request.getParameter("Telefono")); 
			sesionAltaCliente.setAttribute("Email", request.getParameter("Email")); 
			sesionAltaCliente.setAttribute("Tipo", request.getParameter("Tipo"));  
			sesionAltaCliente.setAttribute("Sexo", request.getParameter("Sexo"));   
			
			//LLamado al --->  validar campos
			
			//Insertar interface negocio / llama al negocio / llamamos a la interface de dao  ->>> se va a dao
			
			
						  
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("BancoGestionPassAlta.jsp");
			rd.forward(request, response);
		}
		 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
