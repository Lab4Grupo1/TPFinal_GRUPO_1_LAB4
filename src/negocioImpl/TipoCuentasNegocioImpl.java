package negocioImpl;

import java.util.ArrayList;

import daoImpl.TipoCuentasDaoImpl;
import entidad.TipoCuentas;
import negocio.TipoCuentasNegocio;

public class TipoCuentasNegocioImpl implements TipoCuentasNegocio {

	TipoCuentasDaoImpl tcdao = new TipoCuentasDaoImpl();
	
	public ArrayList<TipoCuentas> readAll() {
		// TODO Auto-generated method stub
		return tcdao.readAll();
	}

}
