package negocio;

import java.util.ArrayList;

import entidad.TipoCuentas;

public interface TipoCuentasNegocio {
	public ArrayList<TipoCuentas> readAll();
	
	public TipoCuentas buscarId(int id);

}
