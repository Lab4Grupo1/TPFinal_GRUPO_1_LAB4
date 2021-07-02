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

	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	
	public List<Solicitud> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		
		ArrayList<Solicitud> solicitud = new ArrayList<Solicitud>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT idSolicitud, FK_NCuenta, MontoSolicitado, CantCuotasSolicitadas,"
					+ " FechaEmitida, CuentaDepositar FROM solicitud where EstadoSolicitud like '%pendiente%'");
			
			while(rs.next()){
				
				Solicitud solicitudRs = new Solicitud();
				solicitudRs.setNumeroSolicitud(rs.getInt("idSolicitud"));
				solicitudRs.setNumeroCuenta(rs.getInt("FK_NCuenta"));
				solicitudRs.setMontoSolicitado(rs.getFloat("MontoSolicitado"));
				solicitudRs.setCantCuotasSolicitado(rs.getInt("CantCuotasSolicitadas"));
				solicitudRs.setFechaEmitida(rs.getDate("FechaEmitida"));
				solicitudRs.setCuentaDepositar(rs.getInt("CuentaDepositar"));
				
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
			conn = DriverManager.getConnection( host+dbName, user , pass);
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
	
}
