package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entidad.Prestamos;
import negocioImpl.PrestamosNegocioImpl;

/**
 * Servlet implementation class servletclientesPagos
 */
@WebServlet("/servletclientesPagos")
public class servletclientesPagos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletclientesPagos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Prestamos> listaFiltrada = new ArrayList<Prestamos>();
		if (request.getParameter("btnBuscarPrest") != null) {
			String cuenta =request.getParameter("txtNprestamo").toString();
			
			PrestamosNegocioImpl dao= new PrestamosNegocioImpl();
			listaFiltrada = dao.BuscarPrestamo(cuenta);
			request.setAttribute("listafiltrada", listaFiltrada);
			
			
			RequestDispatcher rd= request.getRequestDispatcher("/clientePagos.jsp");
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
