package negocioImpl;

import java.util.List;

import daoImpl.TipoCuentasDaoImpl;
import entidad.TipoCuentas;
import negocio.TipoCuentasNegocio;

public class TipoCuentasNegocioImpl implements TipoCuentasNegocio {

	TipoCuentasDaoImpl tcdao = new TipoCuentasDaoImpl();
	
	@Override
	public List<TipoCuentas> readAll() {
		// TODO Auto-generated method stub
		return tcdao.readAll();
	}

}
