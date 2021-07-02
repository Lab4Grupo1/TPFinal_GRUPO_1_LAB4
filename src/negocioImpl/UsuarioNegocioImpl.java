package negocioImpl;

import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	
	UsuarioDaoImpl udao = new UsuarioDaoImpl();
	
	public int insert(Usuario usuario) {
		// TODO Auto-generated method stub
		return udao.insert(usuario);
	}

	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return udao.update(usuario);
	}

	public int delete(int id) {
		// TODO Auto-generated method stub
		return udao.delete(id);
	}

	public Usuario obtenerUnUsuario(int id) {
		// TODO Auto-generated method stub
		return udao.obtenerUnUsuario(id);
	}

}
