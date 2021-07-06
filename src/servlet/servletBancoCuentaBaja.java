package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;


import daoImpl.CuentasDaoImpl;
import daoImpl.UsuarioDaoImpl;


@WebServlet("/servletBancoCuentaBaja")
public class servletBancoCuentaBaja extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletBancoCuentaBaja() {
        super();
         }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("tbnDardebaja")!=null)
		{	
			
			String Dni= (String)request.getParameter("DNICliente");
			String Nrocuenta=(String)request.getParameter("NroCuenta");
			String Tipocuenta=(String)request.getParameter("TipoCuenta");
			String Saldo=(String)request.getParameter("Saldo");
	
			
			CuentasDaoImpl cBaja = new CuentasDaoImpl();
			int baja = cBaja.delete(Cuentas cuenta); 

		RequestDispatcher rd = request.getRequestDispatcher("bancoCuentaModificacion.jsp");
		rd.forward(request, response);
		}
	}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doGet(request, response);
	}

}
