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
	
	@Override
	public ArrayList<Prestamos> readAll(int dni) {
		return pdao.readAll(dni);
	}
	
	@Override
	public ArrayList<Prestamos> FiltroMonto(String desde, String hasta) {
		return pdao.FiltroMonto(desde, hasta);
	}
	
	@Override
	public ArrayList<Prestamos> readAll() {
		return pdao.readAll();
	}

	@Override
	public ArrayList<Prestamos> BuscarPrestamo(String Nprestamo) {		
		return pdao.BuscarPrestamo(Nprestamo);
	}

	@Override
	public Prestamos BuscarPrestamos(String numero) {
		return pdao.BuscarPrestamos(numero);
	}
	
	@Override
	public boolean ComprobarSaldo(double saldo, String Ncuenta) {
		return pdao.ComprobarSaldo(saldo, Ncuenta);
	}
	
	@Override
	public boolean UpdateCuotas(String NPrestamo, int cantCuotasPagas) {
		return pdao.UpdateCuotas(NPrestamo, cantCuotasPagas);
	}
	
	@Override
	public boolean RestarSaldo(int Ncuenta, double saldo) {
		return pdao.RestarSaldo(Ncuenta, saldo);
	}

	

	
	
	
	
}
