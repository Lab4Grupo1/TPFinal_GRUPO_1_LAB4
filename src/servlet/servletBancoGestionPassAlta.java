package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDate;
import java.util.regex.Matcher;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DatosPersonalesDao;
import daoImpl.DatosPersonalesDaoImpl;
import daoImpl.NacionalidadDaoImpl;
import daoImpl.RolDaoImpl;
import daoImpl.TelefonosDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.DatosPersonales;
import entidad.Telefonos;
import entidad.Usuario;
import negocioImpl.DatosPersonalesNegocioImpl;
import negocioImpl.NacionalidadNegocioImpl;
import negocioImpl.RolNegocioImpl;
import negocioImpl.TelefonosNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;

@WebServlet("/servletBancoGestionPassAlta")
public class servletBancoGestionPassAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servletBancoGestionPassAlta() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("btnAceptar") != null) {
			LocalDate FechaNac = null;
			try {
				/* Traigo valores de la sesion Alta Usuario */
				HttpSession sesionAltaCliente = request.getSession();
				int ContBarraFecha = 0;

				String Nombre = (String) sesionAltaCliente.getAttribute("Nombre");
				String Apellido = (String) sesionAltaCliente.getAttribute("Apellido");
				String DNI = (String) sesionAltaCliente.getAttribute("DNI");
				int DNIentero = Integer.parseInt(DNI);
				Double CUIL = (Double) sesionAltaCliente.getAttribute("CUIL");
				String Direccion = (String) sesionAltaCliente.getAttribute("Direccion");
				String Localidad = (String) sesionAltaCliente.getAttribute("Localidad");
				String Provincia = (String) sesionAltaCliente.getAttribute("Provincia");
				String Nacionalidad = (String) sesionAltaCliente.getAttribute("Nacionalidad");
				int Nacionalidadentero = Integer.parseInt(Nacionalidad);
				String Telefono = (String) sesionAltaCliente.getAttribute("Telefono");
				String Email = (String) sesionAltaCliente.getAttribute("Email");
				String Rol = (String) sesionAltaCliente.getAttribute("Rol");
				int Rolentero = Integer.parseInt(Rol);
				String Sexo = (String) sesionAltaCliente.getAttribute("Sexo");

				String FechaNacimiento = (String) sesionAltaCliente.getAttribute("FechaNacimiento");

				if (FechaNacimiento.length() == 10) {
					for (int i = 0; i < FechaNacimiento.length(); i++) {
						char a = FechaNacimiento.charAt(i);
						if (a == '/' && (i == 4 || i == 7)) {

							ContBarraFecha++;
						}
					}
					if (ContBarraFecha == 2) {
						String yyyy = FechaNacimiento.substring(0, 4);
						String mm = FechaNacimiento.substring(5, 7);
						String dd = FechaNacimiento.substring(8, 10);
						FechaNac = LocalDate.of(Integer.parseInt(yyyy), Integer.parseInt(mm), Integer.parseInt(dd));
					} else {
						System.out.println("Error Conversion de fecha");
					}
				} else {
					System.out.println("Formato de fecha incorrecto");
				}

				Telefonos num = new Telefonos();
				TelefonosNegocioImpl tel = new TelefonosNegocioImpl();
				/* Inserto en Telefono */
				num.setNumero(Telefono);
				int idTel = tel.insert(num);
				num.setId(idTel);

				/* Inserto en Datos Personales */
				NacionalidadNegocioImpl nac = new NacionalidadNegocioImpl();
				DatosPersonalesNegocioImpl dpDao = new DatosPersonalesNegocioImpl();
				DatosPersonales dp = new DatosPersonales();

				dp.setDni(DNIentero);
				dp.setCuil(CUIL);
				dp.setNombre(Nombre);
				dp.setApellido(Apellido);
				dp.setSexo(Sexo);
				dp.setFechaNacimiento(FechaNac);
				dp.setDireccion(Direccion);
				dp.setLocalidad(Localidad);
				dp.setProvincia(Provincia);
				dp.setMail(Email);
				dp.setNacionalidad(nac.buscarId(Nacionalidadentero));
				dp.setTelefono(num);

				dpDao.insert(dp);

				/* Creo el usuario con Nombre Apellido DNI */
				String DNIUs = Integer.toString(DNIentero).substring(0, 3);
				String nombreUs = Nombre.substring(0, 3);
				String apellidoUs = Apellido.substring(0, 3);
				String Usuario = DNIUs + apellidoUs + nombreUs;

				/* Inserto en usuario */
				UsuarioNegocioImpl usuario = new UsuarioNegocioImpl();
				Usuario u = new Usuario();

				RolNegocioImpl rol1 = new RolNegocioImpl();

				u.setNombreUsuario(Usuario);
				u.setContrase�a((String) request.getParameter("NuevaPassRepetir"));
				u.setRol(rol1.buscarId(Rolentero));
				u.setDatosPersonales(dp);
				u.setEstado(true);

				int FilaU = usuario.insert(u);
				if (FilaU == 1) {
					HttpSession sesionMensajes = request.getSession();			
					sesionMensajes.setAttribute("Confirmacion", "El usuario se cre� con exito!!");
					
					// REQUESTDISPATCHER
					RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
					rd.forward(request, response);
				} else {
					// REQUESTDISPATCHER
					RequestDispatcher rd = request.getRequestDispatcher("bancoAltaCliente.jsp");
					rd.forward(request, response);
				}

			} catch (Exception e) {
				System.out.println(e);
			}

			// REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoAltaCliente.jsp");
			rd.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
