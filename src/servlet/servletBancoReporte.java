package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Movimientos;
import negocio.MovimientosNegocio;
import negocioImpl.MovimientosNegocioImpl;

/**
 * Servlet implementation class servletBancoReporte
 */
@WebServlet("/servletBancoReporte")
public class servletBancoReporte extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
    public servletBancoReporte() {
        super(); 
    }

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnBuscar")!=null) {

			String desde = (String) request.getParameter("Desde");
			String hasta = (String) request.getParameter("Hasta");
			
			HttpSession sesionFiltroMov = request.getSession();		

			sesionFiltroMov.setAttribute("desde", desde);
			sesionFiltroMov.setAttribute("hasta", hasta); 

			// REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoInformes.jsp");
			rd.forward(request, response);
			
			
		}
 
	} 
	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
	}

}
