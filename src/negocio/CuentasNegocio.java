package negocio;

import entidad.Cuentas;

public interface CuentasNegocio {
	public int insert(Cuentas cuenta);

	public int update(Cuentas cuenta);

	public int delete(Cuentas cuenta);

	public Cuentas buscarCuenta(int numeroCuenta);

	public Cuentas buscarDni(int dni);
}
