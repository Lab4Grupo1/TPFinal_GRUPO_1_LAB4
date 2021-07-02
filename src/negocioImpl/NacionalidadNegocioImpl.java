package negocioImpl;

import java.util.List;

import daoImpl.NacionalidadDaoImpl;
import entidad.Nacionalidad;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImpl implements NacionalidadNegocio {

	NacionalidadDaoImpl ndao = new NacionalidadDaoImpl();
	
	@Override
	public List<Nacionalidad> readAll() {
		// TODO Auto-generated method stub
		return ndao.readAll();
	}

}
