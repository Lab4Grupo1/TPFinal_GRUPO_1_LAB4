package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.RolDao;
import entidad.Rol;

public class RolDaoImpl implements RolDao{
	
	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	public List<Rol> readAll(){
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Rol> rol = new ArrayList<Rol>();
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery("SELECT id, Descripcion, Estado FROM rol");
			
			while(rs.next()){
				
				Rol rolRs = new Rol();
				rolRs.setId(rs.getInt("id"));
				rolRs.setDescripcion(rs.getString("Descripcion"));
				rolRs.setEstado(rs.getBoolean("Estado"));
				
				rol.add(rolRs);
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return rol;
		
	}
}
