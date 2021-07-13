package negocioImpl;

import java.util.ArrayList;

import dao.NacionalidadDao;
import daoImpl.NacionalidadDaoImpl;
import entidad.Nacionalidad;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImpl implements NacionalidadNegocio {

	NacionalidadDao ndao = new NacionalidadDaoImpl();

	@Override
	public ArrayList<Nacionalidad> readAll() {
		// TODO Auto-generated method stub
		return ndao.readAll();
	}

	@Override
	public Nacionalidad buscarId(int nacionalidadentero) {
		// TODO Auto-generated method stub
		return ndao.buscarId(nacionalidadentero);
	}

}
