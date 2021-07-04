package dao; 
import entidad.DatosPersonales;
import entidad.Usuario;

public interface UsuarioDao 
{
	public int insert(Usuario usuario);
	public int updateDNI(DatosPersonales DatosPersonales);
	public int updatePass(String passWord, String usuario);
	public int delete(String dni, String usuario); 
	public Usuario obtenerUnUsuario(int id);
}
