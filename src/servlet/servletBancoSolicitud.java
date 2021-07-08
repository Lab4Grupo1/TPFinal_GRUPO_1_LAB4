package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Solicitud;
import negocioImpl.SolicitudNegocioImpl;

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
			
			SolicitudNegocioImpl soli = new SolicitudNegocioImpl();
			lista =(ArrayList<Solicitud>)soli.buscar(cuenta);
			
			request.setAttribute("lista", (ArrayList<Solicitud>) lista);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/bancoSolicitudes.jsp");
			rd.forward(request, response);
		}
		if(request.getParameter("btnGestionar")!=null) {
			RequestDispatcher rd;
			rd= request.getRequestDispatcher("/bancoGesionSolicitudes.jsp");
			rd.forward(request,response);
		}
}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		}		
}
