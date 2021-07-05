package negocioImpl;

import daoImpl.CuentasDaoImpl;
import entidad.Cuentas;
import negocio.CuentasNegocio;

public class CuentasNegocioImpl implements CuentasNegocio {

	CuentasDaoImpl Cdao = new CuentasDaoImpl();

	@Override
	public int insert(Cuentas cuenta) {
		int a = 0;
		try {
			a = Cdao.insert(cuenta);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return a;
	}

	@Override
	public int update(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return Cdao.update(cuenta);
	}

	@Override
	public int delete(Cuentas cuenta) {
		// TODO Auto-generated method stub
		return Cdao.delete(cuenta);
	}

	@Override
	public Cuentas buscarCuenta(int numeroCuenta) {
		// TODO Auto-generated method stub
		return Cdao.buscarCuenta(numeroCuenta);
	}

	@Override
	public Cuentas buscarDni(int dni) {
		// TODO Auto-generated method stub
		return Cdao.buscarDni(dni);
	}

}
