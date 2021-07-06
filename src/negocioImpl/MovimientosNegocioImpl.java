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

}
