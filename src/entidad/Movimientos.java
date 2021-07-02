package entidad;

import java.sql.Date;

public class Movimientos {

	private int Id;
	private String Detalle;
	private Date Fecha;
	private float Importe;
	private TipoMovimiento TipoMovimiento;
	private Cuentas Cuenta;

	public Movimientos() {
	}

	public Movimientos(int id, String detalle, Date fecha, float importe, TipoMovimiento tipoMovimiento,
			Cuentas cuenta) {
		Id = id;
		Detalle = detalle;
		Fecha = fecha;
		Importe = importe;
		TipoMovimiento = tipoMovimiento;
		Cuenta = cuenta;
	}

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

	public Cuentas getCuenta() {
		return Cuenta;
	}

	public void setCuenta(Cuentas cuenta) {
		Cuenta = cuenta;
	}

}
