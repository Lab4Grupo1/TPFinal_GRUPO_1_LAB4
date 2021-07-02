package entidad;

public class TipoCuentas {
	public TipoCuentas(String descripcion) { 
		Descripcion = descripcion;
	}
	public TipoCuentas( ) {}

	private int Id;
	private String Descripcion;
	
	public int getId() {
		return Id;
	}
	
	public void setDescripcion(String desc) {
		Descripcion = desc;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}
}
