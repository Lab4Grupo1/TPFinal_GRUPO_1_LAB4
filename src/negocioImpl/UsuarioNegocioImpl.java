package negocioImpl;

import daoImpl.UsuarioDaoImpl;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	
	UsuarioDaoImpl udao = new UsuarioDaoImpl();
	
	@Override
	public int insert(Usuario usuario) {
		// TODO Auto-generated method stub
		return udao.insert(usuario);
	}

	@Override
	public int update(Usuario usuario) {
		// TODO Auto-generated method stub
		return udao.update(usuario);
	}

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return udao.delete(id);
	}

	@Override
	public Usuario obtenerUnUsuario(int id) {
		// TODO Auto-generated method stub
		return udao.obtenerUnUsuario(id);
	}

}
