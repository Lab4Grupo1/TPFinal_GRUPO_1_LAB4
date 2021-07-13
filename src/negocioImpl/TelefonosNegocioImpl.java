package negocioImpl;

import java.util.List;

import dao.TelefonosDao;
import daoImpl.TelefonosDaoImpl;
import entidad.Telefonos;
import negocio.TelefonosNegocio;

public class TelefonosNegocioImpl implements TelefonosNegocio {

	TelefonosDao tdao = new TelefonosDaoImpl();

	@Override
	public int insert(Telefonos usuario) {
		// TODO Auto-generated method stub
		return tdao.insert(usuario);
	}

	@Override
	public int update(Telefonos usuario) {
		// TODO Auto-generated method stub
		return tdao.update(usuario);
	}

	@Override
	public List<Telefonos> readAll() {
		// TODO Auto-generated method stub
		return tdao.readAll();
	}

	@Override
	public Telefonos buscarId(int id) {
		// TODO Auto-generated method stub
		return tdao.buscarId(id);
	}

}
