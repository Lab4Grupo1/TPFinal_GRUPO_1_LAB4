package negocioImpl;

import java.util.ArrayList; 

import daoImpl.NacionalidadDaoImpl;
import entidad.Nacionalidad;
import negocio.NacionalidadNegocio;

public class NacionalidadNegocioImpl implements NacionalidadNegocio {

	NacionalidadDaoImpl ndao = new NacionalidadDaoImpl();
	
	public ArrayList<Nacionalidad> readAll() {
		// TODO Auto-generated method stub
		return ndao.readAll();
	}

}
