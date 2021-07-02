package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TiposMovimientoDao; 
import entidad.TipoMovimiento;

public class TipoMovimientoDaoImpl implements TiposMovimientoDao {

	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	public List<TipoMovimiento> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<TipoMovimiento> Tmovimiento = new ArrayList<TipoMovimiento>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery(" SELECT id, descripcion FROM tipomovimiento;");
			
			while(rs.next()){
				
				TipoMovimiento TmovimientoRs = new TipoMovimiento();
				TmovimientoRs.setDescripcion(rs.getString("descripcion"));
				
				Tmovimiento.add(TmovimientoRs);
				
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return Tmovimiento;
		
	}
	
	
}
