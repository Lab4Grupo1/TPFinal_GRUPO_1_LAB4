package servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entidad.Cuentas;
import entidad.Movimientos;
import entidad.TipoMovimiento;
import negocio.CuentasNegocio;
import negocio.MovimientosNegocio;
import negocioImpl.CuentasNegocioImpl;
import negocioImpl.MovimientosNegocioImpl;

@WebServlet("/servletClienteTransf_CuentaPropia")
public class servletClienteTransf_CuentaPropia extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public servletClienteTransf_CuentaPropia() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnAceptar") !=  null) {
			
			String Desde = request.getParameter("CuentaDesde");
			int desdeI = Integer.parseInt(Desde);
			String Hasta = request.getParameter("CuentaHasta");			
			int hastaI = Integer.parseInt(Hasta);
			String monto = request.getParameter("monto");
			int montoI = Integer.parseInt(monto); 
			/*Descontar*/
			
			System.out.println(desdeI);
			System.out.println(hastaI);
			
			if(desdeI != hastaI){
				/*Descontar*/
				CuentasNegocio cnDesc = new CuentasNegocioImpl();
				
				HttpSession sessionUsuario = request.getSession();
				int dni = (int) sessionUsuario.getAttribute("SesionDNI");
				
				ArrayList<Cuentas> ListaC = cnDesc.ListarCuentas(dni);
				for (Cuentas cuentas : ListaC) {
					if(cuentas.getSaldo() >= montoI) {
						if(cuentas.getNumeroCuenta() == desdeI ) {
							double descontar = cuentas.getSaldo() - montoI;
							cnDesc.updateMonto(descontar, dni, desdeI);
							
							/*Transferencia movimiento*/
							Movimientos mov = new Movimientos();
							MovimientosNegocio MovNeg = new MovimientosNegocioImpl();
							
							/*Tipo Movimiento = 4 - Transferencia*/
							TipoMovimiento tpM = new TipoMovimiento();
							tpM.setId(4);
							
							mov.setDetalle("Se debita desde " + cuentas.getTipoCuenta().getDescripcion() + " : " + desdeI + " $"+montoI );
							mov.setFecha(LocalDate.now());
							mov.setImporte(montoI);
							mov.setTipoMovimiento(tpM);
							mov.setCuenta(cuentas);
							
							MovNeg.insert(mov);
							
						}
						if(cuentas.getNumeroCuenta() == hastaI ) {
							double Transf = cuentas.getSaldo() + montoI;
							cnDesc.updateMonto(Transf, dni, hastaI);
							
							/*Transferencia movimiento*/
							Movimientos mov = new Movimientos();
							MovimientosNegocio MovNeg = new MovimientosNegocioImpl();
							
							/*Tipo Movimiento = 4 - Transferencia*/
							TipoMovimiento tpM = new TipoMovimiento();
							tpM.setId(4);
							
							mov.setDetalle("Se acredita en " + cuentas.getTipoCuenta().getDescripcion() + " : " + hastaI + " $ " +montoI );
							mov.setFecha(LocalDate.now());
							mov.setImporte(montoI);
							mov.setTipoMovimiento(tpM);
							mov.setCuenta(cuentas);
							
							MovNeg.insert(mov);
						}						
					}
				} 

				HttpSession sesionMensajes = request.getSession();			
				sesionMensajes.setAttribute("Confirmacion", "La transferencia se realizo con exito!!");
				
				// REQUESTDISPATCHER
				RequestDispatcher rd = request.getRequestDispatcher("confirmacionCliente.jsp");
				rd.forward(request, response);
			} 
			else {
				System.out.println("Seleccione una cuenta destino diferente");
			}
			
		} 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
