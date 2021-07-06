package entidad;

import java.sql.Date;

public class Prestamos {
	
	private int Id;
	private int CuotasPagas;
	private int CuotasTotal;
	private float ImporteTotal;
	private float ImportePedido;
	private Date FechaUltimoPago;
	private int NumeroCuenta;
	
	public Prestamos() {
		
	}
	
	public Prestamos(int id, int cuotasPagas, int cuotasTotal, float importeTotal, float importePedido, Date fechaUltimoPago, int numeroCuenta) {
		Id =id;
		CuotasPagas = cuotasPagas;
		CuotasTotal = cuotasTotal;
		ImporteTotal = importeTotal;
		ImportePedido = importePedido;
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

	public float getImporteTotal() {
		return ImporteTotal;
	}

	public void setImporteTotal(float importeTotal) {
		ImporteTotal = importeTotal;
	}

	public float getImportePedido() {
		return ImportePedido;
	}

	public void setImportePedido(float importePedido) {
		ImportePedido = importePedido;
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