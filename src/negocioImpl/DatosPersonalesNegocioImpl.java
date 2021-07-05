package negocioImpl;

import java.util.ArrayList;

import daoImpl.DatosPersonalesDaoImpl;
import entidad.DatosPersonales;
import negocio.DatosPersonalesNegocio;

public class DatosPersonalesNegocioImpl implements DatosPersonalesNegocio {

	DatosPersonalesDaoImpl Ddao = new DatosPersonalesDaoImpl();

	@Override
	public int insert(DatosPersonales persona) {
		// TODO Auto-generated method stub
		return Ddao.insert(persona);
	}

	@Override
	public int update(DatosPersonales persona) {
		// TODO Auto-generated method stub
		return Ddao.update(persona);
	}

	@Override
	public ArrayList<DatosPersonales> readAll() {
		// TODO Auto-generated method stub
		return Ddao.readAll();
	}

	@Override
	public DatosPersonales buscarDNI(int dni) {
		// TODO Auto-generated method stub
		return Ddao.buscarDNI(dni);
	}
}