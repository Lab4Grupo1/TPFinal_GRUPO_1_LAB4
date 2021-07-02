package daoImpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import entidad.DatosPersonales;
import entidad.Rol;
import entidad.Usuario;

public class UsuarioDaoImpl {
	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_v2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public int insert(Usuario usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "Insert into usuario (NombreUsuario, Contraseña, FK_IdRol, FK_DniDp, Estado)  values"
					+ "	('" + usuario.getNombreUsuario() + "','" + usuario.getContraseña() + "," + "	('"
					+ usuario.getRol().getId() + "','" + usuario.getdp_DNI() + "," + usuario.isEstado();

			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public int update(Usuario usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "update usuario set NombreUsuario = '" + usuario.getNombreUsuario() + "',  Contraseña = '"
					+ usuario.getContraseña() + "', FK_IdRol = '" + usuario.getRol() + "', FK_DniDp ='"
					+ usuario.getdp_DNI() + "'  where  NombreUsuario =  '" + usuario.getNombreUsuario() + "'";

			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public int delete(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "update usuario set estado = false where id=" + id;
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public Usuario obtenerUnUsuario(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Usuario usuario = new Usuario();
		Rol rol = new Rol();
		DatosPersonales dp = new DatosPersonales();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			PreparedStatement miSentencia = cn.prepareStatement(
					"Select u.NombreUsuario, u.Contraseña, " + "u.FK_idRol, r.Descripcion, u.FK_DniDP, u.Estado "
							+ "from usuario u inner join rol r on r.id=u.FK_idRol where u.Id = ?;");
			miSentencia.setInt(1, id);
			ResultSet resultado = miSentencia.executeQuery();
			resultado.next();

			rol.setId(resultado.getInt(3));
			rol.setDescripcion(resultado.getString(4));

			dp.setDni(resultado.getInt(5));

			usuario.setNombreUsuario(resultado.getString(1));
			usuario.setContraseña(resultado.getString(2));
			usuario.setRol(rol);
			usuario.setDatosPersonales(dp);
			usuario.setEstado(resultado.getBoolean(6));
			cn.close();
		} catch (Exception e) {
			System.out.println("Conexion fallida");
		} finally {
		}
		return usuario;
	}

	public void procedimientoInsertarUsuario(Usuario usuario) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			CallableStatement proc = cn.prepareCall(" CALL crearUsuario(?,?) ");
			proc.setString("NombreUsuario", usuario.getNombreUsuario());
			proc.execute();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
