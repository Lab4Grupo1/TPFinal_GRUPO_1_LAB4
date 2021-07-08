package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Solicitud;
import negocioImpl.SolicitudNegocioImpl;

@WebServlet("/servletClientePrestamos")
public class servletClientePrestamos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletClientePrestamos() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnAceptar") != null) {

			String imp = request.getParameter("Importe");
			String cant = request.getParameter("CantidadCuotas");
			String TipoCuenta = request.getParameter("TipoCuenta");
			int Cuenta = Integer.parseInt(TipoCuenta);
			double importe = Double.parseDouble(imp);
			int cuotas = Integer.parseInt(cant);

			if (importe != 0 && cuotas != 0) {

				Solicitud s = new Solicitud();
				SolicitudNegocioImpl SNimp = new SolicitudNegocioImpl();

				s.setCuentaDepositar(Cuenta);
				s.setMontoSolicitado(importe);
				s.setCantCuotasSolicitado(cuotas);
				s.setEstadoSolicitud("Pendiente");

				int res = SNimp.insert(s);
			}
			
			HttpSession sesionMensajes = request.getSession();			
			sesionMensajes.setAttribute("Confirmacion", "El prestamo se realizo con exito!!");
			
			// REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("confirmacionCliente.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
