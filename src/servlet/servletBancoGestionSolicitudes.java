package servlet;

import java.io.IOException;
import java.time.LocalDate;

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
import entidad.Solicitud;
import entidad.TipoMovimiento;
import negocio.MovimientosNegocio;
import negocio.PrestamosNegocio;
import negocio.SolicitudNegocio;
import negocioImpl.MovimientosNegocioImpl;
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
		int Nsoli = Integer.parseInt(session.getAttribute("Nsoli").toString());

		if (request.getParameter("btnAceptar") != null) {

			Solicitud soli2 = null;
			Prestamos pres = new Prestamos();
			PrestamosNegocio presImpl = new PrestamosNegocioImpl();

			if (session.getAttribute("Nsoli") != null) {
				System.out.println("error: " + Nsoli);

				soli2 = (Solicitud) dao.buscarSolicitud(Nsoli);
				presImpl = new PrestamosNegocioImpl();
				
				LocalDate Inicial = LocalDate.of(2099 ,12 , 31);

				pres.setNumeroCuenta(soli2.getNumeroCuenta());
				pres.setCuotasPagas(0);
				pres.setCuotasTotal(soli2.getCantCuotasSolicitado());
				pres.setImportePedidoTotal(soli2.getMontoSolicitado());
				pres.setFechaUltimoPago(Inicial);

				float valor = (int) (soli2.getMontoSolicitado() / soli2.getCantCuotasSolicitado());
				pres.setImporteCuota(valor);
				// pres.getFechaUltimoPago("2021/07/05");
			}
			System.out.println("error2: " + Nsoli);

			int listo = dao.updateSolicitud(Nsoli);
			
			if (listo > 0) {
				if (presImpl.insertPrestamo(pres) == true) {
					if (dao.UpdateSumarPrestamo(soli2.getNumeroCuenta(), soli2.getMontoSolicitado()) > 0) {
						
						Cuentas cn = new Cuentas(); 
						cn.setNumeroCuenta(soli2.getNumeroCuenta());
						
						/*Deposito movimiento*/
						Movimientos mov = new Movimientos();
						MovimientosNegocio MovNeg = new MovimientosNegocioImpl();
						
						/*Tipo Movimiento = 6 - transf cuenta*/
						TipoMovimiento tpM = new TipoMovimiento();
						tpM.setId(6);
						
						mov.setDetalle("Prestamo aceptado, se deposita:" +  soli2.getMontoSolicitado() );
						mov.setFecha(LocalDate.now());
						mov.setImporte(soli2.getMontoSolicitado());
						mov.setTipoMovimiento(tpM);
						mov.setCuenta(cn);
						
						MovNeg.insert(mov);
						
						
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
			   
			HttpSession pepito = request.getSession(); 

			int listo2 = dao.UpdateRechazoSolicitud(Integer.parseInt(pepito.getAttribute("Nsoli").toString())); 
			
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
