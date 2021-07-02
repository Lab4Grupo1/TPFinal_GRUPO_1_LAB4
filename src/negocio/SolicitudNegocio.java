package negocio;

import java.util.List;

import entidad.Solicitud;

public interface SolicitudNegocio {
	public List<Solicitud> readAll();
	public boolean updateSolicitud(Solicitud solicitud );
}
