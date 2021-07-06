package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Date;
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
		if(request.getParameter("btnBuscar")==null)
		{
		
			if(request.getParameter("btnAceptar")!=null)
			{	   
				String UsuarioCliente=request.getParameter("UsuarioCliente");	
				String DNICliente=(String)request.getParameter("DNICliente");
				DatosPersonales DniInt=getInteger(DNICliente);
				//String NumeroCuenta=(String)request.getParameter("NumeroCuenta");
				//int NroCuenta=Integer.parseInt(NumeroCuenta);
				String Saldo=(String)request.getParameter("Saldo");
				float S=(float) Double.parseDouble(Saldo);				
				String TipoCuenta=(String)request.getParameter("TipoCuenta");
			    //verificar si trae un string o id
				System.out.println(request.getParameter("TipoCuenta"));

				TipoCuentas TP=parseInt(TipoCuenta);
				Cuentas cta = new Cuentas();
				CuentasDaoImpl ctaDI = new CuentasDaoImpl();
				
				String FechaCreacion = (String)request.getParameter("FechaCreacion");  
				String yyyyy = FechaCreacion.substring(0, 4);
			    String mmm = FechaCreacion.substring(5, 7);
			    String dd = FechaCreacion.substring(8, 10); 
		
			    LocalDate FechaCre = LocalDate.of(Integer.parseInt(yyyyy),Integer.parseInt(mmm),Integer.parseInt(dd));		 
	       
				cta.setFechaCreacion(FechaCre);				
				//cta.setNumeroCuenta(NroCuenta);
			//	cta.setSaldo(S);
				cta.setTipoCuenta(TP);
				cta.setDniCliente(DniInt);
				
								
				int idCta = ctaDI.insert(cta);
				cta.setCbu(idCta); 
				
				System.out.println(idCta +"Insert Cuenta");

				
		    }
			//REQUESTDISPATCHER
			RequestDispatcher rd = request.getRequestDispatcher("bancoCuentas.jsp");
			rd.forward(request, response);
		}
	}


	private DatosPersonales getInteger(String dNICliente) {
		// TODO Auto-generated method stub
		return null;
	}


	private TipoCuentas parseInt(String tipoCuenta) {
		// TODO Auto-generated method stub
		return null;
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		doGet(request, response);
	}


}
