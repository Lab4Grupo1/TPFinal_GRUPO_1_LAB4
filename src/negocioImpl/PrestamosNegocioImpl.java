package negocioImpl;

import daoImpl.PrestamosDaoImpl;
import entidad.Prestamos;
import negocio.PrestamosNegocio;

public class PrestamosNegocioImpl implements PrestamosNegocio {

	PrestamosDaoImpl pdao = new PrestamosDaoImpl();

	@Override
	public boolean insertPrestamo(Prestamos prestamo) {
		// TODO Auto-generated method stub
		return pdao.insertPrestamo(prestamo);
	}

}
