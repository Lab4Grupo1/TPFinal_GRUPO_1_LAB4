package servlet;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat; 

import java.time.LocalDate; 

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
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar")!=null)
		{	 
			/*Traigo valores de la sesion Alta Usuario*/
			HttpSession sesionAltaCliente = request.getSession();			
			String Nombre = (String) sesionAltaCliente.getAttribute("Nombre"); 
			String Apellido = (String) sesionAltaCliente.getAttribute("Apellido");  
			
			String FechaNacimiento = (String) sesionAltaCliente.getAttribute("FechaNacimiento");  
			
		    String yyyyy = FechaNacimiento.substring(0, 4);
		    String mmm = FechaNacimiento.substring(5, 7);
		    String dd = FechaNacimiento.substring(8, 10); 
		    		    
			LocalDate FechaNac = LocalDate.of(Integer.parseInt(yyyyy),Integer.parseInt(mmm),Integer.parseInt(dd));		 
	       
	        String DNI = (String) sesionAltaCliente.getAttribute("DNI"); 
			int DNIentero = Integer.parseInt(DNI);
			String CUIL = (String) sesionAltaCliente.getAttribute("CUIL");
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
			
			/*Inserto en Telefono*/
			Telefonos num = new Telefonos();
			TelefonosNegocioImpl tel = new TelefonosNegocioImpl();			
			num.setNumero(Telefono);
			int idTel = tel.insert(num);
			num.setId(idTel); 
		 
			/*Inserto en Datos Personales*/
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
			
			int FilaDP= dpDao.insert(dp); 

			/*Creo el usuario con Nombre Apellido DNI*/
            String DNIUs = Integer.toString(DNIentero).substring(0, 3);
            String nombreUs = Nombre.substring(0, 3);
            String apellidoUs = Apellido.substring(0, 3);
            String Usuario = DNIUs + apellidoUs + nombreUs; 
			

			/*Inserto en usuario*/
			UsuarioNegocioImpl usuario = new UsuarioNegocioImpl();
			Usuario u = new Usuario();
			
			RolNegocioImpl rol1 = new RolNegocioImpl();
			
			u.setNombreUsuario(Usuario);
			u.setContraseña((String)request.getParameter("NuevaPassRepetir"));
			u.setRol(rol1.buscarId(Rolentero));
			u.setDatosPersonales(dp);
			u.setEstado(true); 
			
			int FilaU = usuario.insert(u);
			
			System.out.println(idTel +"-"+ FilaDP +"-"+ FilaU);

			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoAltaCliente.jsp");
			rd.forward(request, response);
		}
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 
		doGet(request, response);
	}

}
