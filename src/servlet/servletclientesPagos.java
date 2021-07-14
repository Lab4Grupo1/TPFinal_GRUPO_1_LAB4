package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cuentas;
import entidad.Movimientos;
import entidad.Prestamos;
import entidad.TipoMovimiento;
import negocio.CuentasNegocio;
import negocio.MovimientosNegocio;
import negocio.PrestamosNegocio;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.MovimientosNegocioImpl;
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Prestamos> listaFiltrada = new ArrayList<Prestamos>();
		HttpSession session = request.getSession();

		if (request.getParameter("btnBuscarPrest") != null) {

			String cuenta = request.getParameter("txtNprestamo").toString();
			session.setAttribute("cuenta", cuenta);

			PrestamosNegocio dao = new PrestamosNegocioImpl();
			listaFiltrada = dao.BuscarPrestamo(cuenta);
			request.setAttribute("listafiltrada", listaFiltrada);

			RequestDispatcher rd = request.getRequestDispatcher("/clientePagos.jsp");
			rd.forward(request, response);
		}
		if (request.getParameter("btnPagar") != null) {
			String cuenta = (String) session.getAttribute("cuenta");
			Prestamos pre = new Prestamos();
			PrestamosNegocio dao = new PrestamosNegocioImpl();

			pre = dao.BuscarPrestamos(cuenta);

			int cantidad = Integer.parseInt(request.getParameter("txtCantCuotas").toString());
			pre.setFechaUltimoPago(LocalDate.now());
			pre.setCuotasPagas(cantidad);
			double Importe = pre.getImporteCuota();
			double total = (cantidad * Importe);

			if (dao.ComprobarSaldo(total, cuenta)) {
				
				if (dao.UpdateCuotas(cuenta, cantidad)) {
					
					if (dao.RestarSaldo(pre.getNumeroCuenta(), total)) {
						
						Cuentas cn = new Cuentas();
						cn.setNumeroCuenta(Integer.parseInt(cuenta));
						
						/*Pago movimiento*/
						Movimientos mov = new Movimientos();
						MovimientosNegocio MovNeg = new MovimientosNegocioImpl();
						
						/*Tipo Movimiento = 3 - pago*/
						TipoMovimiento tpM = new TipoMovimiento();
						tpM.setId(3);
						
						mov.setDetalle("Pago: " + pre.getId() + " Cuenta:" + cuenta + " Cantidad:" + cantidad);
						mov.setFecha(LocalDate.now());
						mov.setImporte(total);
						mov.setTipoMovimiento(tpM);
						mov.setCuenta(cn);
						
						MovNeg.insert(mov);
						
						RequestDispatcher rd = request.getRequestDispatcher("clientePagos.jsp");
						rd.forward(request, response);
					}
				}
			}
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
