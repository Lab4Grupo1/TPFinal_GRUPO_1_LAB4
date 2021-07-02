package dao;

import entidad.Cuentas;

public interface CuentasDao {
	public int insert(Cuentas cuenta);

	public int update(Cuentas cuenta);

	public int delete(Cuentas cuenta);

}
