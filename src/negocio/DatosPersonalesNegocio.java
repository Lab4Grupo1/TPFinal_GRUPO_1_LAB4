package negocio;

import java.util.List;

import entidad.DatosPersonales;
import exceptions.cuilException;

public interface DatosPersonalesNegocio {
	public int insert(DatosPersonales persona);
	public int update(DatosPersonales persona); 
	public DatosPersonales buscarDNI(int id);
	public List<DatosPersonales> readAll();
	boolean validarCuil(double cuil) throws cuilException;
}
