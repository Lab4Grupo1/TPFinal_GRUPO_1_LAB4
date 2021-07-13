package negocioImpl;

import java.util.ArrayList;

import dao.PrestamosDao;
import daoImpl.PrestamosDaoImpl;
import entidad.Prestamos;
import negocio.PrestamosNegocio;

public class PrestamosNegocioImpl implements PrestamosNegocio {

	PrestamosDao pdao = new PrestamosDaoImpl();

	@Override
	public boolean insertPrestamo(Prestamos prestamo) {
		// TODO Auto-generated method stub
		return pdao.insertPrestamo(prestamo);
	}

	

	public ArrayList<Prestamos> readAll(int dni) {
		return pdao.readAll(dni);
	}



	public ArrayList<Prestamos> BuscarPrestamo(String Nprestamo) {
		
		return pdao.BuscarPrestamo(Nprestamo);
	}

	public Prestamos BuscarPrestamos(String numero) {
		return pdao.BuscarPrestamos(numero);
	}

	public boolean ComprobarSaldo(double saldo, String Ncuenta) {
		return pdao.ComprobarSaldo(saldo, Ncuenta);
	}

	public boolean UpdateCuotas(String NPrestamo, int cantCuotasPagas) {
		return pdao.UpdateCuotas(NPrestamo, cantCuotasPagas);
	}

	public boolean RestarSaldo(int Ncuenta, double saldo) {
		return pdao.RestarSaldo(Ncuenta, saldo);
	}

	

	
	
	
	
}
