package dao;

import java.util.ArrayList;
import java.util.List;

import entidad.Rol;

public interface RolDao {

	public ArrayList<Rol> readAll();
	public Rol buscarId(int id);
}
