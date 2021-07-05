import negocioImpl.DatosPersonalesNegocioImpl;

public class Pruebita {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int dni = 1;

		DatosPersonalesNegocioImpl datImpl = new DatosPersonalesNegocioImpl();

		try {

			System.out.println("Apellido: " + datImpl.buscarDNI(dni).getApellido());

			System.out.println("Nombre: " + datImpl.buscarDNI(dni).getNombre());

		} catch (Exception e) {

			System.out.println(e);

		}

	}

}
