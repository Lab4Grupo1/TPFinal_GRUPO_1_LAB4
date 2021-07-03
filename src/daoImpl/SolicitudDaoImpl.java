package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.SolicitudDao;
import entidad.Solicitud;

public class SolicitudDaoImpl  implements SolicitudDao{

	static String host = "localhost";
    static int port = 3306;
    static String db = "TPInt_GRUPO1_V6";
    static String user = "root";
    static String pass = "root";
    

    static String url = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", host, port, db);
	
	public ArrayList<Solicitud> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Solicitud> solicitud = new ArrayList<Solicitud>();
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT idSolicitud, FK_NCuenta, Montosolicitado, CantCuotasSolicitadas, EstadoSolicitud"
					+ " FROM solicitud;");
			
			while(rs.next()){
				
				Solicitud solicitudRs = new Solicitud();
				solicitudRs.setNumeroSolicitud(rs.getInt("idSolicitud"));
				solicitudRs.setNumeroCuenta(rs.getInt("FK_NCuenta"));
				solicitudRs.setMontoSolicitado(rs.getFloat("Montosolicitado"));
				solicitudRs.setCantCuotasSolicitado(rs.getInt("CantCuotasSolicitadas"));
				solicitudRs.setEstadoSolicitud(rs.getString("EstadoSolicitud"));
				
				
				solicitud.add(solicitudRs);
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return solicitud;
	}
	
	public boolean updateSolicitud(Solicitud solicitud) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		int filas=0;
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, user, pass);
			Statement st = conn.createStatement();
			
			String query = ("update solicitud set EstadoSolicitud =('"+solicitud.getEstadoSolicitud()+"')"
					+ "where idSolicitud =('"+solicitud.getNumeroSolicitud()+"')");
			
			filas = st.executeUpdate(query);
			if(filas > 0) {
				conn.close();
				return true;
			}
			
		
	}catch (SQLException e) {
		e.printStackTrace();
	}finally {
		
	}
		return false;
	
	}
	
	public ArrayList<Solicitud> buscar(String cliente){
		int cliente2 = Integer.parseInt(cliente);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Solicitud> solicitud = new ArrayList<Solicitud>();
		Connection conn = null;
		try {
			conn =  DriverManager.getConnection(url, user, pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT * FROM solicitud where FK_NCuenta =" + cliente2);
			
			while(rs.next()){
				Solicitud solicitudRs = new Solicitud();
				solicitudRs.setNumeroSolicitud(rs.getInt("idSolicitud"));
				solicitudRs.setNumeroCuenta(rs.getInt("FK_NCuenta"));
				solicitudRs.setMontoSolicitado(rs.getFloat("Montosolicitado"));
				solicitudRs.setCantCuotasSolicitado(rs.getInt("CantCuotasSolicitadas"));
				solicitudRs.setEstadoSolicitud(rs.getString("EstadoSolicitud"));
				solicitud.add(solicitudRs);
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return solicitud;
		
	}
	
	
}
