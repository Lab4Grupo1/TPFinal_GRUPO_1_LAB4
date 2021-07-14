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
import entidad.TipoMovimiento;
import negocio.CuentasNegocio;
import negocio.MovimientosNegocio;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.MovimientosNegocioImpl;

@WebServlet("/servletClienteTransf_Terceros")
public class servletClienteTransf_Terceros extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletClienteTransf_Terceros() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnAceptar") != null) {

			String Desde = request.getParameter("CuentaDesde");
			int desdeI = Integer.parseInt(Desde);
			String monto = request.getParameter("monto");
			int montoI = Integer.parseInt(monto);
			String CBU = request.getParameter("CBU");
			double cbuI = Double.parseDouble(CBU);

			CuentasNegocio cnDesc = new CuentasNegocioImpl();

			HttpSession sessionUsuario = request.getSession();
			int dni = (int) sessionUsuario.getAttribute("SesionDNI");

			ArrayList<Cuentas> ListaCDesde = cnDesc.ListarCuentas(dni);

			for (Cuentas cuentasDesde : ListaCDesde) {
				if (cuentasDesde.getSaldo() >= montoI) {
					if (cuentasDesde.getNumeroCuenta() == desdeI) {
						System.out.println("desde -->" + desdeI);
						double descontar = cuentasDesde.getSaldo() - montoI;
						cnDesc.updateMonto(descontar, dni, desdeI);
						
						/*Transferencia movimiento*/
						Movimientos mov = new Movimientos();
						MovimientosNegocio MovNeg = new MovimientosNegocioImpl();
						
						/*Tipo Movimiento = 4 - transf cuenta*/
						TipoMovimiento tpM = new TipoMovimiento();
						tpM.setId(4);
						
						mov.setDetalle("Se debita desde cuenta " + cuentasDesde.getTipoCuenta().getDescripcion() + " : " + desdeI + " $"+montoI );
						mov.setFecha(LocalDate.now());
						mov.setImporte(montoI);
						mov.setTipoMovimiento(tpM);
						mov.setCuenta(cuentasDesde);
						
						MovNeg.insert(mov);
						
						
					}
				}
			}

			ArrayList<Cuentas> ListaCHasta = cnDesc.ListarCuentasCBU(cbuI);
			for (Cuentas cuentasCHasta : ListaCHasta) {
				System.out.println("desde -->" + cuentasCHasta.getNumeroCuenta());
				double Transf = cuentasCHasta.getSaldo() + montoI;
				cnDesc.updateMonto(Transf, cuentasCHasta.getDniCliente().getDni(), cuentasCHasta.getNumeroCuenta());
				
				/*Transferencia movimiento*/
				Movimientos mov = new Movimientos();
				MovimientosNegocio MovNeg = new MovimientosNegocioImpl();
				
				/*Tipo Movimiento = 4 - transf cuenta*/
				TipoMovimiento tpM = new TipoMovimiento();
				tpM.setId(4);
				
				mov.setDetalle("Se acredita en cuenta " + cuentasCHasta.getTipoCuenta().getDescripcion() + ": " + cuentasCHasta.getNumeroCuenta() + " $"+Transf );
				mov.setFecha(LocalDate.now());
				mov.setImporte(montoI);
				mov.setTipoMovimiento(tpM);
				mov.setCuenta(cuentasCHasta);
				
				MovNeg.insert(mov);
			}

			HttpSession sesionMensajes = request.getSession();
			sesionMensajes.setAttribute("Confirmacion", "La transferencia se realizo con exito!!");

			// REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("confirmacionCliente.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}