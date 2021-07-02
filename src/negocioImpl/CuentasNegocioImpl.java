package negocioImpl;

import daoImpl.CuentasDaoImpl;
import entidad.Cuentas;
import negocio.CuentasNegocio;

public class CuentasNegocioImpl implements CuentasNegocio {

	CuentasDaoImpl cdao = new CuentasDaoImpl();
	
	public int insert(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return cdao.insert(cuenta);
	}

	public int update(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return cdao.update(cuenta);
	}

	
	public int delete(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return cdao.delete(cuenta);
	}

}
