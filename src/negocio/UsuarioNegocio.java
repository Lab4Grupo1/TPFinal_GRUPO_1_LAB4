package negocio;

import entidad.DatosPersonales;
import entidad.Usuario;

public interface UsuarioNegocio {
	public int insert(Usuario usuario);
	public int updateDNI(DatosPersonales DatosPersonales);
	public int updatePass(String pass, String usuario);
	public int delete(String id, String usuario); 
	public Usuario obtenerUnUsuario(int id, String nombreUsuario); 
	public Usuario logueo(String pass, String NombreUsuario);
	
}
