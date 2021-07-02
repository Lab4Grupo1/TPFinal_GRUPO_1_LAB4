package negocioImpl;

import java.util.List;

import daoImpl.MovimientosDaoImpl;
import entidad.Movimientos;
import negocio.MovimientosNegocio;

public class MovimientosNegocioImpl implements MovimientosNegocio{

	MovimientosDaoImpl mdao = new MovimientosDaoImpl();
	
	@Override
	public List<Movimientos> readAll() {
		// TODO Auto-generated method stub
		return mdao.readAll();
	}

}
