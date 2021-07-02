package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
			 
			
			 //Formato de fecha (día/mes/año)
	        SimpleDateFormat formatoFecha = new SimpleDateFormat("DD/MM/YYYY");
	        formatoFecha.setLenient(false);
	        //Comprobación de la fecha
	        try {
				formatoFecha.parse(request.getParameter("FechaNacimiento"));
			} catch (ParseException e) { 
				e.printStackTrace();
			} 
	        
			HttpSession sesionAltaCliente = request.getSession();		
			
			sesionAltaCliente.setAttribute("Nombre", request.getParameter("Nombre")); 
			sesionAltaCliente.setAttribute("Apellido", request.getParameter("Apellido"));
			sesionAltaCliente.setAttribute("FechaNacimiento",request.getParameter("FechaNacimiento"));
			sesionAltaCliente.setAttribute("DNI", request.getParameter("DNI")); 
			sesionAltaCliente.setAttribute("CUIL", request.getParameter("CUIL")); 
			sesionAltaCliente.setAttribute("Direccion", request.getParameter("Direccion")); 
			sesionAltaCliente.setAttribute("Localidad", request.getParameter("Localidad")); 
			sesionAltaCliente.setAttribute("Provincia", request.getParameter("Provincia")); 
			sesionAltaCliente.setAttribute("Nacionalidad", request.getParameter("Nacionalidad")); 
			sesionAltaCliente.setAttribute("Telefono", request.getParameter("Telefono")); 
			sesionAltaCliente.setAttribute("Email", request.getParameter("Email")); 
			sesionAltaCliente.setAttribute("Rol", request.getParameter("Rol"));  
			sesionAltaCliente.setAttribute("Sexo", request.getParameter("Sexo"));    
			
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoGestionPassAlta.jsp");
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
