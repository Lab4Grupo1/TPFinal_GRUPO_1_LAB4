package entidad;

import java.sql.Date;

public class Movimientos {

	private int Id;
	private String Detalle;
	private Date Fecha;
	private float Importe;
	private TipoMovimiento TipoMovimiento;
	private int NumeroCuenta;

	public Movimientos(int id, String detalle, Date fecha, float importe, TipoMovimiento tipoMovimiento, int numeroCuenta) {
		Id = id;
		Detalle = detalle;
		Fecha = fecha;
		Importe = importe;
		TipoMovimiento = tipoMovimiento;
		NumeroCuenta = numeroCuenta;
	}
	
	public Movimientos(){}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getDetalle() {
		return Detalle;
	}

	public void setDetalle(String detalle) {
		Detalle = detalle;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public float getImporte() {
		return Importe;
	}

	public void setImporte(float importe) {
		Importe = importe;
	}

	public TipoMovimiento getTipoMovimiento() {
		return TipoMovimiento;
	}

	public void setTipoMovimiento(TipoMovimiento tipoMovimiento) {
		TipoMovimiento = tipoMovimiento;
	}

	public int getNumeroCuenta() {
		return NumeroCuenta;
	}

	public void setNumeroCuenta(int numeroCuenta) {
		NumeroCuenta = numeroCuenta;
	}
	
}
	
	