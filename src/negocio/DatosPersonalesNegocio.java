package negocio;

import java.util.ArrayList;
import entidad.DatosPersonales;

public interface DatosPersonalesNegocio {

	public int insert(DatosPersonales persona);

	public int update(DatosPersonales persona);

	public ArrayList<DatosPersonales> readAll();

	public DatosPersonales buscarDNI(int dni);
}