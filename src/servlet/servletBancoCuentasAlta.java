package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import entidad.Cuentas;
import entidad.TipoCuentas;
import entidad.Usuario;
import entidad.DatosPersonales;  
import negocio.DatosPersonalesNegocio;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.DatosPersonalesNegocioImpl;
import negocioImpl.TipoCuentasNegocioImpl;
import negocioImpl.UsuarioNegocioImpl;


@WebServlet("/servletBancoCuentas")
public class servletBancoCuentasAlta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public servletBancoCuentasAlta() 
     {
    	 super();
     }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		if(request.getParameter("btnAceptar")!=null)
		{	    
			int dni = Integer.parseInt(request.getParameter("DNICliente"));
			String usuario = request.getParameter("UsuarioCliente");
			
			UsuarioNegocioImpl uni = new UsuarioNegocioImpl();
			Usuario u = new Usuario();			
			u = uni.obtenerUnUsuario(dni, usuario);
			 
			if(u != null) {
				
				double cbu = dni + 1000000;
				LocalDate FechaCreacion = LocalDate.now();
				String Saldo = request.getParameter("Saldo");
				double SaldoD = Double.parseDouble(Saldo);
				String TCuenta = request.getParameter("TipoCuenta");
				
				TipoCuentasNegocioImpl TPi = new TipoCuentasNegocioImpl();
				TipoCuentas tP = new TipoCuentas();				
				tP = TPi.buscarId(Integer.parseInt(TCuenta));
				
				DatosPersonalesNegocioImpl dpNeg = new DatosPersonalesNegocioImpl();
				DatosPersonales dp = new DatosPersonales();  
				 
				dp = dpNeg.buscarDNI(dni); 
				
				Cuentas  c = new Cuentas();
				c.setCbu(cbu);
				c.setFechaCreacion(FechaCreacion);
				c.setSaldo(SaldoD);
				c.setEstado(true);
				c.setTipoCuenta(tP);
				c.setDniCliente(dp);
				
				CuentasNegocioImpl cImp = new CuentasNegocioImpl();
				int insert = cImp.insert(c);
				
				if(insert == 1) {
					HttpSession sesionMensajes = request.getSession();			
					sesionMensajes.setAttribute("Confirmacion", "La cuenta se creó con exito!!");
					
					// REQUESTDISPATCHER
					RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
					rd.forward(request, response);					
					System.out.println("->"+insert);  
				}else {
					//REQUESTDISPATCHER
					RequestDispatcher rd = request.getRequestDispatcher("bancoCuentasAlta.jsp");
					rd.forward(request, response);
				}
				
			}
			else {
				System.out.println("No existe el cliente");
			}
	
			
	    } 
    } 
	 

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}


}
