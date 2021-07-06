package negocioImpl;

import java.util.ArrayList; 

import daoImpl.RolDaoImpl;
import entidad.Rol;
import negocio.RolNegocio;

public class RolNegocioImpl implements RolNegocio {

	RolDaoImpl rdao = new RolDaoImpl();

	@Override
	public ArrayList<Rol> readAll() {
		// TODO Auto-generated method stub
		return rdao.readAll();
	}

}
