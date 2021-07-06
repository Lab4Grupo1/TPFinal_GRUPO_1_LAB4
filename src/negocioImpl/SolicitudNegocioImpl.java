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
    public int updateSolicitud(int numero ) {
        int filas = 0;
        // TODO Auto-generated method stub
        return sdao.updateSolicitud(filas);
    }

}