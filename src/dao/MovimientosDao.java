package dao;
import java.util.ArrayList;

import entidad.Movimientos;

public interface MovimientosDao {
	public ArrayList<Movimientos> readAll();
	ArrayList<Movimientos> buscarDNI(int dni, int tipoCuenta);
}
