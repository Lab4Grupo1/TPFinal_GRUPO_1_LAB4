package dao;
import java.util.ArrayList;
import java.util.List;

import entidad.Solicitud;

public interface SolicitudDao {
	
	public ArrayList<Solicitud> readAll();
	public int updateSolicitud(int numero );
	public int UpdateRechazoSolicitud(int numero);
	public int UpdateSumarPrestamo(int numeroCuenta, float saldo);
	public ArrayList<Solicitud> buscar(String cliente);
	public Solicitud buscarSolicitud(int Nsolicitud);
}
