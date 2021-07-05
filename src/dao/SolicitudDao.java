package dao;
import java.util.ArrayList;
import java.util.List;

import entidad.Solicitud;

public interface SolicitudDao {
	
	public ArrayList<Solicitud> readAll();
	public boolean updateSolicitud(Solicitud solicitud );
	public ArrayList<Solicitud> buscar(String cliente);
	public Solicitud buscarSolicitud(int Nsolicitud);
}
