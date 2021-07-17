package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/servletBancoInformesPrestamos")
public class servletBancoInformesPrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletBancoInformesPrestamos() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("btnBuscar")!=null) {

			String desde = (String) request.getParameter("Desde");
			String hasta = (String) request.getParameter("Hasta");
			
			HttpSession sesionFiltroPres = request.getSession();		

			sesionFiltroPres.setAttribute("desde", desde);
			sesionFiltroPres.setAttribute("hasta", hasta); 

			// REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoInformesPrestamos.jsp");
			rd.forward(request, response);
			
			
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
