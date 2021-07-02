package negocioImpl;

import java.util.List;

import daoImpl.TipoMovimientoDaoImpl;
import entidad.TipoMovimiento;
import negocio.TipoMovimientoNegocio;

public class TipoMovimientoNegocioImpl implements TipoMovimientoNegocio {

	TipoMovimientoDaoImpl tmdao = new TipoMovimientoDaoImpl();
	
	@Override
	public List<TipoMovimiento> readAll() {
		// TODO Auto-generated method stub
		return tmdao.readAll();
	}

}
