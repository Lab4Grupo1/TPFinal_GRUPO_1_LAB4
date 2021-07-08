package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImpl.PrestamosDaoImpl;
import daoImpl.SolicitudDaoImpl;
import entidad.Prestamos;
import entidad.Solicitud;
import negocioImpl.PrestamosNegocioImpl;
import negocioImpl.SolicitudNegocioImpl;

/**
 * Servlet implementation class servletBancoGestionSolicitudes
 */
@WebServlet("/servletBancoGestionSolicitudes")
public class servletBancoGestionSolicitudes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servletBancoGestionSolicitudes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SolicitudNegocioImpl dao = new SolicitudNegocioImpl();
		Solicitud soli= new Solicitud();
		HttpSession session = request.getSession();
		
		if(request.getParameter("txtUrl")!=null){
			int Nsoli=Integer.parseInt(request.getParameter("txtUrl").toString());
			soli=(Solicitud)dao.buscarSolicitud(Nsoli);
			
			session.setAttribute("Solicitud", soli);
			request.setAttribute("solic", soli);
			
			 RequestDispatcher rd= request.getRequestDispatcher("/bancoGestionSolicitudes.jsp");
			 rd.forward(request, response);
		}
		
		if(request.getParameter("btnAceptar")!=null)
		{	Solicitud soli2 =(Solicitud)session.getAttribute("Solicitud");
		
			Prestamos pres= new Prestamos();
			PrestamosNegocioImpl presImpl= new PrestamosNegocioImpl();
			
			pres.setNumeroCuenta(soli2.getNumeroCuenta());
			pres.setCuotasPagas(0);
			pres.setCuotasTotal(soli2.getCantCuotasSolicitado());
			pres.setImportePedidoTotal(soli2.getMontoSolicitado());
			
			float valor=(int)(soli2.getMontoSolicitado()/soli2.getCantCuotasSolicitado());
			pres.setImporteCuota(valor);
			//pres.getFechaUltimoPago("2021/07/05");
			
			int listo =dao.updateSolicitud(soli2.getNumeroSolicitud());
			if(listo>0)
			{
				if(presImpl.insertPrestamo(pres) == true) {
					if(dao.UpdateSumarPrestamo(soli2.getNumeroCuenta(), soli2.getMontoSolicitado())>0){
						
						HttpSession sesionMensajes = request.getSession();			
						sesionMensajes.setAttribute("Confirmacion", "El préstamo se fue autorizado con éxito!!");
						
						// REQUESTDISPATCHER
						RequestDispatcher rd = request.getRequestDispatcher("confirmacionBanco.jsp");
						rd.forward(request, response);		
					}
					
				}
				
			}
			
		}
		
		
		if(request.getParameter("btnRechazar")!=null)
		{
			Solicitud soli2 =(Solicitud)session.getAttribute("Solicitud");
			int listo2 =dao.UpdateRechazoSolicitud(soli2.getNumeroSolicitud());
			if(listo2>0)
			{	
				request.setAttribute("listo", listo2);
				RequestDispatcher rd= request.getRequestDispatcher("/bancoSolicitudes.jsp");
				rd.forward(request, response);
			}
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	}

}
