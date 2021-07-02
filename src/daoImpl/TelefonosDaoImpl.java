package daoImpl;
 

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.TelefonosDao;
import entidad.Telefonos;

public class TelefonosDaoImpl  implements TelefonosDao{

	private String host = "jdbc:mysql://localhost:3006/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "TPInt_GRUPO1_V2";
	
	public int insert(Telefonos tel)
	{		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "Insert into telefono(numero)  values ( " +tel.getNumero()+ ")";

		
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public int update(Telefonos tel)
	{		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		int filas=0;
		Connection cn = null;
		try
		{
			cn = DriverManager.getConnection(host+dbName, user,pass);
			Statement st = cn.createStatement();
			String query = "update Telefonos set numero = '"+ tel.getNumero()+ "'";

		
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public List<Telefonos> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<Telefonos> Telefonos = new ArrayList<Telefonos>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery(" SELECT id, numero FROM TipoCuenta;");
			
			while(rs.next()){
				
				Telefonos TelefonosRs = new Telefonos(); 
				TelefonosRs.setNumero(rs.getString("numero")); 
				Telefonos.add(TelefonosRs);
				
				
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return Telefonos;
		
	}

	 
	
	 
}
