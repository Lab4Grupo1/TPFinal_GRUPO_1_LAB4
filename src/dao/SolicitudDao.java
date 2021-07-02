package dao;
import java.util.List;

import entidad.Solicitud;

public interface SolicitudDao {
	
	public List<Solicitud> readAll();
	public boolean updateSolicitud(Solicitud solicitud );
	
}
