package negocioImpl;

import java.util.ArrayList;

import daoImpl.TiposCuentaDaoImpl;
import entidad.TipoCuentas;
import negocio.TiposCuentaNegocio;

public class TiposCuentaNegocioImpl implements TiposCuentaNegocio {

	TiposCuentaDaoImpl tcdao = new TiposCuentaDaoImpl();

	@Override
	public ArrayList<TipoCuentas> readAll() {
		// TODO Auto-generated method stub
		return tcdao.readAll();
	}
	
	@Override
	public TipoCuentas buscarId(int id){
		// TODO Auto-generated method stub
		return tcdao.buscarId(id);
	}

}
