package negocioImpl;

import daoImpl.UsuarioDaoImpl;
import entidad.DatosPersonales;
import entidad.Usuario;
import negocio.UsuarioNegocio;

public class UsuarioNegocioImpl implements UsuarioNegocio {

	
	UsuarioDaoImpl udao = new UsuarioDaoImpl();
	
	public int insert(Usuario usuario) {
		// TODO Auto-generated method stub
		return udao.insert(usuario);
	}

	public int updateDNI(DatosPersonales DatosPersonales) {
		// TODO Auto-generated method stub
		return udao.updateDNI(DatosPersonales);
	}

	public int updatePass(String pass, String usuario) {
		// TODO Auto-generated method stub
		return udao.updatePass(pass, usuario);
	} 

	public int delete(int id) {
		// TODO Auto-generated method stub
		return udao.delete(id);
	}

	public Usuario obtenerUnUsuario(int id, String nombreUsuario) {
		// TODO Auto-generated method stub
		return udao.obtenerUnUsuario(id, nombreUsuario);
	} 

}
