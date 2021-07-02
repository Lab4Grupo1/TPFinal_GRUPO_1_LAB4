package negocioImpl;

import java.util.List;

import daoImpl.DatosPersonalesDaoImpl;
import entidad.DatosPersonales;
import negocio.DatosPersonalesNegocio;

public class DatosPersonalesNegocioImpl implements DatosPersonalesNegocio{

	DatosPersonalesDaoImpl dpdao = new DatosPersonalesDaoImpl();
	
	
	public int insert(DatosPersonales persona) {
		// TODO Auto-generated method stub
		return dpdao.insert(persona);
	}

	
	public int update(DatosPersonales persona) {
		// TODO Auto-generated method stub
		return dpdao.update(persona);
	}

	public DatosPersonales obtenerUnUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<DatosPersonales> readAll() {
		// TODO Auto-generated method stub
		return dpdao.readAll();
	}

}
