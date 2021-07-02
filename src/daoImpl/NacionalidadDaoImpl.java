package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.NacionalidadDao;
import entidad.Nacionalidad; 

public class NacionalidadDaoImpl implements NacionalidadDao {

	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	public List<Nacionalidad> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Nacionalidad> Nacionalidad = new ArrayList<Nacionalidad>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery(" SELECT id, Nacionalidad FROM Nacionalidad;");
			
			while(rs.next()){
				
				Nacionalidad NacionalidadRs = new Nacionalidad(); 
				NacionalidadRs.setNacionalidad(rs.getString("descripcion"));
				
				Nacionalidad.add(NacionalidadRs);
				
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return Nacionalidad;
		
	}
}
