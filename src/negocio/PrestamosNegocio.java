package negocio;

import java.util.ArrayList;

import entidad.Prestamos;

public interface PrestamosNegocio {
	public boolean insertPrestamo(Prestamos prestamo);
	public ArrayList<Prestamos> readAll();
	public ArrayList<Prestamos> BuscarPrestamo(String Nprestamo);
	
}

