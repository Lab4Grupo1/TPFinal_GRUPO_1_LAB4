package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.RolDao;
import entidad.Nacionalidad;
import entidad.Rol;

public class RolDaoImpl implements RolDao{ 

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_v2";
	static String user = "root";
	static String pass = "root";
 
 	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public ArrayList<Rol> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Rol> Rol = new ArrayList<Rol>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
 
			ResultSet rs = st.executeQuery("SELECT id, Descripcion, Estado FROM rol"); 

				while(rs.next()){
				
				Rol rolRs = new Rol();
				rolRs.setId(rs.getInt("id"));
				rolRs.setDescripcion(rs.getString("Descripcion"));
				rolRs.setEstado(rs.getBoolean("Estado"));
				
				Rol.add(rolRs);
				
			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return Rol;

	}
	
	public Rol buscarId(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = null;

		Rol RolRs = new Rol();
		try {
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT * FROM Rol where id=" + id);

			while (rs.next()) {
				RolRs.setId(id);
				RolRs.setDescripcion(rs.getString("Descripcion"));

			}
			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return RolRs;

	}
}
