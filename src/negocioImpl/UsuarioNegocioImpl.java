package negocioImpl;

import java.util.ArrayList;

import dao.UsuarioDao;
import daoImpl.UsuarioDaoImpl;
import entidad.DatosPersonales;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	UsuarioDao udao = new UsuarioDaoImpl();

	@Override
	public int insert(Usuario usuario) {
		// TODO Auto-generated method stub
		return udao.insert(usuario);
	}

	@Override
	public int updateDNI(DatosPersonales DatosPersonales) {
		// TODO Auto-generated method stub
		return udao.updateDNI(DatosPersonales);
	}

	@Override
	public int updatePass(String pass, String usuario) {
		// TODO Auto-generated method stub
		return udao.updatePass(pass, usuario);
	}

	@Override
	public int delete(String id, String usuario) {
		// TODO Auto-generated method stub
		return udao.delete(id, usuario);
	}

	@Override
	public Usuario obtenerUnUsuario(int id, String nombreUsuario) {
		// TODO Auto-generated method stub
		return udao.obtenerUnUsuario(id, nombreUsuario);
	}

	@Override
	public Usuario logueo(String pass, String NombreUsuario) {
		// TODO Auto-generated method stub
		return udao.logueo(pass, NombreUsuario);
	}

	@Override
	public ArrayList<Usuario> readAll() {
		// TODO Auto-generated method stub
		return udao.readAll();
	}

}
