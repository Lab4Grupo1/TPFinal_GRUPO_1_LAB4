package entidad;

import java.time.LocalDate;
import java.text.DecimalFormat;

public class Cuentas {

	private int NumeroCuenta;
	private double Cbu;
	private TipoCuentas TipoCuenta;
	private DatosPersonales DpDNI;
	private LocalDate FechaCreacion;
	private DecimalFormat Saldo;
	private boolean Estado;

	public Cuentas(int numeroCuenta, double cbu, TipoCuentas tipoCuenta, DatosPersonales dpDNI, LocalDate fechaCreacion,DecimalFormat saldo, boolean estado) {
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

	public void setTipoCuenta(TipoCuentas tP) {
		TipoCuenta = tP;
	}

	public DatosPersonales getDniCliente() {
		return DpDNI;
	}

	public void setDniCliente(DatosPersonales dniInt) {
		DpDNI = dniInt;
	}

	public LocalDate getFechaCreacion() {
		return FechaCreacion;
	}

	public void setFechaCreacion(LocalDate fechaCre) {
		FechaCreacion = fechaCre;
	}

	public DecimalFormat getSaldo() {
		return Saldo;
	}

	public void setSaldo(DecimalFormat saldo) {
		Saldo = saldo;
	}

	public boolean isEstado() {
		return Estado;
	}

	public void setEstado(boolean estado) {
		Estado = estado;
	}

}
