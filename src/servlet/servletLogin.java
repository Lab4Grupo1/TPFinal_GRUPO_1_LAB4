package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Usuario;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/servletLogin")
public class servletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletLogin() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnLogin") != null) {
			UsuarioNegocioImpl Uni = new UsuarioNegocioImpl();
			Usuario u = new Usuario();

			u = Uni.logueo(request.getParameter("password"), request.getParameter("usuario"));

			if (u != null) {
				HttpSession sessionUsuario = request.getSession();
				sessionUsuario.setAttribute("SesionUsuario", u.getNombreUsuario());
				sessionUsuario.setAttribute("SesionDNI", u.getdp_DNI().getDni());
				sessionUsuario.setAttribute("SesionRol", u.getRol().getId());

				if (u.isEstado()) {
					if (u.getRol().getId() == 2) {
						// REQUESTDISPATCHER
						RequestDispatcher rd = request.getRequestDispatcher("clienteCuentas.jsp");
						rd.forward(request, response);
					} else {
						// REQUESTDISPATCHER
						RequestDispatcher rd = request.getRequestDispatcher("bancoSolicitudes.jsp");
						rd.forward(request, response);
					}
				} else {
					sessionUsuario.invalidate();
				}
			}
		}
	}
}
