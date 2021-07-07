package entidad;

import java.sql.Date;

public class Prestamos {
	
	private int Id;
	private int CuotasPagas;
	private int CuotasTotal;
	private double ImporteCuota;
	private double ImportePedidoTotal;
	private Date FechaUltimoPago;
	private int NumeroCuenta;
	
	public Prestamos() {
		
	}
	
	public Prestamos(int id, int cuotasPagas, int cuotasTotal, double importeCuota, double importePedidoTotal, Date fechaUltimoPago, int numeroCuenta) {
		Id =id;
		CuotasPagas = cuotasPagas;
		CuotasTotal = cuotasTotal;
		ImporteCuota = importeCuota;
		ImportePedidoTotal = importePedidoTotal;
		FechaUltimoPago = fechaUltimoPago;
		NumeroCuenta = numeroCuenta;
	}
	

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getCuotasPagas() {
		return CuotasPagas;
	}

	public void setCuotasPagas(int cuotasPagas) {
		CuotasPagas = cuotasPagas;
	}

	public int getCuotasTotal() {
		return CuotasTotal;
	}

	public void setCuotasTotal(int cuotasTotal) {
		CuotasTotal =  cuotasTotal;
	}

	public double getImporteCuota() {
		return ImporteCuota;
	}

	public void setImporteCuota(float importeCuota) {
		ImporteCuota = importeCuota;
	}

	public double getImportePedidoTotal() {
		return ImportePedidoTotal;
	}

	public void setImportePedidoTotal(double d) {
		ImportePedidoTotal = d;
	}

	public Date getFechaUltimoPago() {
		return FechaUltimoPago;
	}

	public void setFechaUltimoPago(Date fechaUltimoPago) {
		FechaUltimoPago = fechaUltimoPago;
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}
}