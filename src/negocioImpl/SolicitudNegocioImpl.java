package negocioImpl;

import java.util.ArrayList; 

import daoImpl.SolicitudDaoImpl;
import entidad.Solicitud;
import negocio.SolicitudNegocio;

public class SolicitudNegocioImpl implements SolicitudNegocio {

    SolicitudDaoImpl sdao = new SolicitudDaoImpl();
    
    @Override
    public int insert(Solicitud soli) {
        // TODO Auto-generated method stub
        return sdao.insert(soli);
    }
    
	@Override
    public ArrayList<Solicitud> readAll() {
        // TODO Auto-generated method stub
        return sdao.readAll();
    }

	@Override
    public int updateSolicitud(int numero ) {
        int filas = 0;
        // TODO Auto-generated method stub
        return sdao.updateSolicitud(filas);
    }

	@Override
	public Solicitud buscarSolicitud(int nsoli) {
		// TODO Auto-generated method stub
		return sdao.buscarSolicitud(nsoli);
	}

	@Override
	public int UpdateSumarPrestamo(int numeroCuenta, double d) {
		// TODO Auto-generated method stub
		return sdao.UpdateSumarPrestamo(numeroCuenta, d);
	}

	@Override
	public int UpdateRechazoSolicitud(int numeroSolicitud) {
		// TODO Auto-generated method stub
		return sdao.UpdateRechazoSolicitud(numeroSolicitud);
	}

	@Override
	public ArrayList<Solicitud> buscar(String cuenta) {
		// TODO Auto-generated method stub
		return sdao.buscar(cuenta);
	}

}