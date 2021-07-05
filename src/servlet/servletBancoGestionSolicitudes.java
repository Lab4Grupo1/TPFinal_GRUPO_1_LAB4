package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.SolicitudDaoImpl;
import entidad.Solicitud;

/**
 * Servlet implementation class servletBancoGestionSolicitudes
 */
@WebServlet("/servletBancoGestionSolicitudes")
public class servletBancoGestionSolicitudes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBancoGestionSolicitudes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("txtUrl")!=null){
			SolicitudDaoImpl dao = new SolicitudDaoImpl();
			Solicitud soli= new Solicitud();
			 int Nsoli=Integer.parseInt(request.getParameter("txtUrl").toString());
			
			 soli=(Solicitud)dao.buscarSolicitud(Nsoli);
			 
			 request.setAttribute("solic", soli);
			 RequestDispatcher rd= request.getRequestDispatcher("/bancoGestionSolicitudes.jsp");
			 rd.forward(request, response);
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
