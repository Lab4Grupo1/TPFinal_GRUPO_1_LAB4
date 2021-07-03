package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.Query;

import dao.TelefonosDao;
import entidad.Telefonos;

public class TelefonosDaoImpl implements TelefonosDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_v2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public int insert(Telefonos tel) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		int cantidad = 0; 
		int insert = 0; 

		Connection cn = null;
		try 
		{
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			

			String query = "Insert into tpint_grupo1_v2.telefonos(numero) values('" + tel.getNumero() + "');"; 
 
			insert = st.executeUpdate(query); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		 
		try 
		{
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement(); 
			ResultSet rs = st.executeQuery("SELECT max(id) as id FROM tpint_grupo1_v2.telefonos;");
			while (rs.next()) { 
				cantidad = rs.getInt("id");
			}
			cn.close();
			 
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return cantidad;
	}

	public int update(Telefonos tel) {
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
			String query = "update Telefonos set numero = '" + tel.getNumero() + "'";

			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public List<Telefonos> readAll() {

		ArrayList<Telefonos> Telefonos = new ArrayList<Telefonos>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT id, numero FROM TipoCuenta;");

			while (rs.next()) {

				Telefonos TelefonosRs = new Telefonos();
				TelefonosRs.setNumero(rs.getString("numero"));
				Telefonos.add(TelefonosRs);

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return Telefonos;

	}

	public Telefonos buscarId(int id) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		Connection cn = null;

		Telefonos TelefonosRs = new Telefonos();
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();

			ResultSet rs = st.executeQuery(" SELECT id, numero FROM Telefonos where id=" + id);

			while (rs.next()) {
				TelefonosRs.setId(rs.getInt("id"));
				TelefonosRs.setNumero(rs.getString("numero"));

			}
			cn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		}
		return TelefonosRs;

	}
}
