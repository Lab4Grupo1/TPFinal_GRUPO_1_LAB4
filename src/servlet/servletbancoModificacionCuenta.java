package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;
import entidad.Cuentas;
import entidad.DatosPersonales;
import negocio.DatosPersonalesNegocio;
import negocio.TiposCuentaNegocio;

import javax.servlet.RequestDispatcher;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.DatosPersonalesNegocioImpl;
import negocioImpl.TiposCuentaNegocioImpl;


@WebServlet("/servletbancoModificacionCuenta")
public class servletbancoModificacionCuenta extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
       public servletbancoModificacionCuenta() {
        super();
           }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		if (request.getParameter("btnBuscar") != null){
			int dni=Integer.parseInt(request.getParameter("DNI")); 
			DatosPersonalesNegocioImpl DPNI=new DatosPersonalesNegocioImpl();
			DatosPersonales DPBuscar=DPNI.buscarDNI(dni);
			CuentasNegocioImpl CNI=new CuentasNegocioImpl();
			Cuentas CBuscar=CNI.buscarDni(dni);
			
			if (DPBuscar.getDni()==dni){
				request.setAttribute("Cuentas", CBuscar);
				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("bancoCuentaModificacion.jsp");
				rd.forward(request, response);
			}else{
				System.out.println("NO HAY CUENTAS ASOCIADAS");
			}			
		}
		
		if(request.getParameter("btnAceptar")!=null){
			CuentasNegocioImpl CNI=new CuentasNegocioImpl();
			Cuentas C=new Cuentas();
			TiposCuentaNegocio TCN=new TiposCuentaNegocioImpl();
			DatosPersonalesNegocio DPN= new DatosPersonalesNegocioImpl(); 
			
			C.setDniCliente(DPN.buscarDNI(Integer.parseInt(request.getParameter("LabelDNI"))));
			C.setSaldo(Double.parseDouble(request.getParameter("Saldo")));
			C.setTipoCuenta(TCN.buscarId(Integer.parseInt(request.getParameter("TipoCuenta"))));
			C.setNumeroCuenta(Integer.parseInt(request.getParameter("TipoCuentaActiva")));  
			int filaCNI= CNI.update(C); 
			
			if (filaCNI==1){
				HttpSession sesionMensajes = request.getSession();			
				sesionMensajes.setAttribute("Confirmacion", "LA CUENTA SE MODIFICO CON EXITO");
				
				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
				rd.forward(request, response);
			}			
		}	 
	}
}
