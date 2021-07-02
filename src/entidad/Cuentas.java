package entidad;

import java.sql.Date;

public class Cuentas {

	private int NumeroCuenta;
	private double Cbu;
	private TipoCuentas TipoCuenta;
	private DatosPersonales DpDNI;
	private Date FechaCreacion;
	private float Saldo;
	private boolean Estado;

	public Cuentas(int numeroCuenta, double cbu, TipoCuentas tipoCuenta, DatosPersonales dpDNI, Date fechaCreacion,
			float saldo, boolean estado) {
		NumeroCuenta = numeroCuenta;
		Cbu = cbu;
		TipoCuenta = tipoCuenta;
		DpDNI = dpDNI;
		FechaCreacion = fechaCreacion;
		Saldo = saldo;
		Estado = estado;
	}

	public Cuentas() {
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}

	public double getCbu() {
		return Cbu;
	}

	public void setCbu(double cbu) {
		Cbu = cbu;
	}

	public TipoCuentas getTipoCuenta() {
		return TipoCuenta;
	}

	public void setTipoCuenta(TipoCuentas tipoCuenta) {
		TipoCuenta = tipoCuenta;
	}

	public DatosPersonales getDniCliente() {
		return DpDNI;
	}

	public void setDniCliente(DatosPersonales dpDNI) {
		DpDNI = dpDNI;
	}

	public Date getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(Date fechaCreacion) {
		FechaCreacion = fechaCreacion;
	}

	public float getSaldo() {
		return Saldo;
	}

	public void setSaldo(float saldo) {
		Saldo = saldo;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

}
