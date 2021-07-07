package negocioImpl;

import java.util.List;

import dao.DatosPersonalesDao;
import daoImpl.DatosPersonalesDaoImpl;
import entidad.DatosPersonales;
import negocio.DatosPersonalesNegocio;

public class DatosPersonalesNegocioImpl implements DatosPersonalesNegocio{

	DatosPersonalesDao dpdao = new DatosPersonalesDaoImpl();
	

	@Override
	public int insert(DatosPersonales persona) {
		// TODO Auto-generated method stub
		return dpdao.insert(persona);
	}


	@Override
	public int update(DatosPersonales persona) {
		// TODO Auto-generated method stub
		return dpdao.update(persona);
	}

	@Override
	public DatosPersonales buscarDNI(int id) { 
		// TODO Auto-generated method stub 
		return dpdao.buscarDNI(id);
	}

	@Override
	public List<DatosPersonales> readAll() {
		// TODO Auto-generated method stub
		return dpdao.readAll();
	}

}
