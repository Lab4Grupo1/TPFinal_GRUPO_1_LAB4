package dao;

import java.util.ArrayList;

import entidad.Cuentas;

public interface CuentasDao {
	public int insert(Cuentas cuenta);

	public int update(Cuentas cuenta);

	public int delete(Cuentas cuenta);

	public Cuentas buscarCuenta(int numeroCuenta);

	public Cuentas buscarDni(int dni);

	ArrayList<Cuentas> ListarCuentas(int DNI);

}
