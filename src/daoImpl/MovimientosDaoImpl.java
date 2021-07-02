package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.MovimientosDao;
import entidad.Movimientos;

public class MovimientosDaoImpl implements MovimientosDao {

	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	public List<Movimientos> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Movimientos> Movimiento = new ArrayList<Movimientos>();
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT id, Detalle, Fecha, Importe, FK_IdTipoMovimiento FROM movimientos;");
			
			while(rs.next()){
				
				Movimientos MovimientoRs = new Movimientos();
				MovimientoRs.setId(rs.getInt("id"));
				MovimientoRs.setDetalle(rs.getString("Detalle"));
				MovimientoRs.setFecha(rs.getDate("Fecha"));
				MovimientoRs.setImporte(rs.getFloat("Importe"));
				//MovimientoRs.setTipoMovimiento(rs.getInt("FK_IdTipoMovimiento"));
				
				Movimiento.add(MovimientoRs);
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return Movimiento;
		
	}
	
	
}
