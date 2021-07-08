package negocioImpl;

import java.util.List;

import daoImpl.TiposMovimientoDaoImpl;
import entidad.TipoMovimiento;
import negocio.TiposMovimientoNegocio;

public class TiposMovimientoNegocioImpl implements TiposMovimientoNegocio {

	TiposMovimientoDaoImpl tmdao = new TiposMovimientoDaoImpl();

	@Override
	public List<TipoMovimiento> readAll() {
		// TODO Auto-generated method stub
		return tmdao.readAll();
	}

}
