package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import entidad.Cuentas;

public class CuentasDaoImpl {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";

	public int insert(Cuentas cuenta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Insert into cuentas(nrocuenta,cbu,fechacracion,saldo,estado,tipocuenta) values ('"
					+ cuenta.getNumeroCuenta() + "','" + cuenta.getCbu() + "','" + cuenta.getFechaCreacion() + "','"
					+ cuenta.getSaldo() + "','" + cuenta.isEstado() + "','" + cuenta.getTipoCuenta() + "')";
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public int update(Cuentas cuenta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Update cuentas saldo= ('" + cuenta.getSaldo() + "'), tipocuenta=('" + cuenta.getTipoCuenta()
					+ "') where nrocuenta= ('" + cuenta.getNumeroCuenta() + "')";
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public int delete(Cuentas cuenta) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int filas = 0;
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(host + dbName, user, pass);
			Statement st = cn.createStatement();
			String query = "Update cuentas estado= false where nrocuenta= ('" + cuenta.getNumeroCuenta() + "')";
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

}
