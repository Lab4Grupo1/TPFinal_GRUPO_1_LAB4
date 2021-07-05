package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import entidad.Cuentas;

public class CuentasDaoImpl {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_v2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	public int insert(Cuentas cuenta) {

		int filas = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "Insert into cuentas(cbu,fechacreacion,saldo,estado,FK_Idtipocuenta,FK_DniCliente) values ("
                    + "'" + cuenta.getCbu() + "'," 
                    + "('" + cuenta.getFechaCreacion() + "'),"
                    + cuenta.getSaldo() + ","
                    + cuenta.isEstado() + "," 
                    + cuenta.getTipoCuenta().getId() + ","
                    + cuenta.getDniCliente().getDni() +")";
			System.out.println(query);

			
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public int update(Cuentas cuenta) {

		int filas = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
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

		int filas = 0;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			Statement st = cn.createStatement();
			String query = "Update cuentas estado= false where nrocuenta= ('" + cuenta.getNumeroCuenta() + "')";
			filas = st.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}

	public Cuentas buscarCuenta(int numeroCuenta) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		TipoCuentasDaoImpl TipoImp = new TipoCuentasDaoImpl();
		DatosPersonalesDaoImpl DniImp = new DatosPersonalesDaoImpl();

		Connection cn = null;
		Cuentas x = new Cuentas();

		try {

			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM cuentas where numeroCuenta=" + numeroCuenta;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				x.setNumeroCuenta(numeroCuenta);
				x.setCbu(rs.getDouble("Cbu"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
			//	x.setSaldo(rs.getFloat("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(TipoImp.buscarId(rs.getInt("FK_idTipoCuenta")));
				x.setDniCliente(DniImp.buscarDNI(rs.getInt("FK_DniCliente")));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}

	public Cuentas buscarDni(int dni) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		TipoCuentasDaoImpl TipoImp = new TipoCuentasDaoImpl();
		DatosPersonalesDaoImpl DniImp = new DatosPersonalesDaoImpl();

		Connection cn = null;
		Cuentas x = new Cuentas();

		try {

			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM cuentas where numeroCuenta=" + dni;
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				x.setNumeroCuenta(rs.getInt("numeroCuenta"));
				x.setCbu(rs.getDouble("Cbu"));
				x.setFechaCreacion(rs.getDate("FechaCreacion").toLocalDate());
			//	x.setSaldo(rs.getFloat("Saldo"));
				x.setEstado(rs.getBoolean("Estado"));
				x.setTipoCuenta(TipoImp.buscarId(rs.getInt("FK_idTipoCuenta")));
				x.setDniCliente(DniImp.buscarDNI(dni));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return x;
	}
}
