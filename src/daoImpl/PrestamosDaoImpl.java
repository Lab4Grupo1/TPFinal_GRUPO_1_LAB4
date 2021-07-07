package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dao.PrestamosDao;
import entidad.Prestamos;
import entidad.Solicitud;


public class PrestamosDaoImpl implements PrestamosDao{

	static String host = "localhost";
    static int port = 3306;
    static String db = "tpint_grupo1_V2";
    static String user = "root";
    static String pass = "root";
    
    static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);

	@Override
	public boolean insertPrestamo(Prestamos prestamo) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		 int filas =0;
		 Connection conn = null;
		 try {
			 conn = DriverManager.getConnection(url, user, pass);
			 Statement st =   conn.createStatement();
			 
			 String query= "Insert into prestamos(cuotaspagas,cuotastotal, importeCuota, importePedido, FK_NumeroCuenta) values"
			 		+ " ('"+prestamo.getCuotasPagas()+"','"+prestamo.getCuotasTotal()+"','"+prestamo.getImporteCuota()+"','"
					 +prestamo.getImportePedidoTotal()+"','"+prestamo.getNumeroCuenta()+"')";
					 
			 filas = st.executeUpdate(query);
			 if(filas > 0) {
				conn.close();
				return true;
			 }
			 
			 
			 
		 }catch(SQLException e) {
				e.printStackTrace();
		}finally {
				
		}
		 return false;
		
	}
	
	public ArrayList<Prestamos> readAll(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Prestamos> lista  = new ArrayList<Prestamos>();
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT id, cuotaspagas, cuotastotal, importePedido, FechaUltimoPago, FK_NumeroCuenta, FechaUltimoPago  FROM prestamos");
			
			while(rs.next()){
				
				Prestamos prestamosRs  = new Prestamos();
				prestamosRs.setId(rs.getInt("id"));
				prestamosRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				prestamosRs.setCuotasTotal(rs.getInt("cuotastotal"));
			
				prestamosRs.setImportePedidoTotal(rs.getInt("importePedido"));
				//prestamosRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago"));
				
				lista.add(prestamosRs);
			
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return lista;
	}

	public ArrayList<Prestamos> BuscarPrestamo(String Nprestamo) {
		ArrayList<Prestamos> pres  = new ArrayList<Prestamos>();
		int NumPrestamos= Integer.parseInt(Nprestamo);
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT id, cuotaspagas, cuotastotal, importePedido,"
					+ " FechaUltimoPago, FK_NumeroCuenta, FechaUltimoPago FROM prestamos where id =" + NumPrestamos );
			
			while(rs.next()){
				Prestamos presRs= new Prestamos();
				presRs.setId(rs.getInt("id"));
				presRs.setCuotasPagas(rs.getInt("cuotaspagas"));
				presRs.setCuotasPagas(rs.getInt("cuotastotal"));
				presRs.setImportePedidoTotal(rs.getFloat("importePedido"));
				presRs.setFechaUltimoPago(rs.getDate("FechaUltimoPago"));
				presRs.setNumeroCuenta(rs.getInt("FK_NumeroCuenta"));
				
				pres.add(presRs);
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		
		return pres;
	}
}
