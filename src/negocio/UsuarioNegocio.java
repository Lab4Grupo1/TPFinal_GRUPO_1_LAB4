package negocio;

import entidad.Usuario;

public interface UsuarioNegocio {
	public int insert(Usuario usuario);
	public int update(Usuario usuario);
	public int delete(int id); 
	public Usuario obtenerUnUsuario(int id, String nombreUsuario);
}
