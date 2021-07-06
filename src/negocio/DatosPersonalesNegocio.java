package negocio;

import java.util.List;

import entidad.DatosPersonales;

public interface DatosPersonalesNegocio {
	public int insert(DatosPersonales persona);
	public int update(DatosPersonales persona); 
	public DatosPersonales buscarDNI(int id);
	public List<DatosPersonales> readAll();
}
