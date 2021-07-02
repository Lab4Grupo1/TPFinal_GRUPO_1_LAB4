package servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.NacionalidadDaoImpl;
import daoImpl.RolDaoImpl;
import daoImpl.TelefonosDaoImpl;
import daoImpl.UsuarioDaoImpl;
import entidad.DatosPersonales;
import entidad.Nacionalidad;
import entidad.Telefonos;
import entidad.Usuario;
 
@WebServlet("/servletBancoGestionPassAlta")
public class servletBancoGestionPassAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
    public servletBancoGestionPassAlta() {
        super(); 
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{			
			
			/*Traigo valores de la sesion Alta Usuario*/
			HttpSession sesionAltaCliente = request.getSession();			
			String Nombre = (String) sesionAltaCliente.getAttribute("Nombre");
			String Apellido = (String) sesionAltaCliente.getAttribute("Apellido");
			//Date FechaNacimiento = (Date) sesionAltaCliente.getAttribute("FechaNacimiento");
			int DNI = (int) sesionAltaCliente.getAttribute("DNI");
			int CUIL = (int) sesionAltaCliente.getAttribute("CUIL");
			String Direccion = (String) sesionAltaCliente.getAttribute("Direccion");
			String Localidad = (String) sesionAltaCliente.getAttribute("Localidad");
			String Provincia = (String) sesionAltaCliente.getAttribute("Provincia");
			int Nacionalidad = (int) sesionAltaCliente.getAttribute("Nacionalidad");
			String Telefono = (String) sesionAltaCliente.getAttribute("Telefono");
			String Email = (String) sesionAltaCliente.getAttribute("Email");
			int Rol = (int) sesionAltaCliente.getAttribute("Rol");
			String Sexo = (String) sesionAltaCliente.getAttribute("Sexo"); 
			
			request.setAttribute("Nombre", Nombre);			

			/*Inserto en Telefono*/
			Telefonos num = new Telefonos();
			TelefonosDaoImpl tel = new TelefonosDaoImpl();			
			num.setNumero(Telefono);
			int idTel = tel.insert(num);
			num.setId(idTel);			

			/*Inserto en Datos Personales*/
			NacionalidadDaoImpl nac = new NacionalidadDaoImpl();			
			DatosPersonales dp = new DatosPersonales();
			dp.setDni(DNI);
			dp.setCuil(CUIL);
			dp.setNombre(Nombre);
			dp.setApellido(Apellido);
			dp.setSexo(Sexo);
		//	dp.setFechaNacimiento(FechaNacimiento);
			dp.setDireccion(Direccion);
			dp.setLocalidad(Localidad);
			dp.setProvincia(Provincia);
			dp.setMail(Email);
			dp.setNacionalidad(nac.buscarId(Nacionalidad));
			dp.setTelefono(num);
			 

			/*Creo el usuario con Nombre Apellido DNI*/
            String DNIUs = Integer.toString(DNI).substring(0, 3);
            String nombreUs = Nombre.substring(0, 3);
            String apellidoUs = Apellido.substring(0, 3);
            String Usuario = DNIUs + apellidoUs + nombreUs; 
			

			/*Inserto en usuario*/
			UsuarioDaoImpl usuario = new UsuarioDaoImpl();
			Usuario u = new Usuario();
			
			RolDaoImpl rol1 = new RolDaoImpl();
			
			u.setNombreUsuario(Usuario);
			u.setContraseña(request.getParameter("NuevaPassRepetir"));
			u.setRol(rol1.buscarId(Rol));
			u.setDatosPersonales(dp);
			u.setEstado(true); 
			
			usuario.insert(u);
			 
			
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoClienteAlta.jsp");
			rd.forward(request, response);
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
