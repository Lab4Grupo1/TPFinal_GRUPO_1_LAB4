package negocioImpl;

import java.util.ArrayList;

import daoImpl.MovimientosDaoImpl;
import entidad.Movimientos;
import negocio.MovimientosNegocio;

public class MovimientosNegocioImpl implements MovimientosNegocio {

	MovimientosDaoImpl mdao = new MovimientosDaoImpl();

	@Override
	public ArrayList<Movimientos> readAll() {
		// TODO Auto-generated method stub
		return mdao.readAll();
	}

	@Override
	public ArrayList<Movimientos> buscarDNI(int dni, int tipoCuenta) {
		// TODO Auto-generated method stub
		return mdao.buscarDNI(dni, tipoCuenta);
	}

}
