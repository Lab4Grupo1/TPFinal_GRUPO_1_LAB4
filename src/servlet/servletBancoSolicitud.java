package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SolicitudDao;
import daoImpl.SolicitudDaoImpl;
import entidad.Solicitud;

/**
 * Servlet implementation class servletBancoSolicitud
 */
@WebServlet("/servletBancoSolicitud")
public class servletBancoSolicitud extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBancoSolicitud() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Solicitud> lista =new ArrayList<Solicitud>();
		if(request.getParameter("btnBuscar")!=null) {
			String cuenta =request.getParameter("txtCliente").toString();
			
			;
			
			SolicitudDaoImpl soli = new SolicitudDaoImpl();
			lista =(ArrayList<Solicitud>)soli.buscar(cuenta);
			
			request.setAttribute("lista", lista);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/bancoSolicitudes.jsp");
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
