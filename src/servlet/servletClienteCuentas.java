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
import negocio.CuentasNegocio;
import negocio.MovimientosNegocio;
import negocio.TiposCuentaNegocio;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.MovimientosNegocioImpl;
import negocioImpl.TiposCuentaNegocioImpl;

@WebServlet("/servletClienteCuentas")
public class servletClienteCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletClienteCuentas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// carga session
		HttpSession sesion1 = request.getSession();
		sesion1.setAttribute("dni", "1");

		// uso session
		int dni = Integer.parseInt(sesion1.getAttribute("dni").toString());

		if (request.getParameter("idTipoCuenta") != null) {

			int tip = Integer.parseInt(request.getParameter("idTipoCuenta"));

			MovimientosNegocio mov = new MovimientosNegocioImpl();
			TiposCuentaNegocio tipImp = new TiposCuentaNegocioImpl();
			CuentasNegocio cueImp = new CuentasNegocioImpl();
			ArrayList<Movimientos> Lmov = mov.buscarDNI(dni, tip);

			request.setAttribute("tipoCuenta", tipImp.buscarId(tip).getDescripcion());
			request.setAttribute("numCuenta", cueImp.buscarDni(dni).getNumeroCuenta());

			try {
				if (Lmov != null) {
					for (Movimientos list : Lmov) {
						request.setAttribute("Lmov", Lmov);
						list.notify();
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}

			HttpSession sesionMensajes = request.getSession();
			sesionMensajes.setAttribute("Confirmacion", "El alta de cuenta se realizo con exito!!");

			// REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("confirmacionCliente.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}
}