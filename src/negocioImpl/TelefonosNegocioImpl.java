package negocioImpl;

import java.util.List;

import daoImpl.TelefonosDaoImpl;
import entidad.Telefonos;
import negocio.TelefonosNegocio;

public class TelefonosNegocioImpl implements TelefonosNegocio {

	TelefonosDaoImpl tdao = new TelefonosDaoImpl();
	
	public int insert(Telefonos usuario) {
		// TODO Auto-generated method stub
		return tdao.insert(usuario);
	}

	public int update(Telefonos usuario) {
		// TODO Auto-generated method stub
		return tdao.update(usuario);
	}

	public List<Telefonos> readAll() {
		// TODO Auto-generated method stub
		return tdao.readAll();
	}

}
