package negocioImpl;

import java.util.List;

import daoImpl.SolicitudDaoImpl;
import entidad.Solicitud;
import negocio.SolicitudNegocio;

public class SolicitudNegocioImpl implements SolicitudNegocio {

	SolicitudDaoImpl sdao = new SolicitudDaoImpl();
	
	@Override
	public List<Solicitud> readAll() {
		// TODO Auto-generated method stub
		return sdao.readAll();
	}

	@Override
	public boolean updateSolicitud(Solicitud solicitud) {
		// TODO Auto-generated method stub
		return sdao.updateSolicitud(solicitud);
	}

}
