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

import entidad.DatosPersonales;
import entidad.Telefonos;
import entidad.Usuario;
import negocioImpl.DatosPersonalesNegocioImpl;
import negocioImpl.TelefonosNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/servletBancoModificacionCliente")
public class servletBancoModificacionCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletBancoModificacionCliente() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnBuscar") != null) {
			int dni = Integer.parseInt(request.getParameter("DNICliente"));
			String NombreCliente = request.getParameter("NombreCliente");
			
			

			DatosPersonalesNegocioImpl dpB = new DatosPersonalesNegocioImpl();
			UsuarioNegocioImpl uB = new UsuarioNegocioImpl();
			TelefonosNegocioImpl tB = new TelefonosNegocioImpl();
			
			DatosPersonales dpBusqueda = null;
			Usuario uBusqueda = null;
			Telefonos tBusqueda = null;
			
			try {				
				 dpBusqueda = dpB.buscarDNI(dni);
				 uBusqueda = uB.obtenerUnUsuario(dni, NombreCliente);
				 tBusqueda = tB.buscarId(dpBusqueda.getTelefono().getId());
				
			} catch (Exception e) {
				System.out.println("Datos incorrectos");
				HttpSession sesionMensajes = request.getSession();
				sesionMensajes.setAttribute("Confirmacion", "Datos incorrectos");
				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
				rd.forward(request, response);
			} 
			 
			if(dpBusqueda.getDni() == dni && uBusqueda.getNombreUsuario().toLowerCase().equals(NombreCliente.toLowerCase())){
				request.setAttribute("DatosPersonales", dpBusqueda);
				request.setAttribute("Usuario", uBusqueda);
				request.setAttribute("Telefono", tBusqueda);

				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("bancoModificarCliente.jsp");
				rd.forward(request, response);
				
			}else{
				System.out.println("No hay cliente"); 

				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("bancoModificarCliente.jsp");
				rd.forward(request, response);
			} 
		}

		if (request.getParameter("btnAceptar") != null) {
			/* Convertir datos */
			int DNIentero = Integer.parseInt(request.getParameter("DNI"));

			String FechaNacimiento = (String) request.getParameter("FechaNacimiento");
			String yyyyy = FechaNacimiento.substring(0, 4);
			String mmm = FechaNacimiento.substring(5, 7);
			String dd = FechaNacimiento.substring(8, 10);
			LocalDate FechaNac = LocalDate.of(Integer.parseInt(yyyyy), Integer.parseInt(mmm), Integer.parseInt(dd));

			/* Update en Telefono */
			Telefonos num = new Telefonos();
			TelefonosNegocioImpl tel = new TelefonosNegocioImpl();
			num.setId(Integer.parseInt(request.getParameter("idtel")));
			num.setNumero(request.getParameter("Telefono"));
			tel.update(num);

			/* Update en Datos Personales */
			DatosPersonalesNegocioImpl dpDao = new DatosPersonalesNegocioImpl();
			DatosPersonales dp = new DatosPersonales();
			dp.setDni(DNIentero);
			dp.setCuil(Double.parseDouble(request.getParameter("CUIL")));
			dp.setNombre(request.getParameter("Nombre"));
			dp.setApellido(request.getParameter("Apellido"));
			dp.setFechaNacimiento(FechaNac);
			dp.setDireccion(request.getParameter("Direccion"));
			dp.setLocalidad(request.getParameter("Localidad"));
			dp.setProvincia(request.getParameter("Provincia"));
			dp.setMail(request.getParameter("Email"));
			dp.setTelefono(num);

			int FilaDP = dpDao.update(dp);

			/* Inserto en usuario */
			UsuarioNegocioImpl usuario = new UsuarioNegocioImpl();
			usuario.updateDNI(dp);

			if (FilaDP == 1) {
				HttpSession sesionMensajes = request.getSession();
				sesionMensajes.setAttribute("Confirmacion", "El cliente se modificó con exito!!");

				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
				rd.forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
