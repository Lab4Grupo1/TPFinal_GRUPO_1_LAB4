import java.util.ArrayList;
import entidad.Usuario;
import negocio.UsuarioNegocio;
import negocioImpl.UsuarioNegocioImpl;

public class Pruebas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UsuarioNegocio usuarioN = new UsuarioNegocioImpl();
		ArrayList<Usuario> listaUsuarios = new ArrayList<Usuario>();
		listaUsuarios = usuarioN.readAll();
		if (listaUsuarios != null) {
			for (Usuario usuario : listaUsuarios) {
				if (usuario.getRol().getId() == 2) {

					System.out.println(usuario.getdp_DNI().getDni());
					System.out.println(usuario.getdp_DNI().getApellido());
					System.out.println(usuario.getdp_DNI().getNombre());
					System.out.println(usuario.getNombreUsuario());
				}
			}
		} else
			System.out.println("no carga");

	}
}
