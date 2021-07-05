package dao;

import java.util.ArrayList;

import entidad.DatosPersonales; 

public interface DatosPersonalesDao {

	public int insert(DatosPersonales persona);

	public int update(DatosPersonales persona);

	public ArrayList<DatosPersonales> readAll();

	public DatosPersonales buscarDNI(int dni);
}
