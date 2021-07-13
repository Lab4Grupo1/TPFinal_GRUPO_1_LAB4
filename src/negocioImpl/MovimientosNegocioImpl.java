package negocioImpl;

import java.util.ArrayList;

import dao.MovimientosDao;
import daoImpl.MovimientosDaoImpl;
import entidad.Movimientos;
import negocio.MovimientosNegocio;

public class MovimientosNegocioImpl implements MovimientosNegocio {

	MovimientosDao mdao = new MovimientosDaoImpl();

	@Override
	public ArrayList<Movimientos> readAll() {
		// TODO Auto-generated method stub
		return mdao.readAll();
	}

	@Override
	public ArrayList<Movimientos> buscarDNI(int dni, int tip) {
		// TODO Auto-generated method stub
		return mdao.buscarDNI(dni, tip);
	}
	

	public int insert(Movimientos Movimientos) {
		// TODO Auto-generated method stub
		return mdao.insert(Movimientos);
	}

}
