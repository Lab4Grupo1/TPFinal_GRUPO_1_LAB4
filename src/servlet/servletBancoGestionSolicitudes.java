package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Prestamos;
import entidad.Solicitud;
import negocio.PrestamosNegocio;
import negocio.SolicitudNegocio;
import negocioImpl.PrestamosNegocioImpl;
import negocioImpl.SolicitudNegocioImpl;

/**
 * Servlet implementation class servletBancoGestionSolicitudes
 */
@WebServlet("/servletBancoGestionSolicitudes")
public class servletBancoGestionSolicitudes extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletBancoGestionSolicitudes() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		SolicitudNegocio dao = new SolicitudNegocioImpl();
		HttpSession session = request.getSession();
		int Nsoli = 0;

		if (request.getParameter("btnAceptar") != null) {

			Solicitud soli2 = null;
			Prestamos pres = new Prestamos();
			PrestamosNegocio presImpl = new PrestamosNegocioImpl();

			if (session.getAttribute("Nsoli") != null) {

				Nsoli = Integer.parseInt(session.getAttribute("Nsoli").toString());

				System.out.println("error: " + Nsoli);

				soli2 = (Solicitud) dao.buscarSolicitud(Nsoli);
				presImpl = new PrestamosNegocioImpl();

				pres.setNumeroCuenta(soli2.getNumeroCuenta());
				pres.setCuotasPagas(0);
				pres.setCuotasTotal(soli2.getCantCuotasSolicitado());
				pres.setImportePedidoTotal(soli2.getMontoSolicitado());

				float valor = (int) (soli2.getMontoSolicitado() / soli2.getCantCuotasSolicitado());
				pres.setImporteCuota(valor);
				// pres.getFechaUltimoPago("2021/07/05");
			}

			int listo = dao.updateSolicitud(Nsoli);
			if (listo > 0) {
				if (presImpl.insertPrestamo(pres) == true) {
					if (dao.UpdateSumarPrestamo(soli2.getNumeroCuenta(), soli2.getMontoSolicitado()) > 0) {
						session.setAttribute("Confirmacion", "El préstamo se fue autorizado con éxito!!");

						// REQUESTDISPATCHER
						RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
						rd.forward(request, response);
					}

				}

			} else {
				session.setAttribute("Confirmacion", "No se realizó la autorización");

				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
				rd.forward(request, response);
			}

		}

		if (request.getParameter("btnRechazar") != null) {
			Solicitud soli2 = (Solicitud) session.getAttribute("Solicitud");
			int listo2 = dao.UpdateRechazoSolicitud(soli2.getNumeroSolicitud());
			if (listo2 > 0) {
				request.setAttribute("listo", listo2);
				RequestDispatcher rd = request.getRequestDispatcher("/bancoSolicitudes.jsp");
				rd.forward(request, response);
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

	}

}
