package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;


@WebServlet("/servletBancoGestionPassModificacion")
public class servletBancoGestionPassModificacion extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public servletBancoGestionPassModificacion() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{
			int passVieja = 0;
			int passNueva = 0; 
			
			if (request.getParameter("PassUrlVieja").equals(request.getParameter("ViejaPass"))) {				
				passVieja = 1;
				
			}else {
				System.out.println("Contraseñas viejas no coinciden");				
			}
				
			if (request.getParameter("NuevaPass").equals(request.getParameter("NuevaPassRepetir"))) {
				passNueva = 1;
				
			}else {
				System.out.println("Contraseñas nuevas no coinciden");
			}
			
			if(passVieja == 1 && passNueva == 1) {
				
				UsuarioDaoImpl udp = new UsuarioDaoImpl();
				int updatePass = udp.updatePass(request.getParameter("NuevaPass"), request.getParameter("UsuarioUrl"));
				
				RequestDispatcher rd = request.getRequestDispatcher("bancoModificarCliente.jsp");
				rd.forward(request, response);
			}
			
		}		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
