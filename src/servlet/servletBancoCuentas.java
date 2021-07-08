package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import entidad.Cuentas;
import entidad.TipoCuentas;
import entidad.Usuario;
import negocio.UsuarioNegocio;
import entidad.DatosPersonales;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.DatosPersonalesNegocioImpl;
import negocioImpl.TiposCuentaNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/servletBancoCuentas")
public class servletBancoCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletBancoCuentas() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sesionMensajes = request.getSession();

		if (request.getParameter("btnAceptar") != null) {
			int dni = Integer.parseInt(request.getParameter("DNICliente"));
			String usuario = request.getParameter("UsuarioCliente");

			UsuarioNegocio uni = new UsuarioNegocioImpl();
			Usuario u = null;
			
			u = uni.obtenerUnUsuario(dni, usuario);

			if (u.getdp_DNI() != null) {

				double cbu = dni + 1000000;
				LocalDate FechaCreacion = LocalDate.now();
				String Saldo = request.getParameter("Saldo");
				double SaldoD = Double.parseDouble(Saldo);
				String TCuenta = request.getParameter("TipoCuenta");

				TiposCuentaNegocioImpl TPi = new TiposCuentaNegocioImpl();
				TipoCuentas tP = new TipoCuentas();
				tP = TPi.buscarId(Integer.parseInt(TCuenta));

				DatosPersonalesNegocioImpl dpNeg = new DatosPersonalesNegocioImpl();
				DatosPersonales dp = new DatosPersonales();

				dp = dpNeg.buscarDNI(dni);

				Cuentas c = new Cuentas();
				c.setCbu(cbu);
				c.setFechaCreacion(FechaCreacion);
				c.setSaldo(SaldoD);
				c.setEstado(true);
				c.setTipoCuenta(tP);
				c.setDniCliente(dp);

				CuentasNegocioImpl cImp = new CuentasNegocioImpl();
				int insert = cImp.insert(c);

				if (insert > 0) {
					sesionMensajes.setAttribute("Confirmacion", "La cuenta se cre� con exito!!");

					// REQUESTDISPATCHER
					RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
					rd.forward(request, response);
				} else {
					// REQUESTDISPATCHER
					RequestDispatcher rd = request.getRequestDispatcher("bancoCuentasAlta.jsp");
					rd.forward(request, response);
				}

			} else {
				// REQUESTDISPATCHER
				sesionMensajes.setAttribute("Confirmacion", "El usuario no existe!!");
				RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
				rd.forward(request, response);
			}

		}
	}

}