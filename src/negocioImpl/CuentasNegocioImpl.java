package negocioImpl;

import daoImpl.CuentasDaoImpl;
import entidad.Cuentas;
import negocio.CuentasNegocio;

public class CuentasNegocioImpl implements CuentasNegocio {

	CuentasDaoImpl cdao = new CuentasDaoImpl();

	@Override
	public int insert(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return cdao.insert(cuenta);
	}

	@Override
	public int update(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return cdao.update(cuenta);
	}


	@Override
	public int delete(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return cdao.delete(cuenta);
	}

	@Override
	public Cuentas buscarDni(int dni) {
		// TODO Auto-generated method stub
		return cdao.buscarDni(dni);
	}

}
