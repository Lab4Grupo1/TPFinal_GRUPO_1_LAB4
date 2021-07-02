package entidad;

public class Nacionalidad {
	public Nacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	public Nacionalidad() {	}
	private int Id;
	private String Nacionalidad;
	
	public int getId() {
		return Id;
	}

	
	public String getNacionalidad() {
		return Nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		Nacionalidad = nacionalidad;
	}
	
	
}
