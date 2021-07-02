package dao; 
import entidad.Usuario;

public interface UsuarioDao 
{
	public int insert(Usuario usuario);
	public int update(Usuario usuario);
	public int delete(int dni, String usuario); 
	public Usuario obtenerUnUsuario(int id);
}
