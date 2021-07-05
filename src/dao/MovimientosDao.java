package dao;

import java.util.ArrayList;

import entidad.Movimientos;

public interface MovimientosDao {
	public ArrayList<Movimientos> readAll();

	public ArrayList<Movimientos> buscarDNI(int dni, int tipoCuenta);
}
