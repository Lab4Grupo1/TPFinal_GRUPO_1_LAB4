package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import dao.MovimientosDao;
import entidad.Movimientos;

public class MovimientosDaoImpl implements MovimientosDao {

	static String host = "localhost";
	static int port = 3306;
	static String db = "tpint_grupo1_v2";
	static String user = "root";
	static String pass = "root";

	static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	TipoMovimientoDaoImpl TipoMovImp = new TipoMovimientoDaoImpl();
	CuentasDaoImpl CueImp = new CuentasDaoImpl();


	@Override
	public ArrayList<Movimientos> readAll() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Movimientos> lmov = new ArrayList<Movimientos>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM movimientos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Movimientos x = new Movimientos();
				x.setId(rs.getInt("id"));
				x.setDetalle(rs.getString("Detalle"));
				x.setFecha(rs.getDate("Fecha"));
				x.setImporte(rs.getFloat("Importe"));
				x.setTipoMovimiento(TipoMovImp.buscarID(rs.getInt("FK_IdTipoMovimiento")));
				x.setCuenta(CueImp.buscarCuenta(rs.getInt("FK_IdCuentas")));
				lmov.add(x);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmov;
	}


	@Override
	public ArrayList<Movimientos> buscarDNI(int dni, int tipoCuenta) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		ArrayList<Movimientos> lmov = new ArrayList<Movimientos>();

		Connection cn = null;
		try {
			cn = DriverManager.getConnection(url, user, pass);
			String query = "SELECT * FROM movimientos";
			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Movimientos x = new Movimientos();
				x.setId(rs.getInt("id"));
				x.setDetalle(rs.getString("Detalle"));
				x.setFecha(rs.getDate("Fecha"));
				x.setImporte(rs.getFloat("Importe"));
				x.setTipoMovimiento(TipoMovImp.buscarID(rs.getInt("FK_IdTipoMovimiento")));
				x.setCuenta(CueImp.buscarCuenta(rs.getInt("FK_IdCuentas")));
				if (x.getCuenta().getTipoCuenta().getId() == tipoCuenta
						&& x.getCuenta().getDniCliente().getDni() == dni) {
					lmov.add(x);
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return lmov;
	}
}
