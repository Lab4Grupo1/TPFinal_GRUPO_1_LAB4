package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TiposCuentaDao; 
import entidad.TipoCuentas; 

public class TipoCuentasDaoImpl implements TiposCuentaDao {

	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	public List<TipoCuentas> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<TipoCuentas> Tcuenta = new ArrayList<TipoCuentas>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery(" SELECT id, descripcion FROM TipoCuenta;");
			
			while(rs.next()){
				
				TipoCuentas TcuentaRs = new TipoCuentas(); 
				TcuentaRs.setDescripcion(rs.getString("descripcion"));
				
				Tcuenta.add(TcuentaRs);
				
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return Tcuenta;
		
	}
	
	
}
