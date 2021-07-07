package dao;

import java.util.ArrayList;

import entidad.Prestamos;

public interface PrestamosDao {

	public boolean insertPrestamo(Prestamos prestamo);
	public ArrayList<Prestamos> readAll();
	public ArrayList<Prestamos>BuscarPrestamo(String Nprestamo);
	
}
