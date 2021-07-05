package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import entidad.Cuentas;
import entidad.TipoCuentas;
import entidad.DatosPersonales; 
import daoImpl.TipoCuentasDaoImpl;
import daoImpl.CuentasDaoImpl;
import daoImpl.DatosPersonalesDaoImpl;


@WebServlet("/servletBancoCuentas")
public class servletBancoCuentas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     public servletBancoCuentas() 
     {
     }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println( "Paso 1");
		
		if(request.getParameter("btnBuscar")==null)
		{
			System.out.println("Paso 2");
			if(request.getParameter("btnAceptar")!=null)
			{	   
				String UsuarioCliente=request.getParameter("UsuarioCliente");	
				String DNICliente=(String)request.getParameter("DNICliente");
				int DniInt=Integer.parseInt(DNICliente);
				
				Float litersOfPetrol=Float.parseFloat(request.getParameter("Saldo"));
				//DecimalFormat S=(DecimalFormat) litersOfPetrol;				
				String TipoCuenta=(String)request.getParameter("TipoCuenta");
			    int TipoCuentaInt=Integer.parseInt(TipoCuenta);
				Cuentas cta = new Cuentas();
				CuentasDaoImpl ctaDI = new CuentasDaoImpl();
				
				String FechaCreacion = (String)request.getParameter("FechaCreacion");  
				String yyyyy = FechaCreacion.substring(0, 4);
			    String mmm = FechaCreacion.substring(5, 7);
			    String dd = FechaCreacion.substring(8, 10); 
		
			    LocalDate FechaCre = LocalDate.of(Integer.parseInt(yyyyy),Integer.parseInt(mmm),Integer.parseInt(dd));		 
	       
			    DatosPersonalesDaoImpl DPI=new DatosPersonalesDaoImpl();
			    DatosPersonales DP=new DatosPersonales();
			    DP=DPI.buscarDNI(DniInt);
			    
			    TipoCuentasDaoImpl TCI=new TipoCuentasDaoImpl();
			    TipoCuentas TC=new TipoCuentas();
			    TC=TCI.buscarId(TipoCuentaInt);
			    
				cta.setFechaCreacion(FechaCre);				
				
				cta.setSaldo(S);
				cta.setTipoCuenta(TC);
				cta.setDniCliente(DP);
				System.out.println(DP.getDni());
				
								
				int idCta = ctaDI.insert(cta);
				cta.setCbu(idCta); 
				
				System.out.println(idCta +"Insert Cuenta");

				
		    }
			
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoCuentas.jsp");
			rd.forward(request, response);
		}
		
		
		
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}


}
