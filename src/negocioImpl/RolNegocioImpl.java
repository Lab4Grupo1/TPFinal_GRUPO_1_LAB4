package negocioImpl;

import java.util.ArrayList;

import dao.RolDao;
import daoImpl.RolDaoImpl;
import entidad.Rol;
import negocio.RolNegocio;

public class RolNegocioImpl implements RolNegocio {

	RolDao rdao = new RolDaoImpl();

	@Override
	public ArrayList<Rol> readAll() {
		// TODO Auto-generated method stub
		return rdao.readAll();
	}

	@Override
	public Rol buscarId(int rolentero) {
		// TODO Auto-generated method stub
		return rdao.buscarId(rolentero);
	}

}
