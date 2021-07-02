package daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import entidad.DatosPersonales;
import entidad.Nacionalidad;
import entidad.Telefonos;

public class DatosPersonalesDaoImpl {

	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "bdregistro";

	/*Crearupdate*/ 
	
	public int insert(DatosPersonales persona)
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
			String query = "Insert into usuario (DNI, Cuil, Nombre, Apellido, sexo, FK_Nacionalidad, FechaNacimiento,"
					+ " Direccion, Localidad, Provincia, Mail, FK_IdTelefono)  values"
			+ "	('"+persona.getDni()+"','"+persona.getCuil()+"," 
			+ "	('"+persona.getNombre()+"','"+persona.getApellido()+"," +persona.getSexo()+"," 
			+ "	('"+persona.getNacionalidad()+"','"+persona.getFechaNacimiento()+"," +persona.getDireccion()+"," 
			+ "	('"+persona.getLocalidad()+"','"+persona.getProvincia()+"," +persona.getMail()+"," 
			+ "	('"+persona.getTelefono()+"'"; 

		
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
	
	public int update(DatosPersonales persona)
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
			String query = "update usuario set"
					+ "DNI = '"+ persona.getDni()+"',"
					+ "Cuil =	'"+ persona.getCuil()+"',"
					+ "Nombre =	'"+ persona.getNombre()+"',"
					+ "Apellido =	'"+ persona.getApellido()+"',"
					+ "Sexo =	'"+ persona.getSexo()+"',"
					+ "Nacionalidad =	'"+ persona.getNacionalidad()+"',"
					+ "FechaNacimiento =	'"+ persona.getFechaNacimiento()+"',"
					+ "Direccion =	'"+ persona.getDireccion()+"',"
					+ "Localidad =	'"+ persona.getLocalidad()+"',"
					+ "Provincia =	'"+ persona.getProvincia()+"',"
					+ "Mail =	'"+ persona.getMail()+"',"
					+ "Telefono =	'"+ persona.getTelefono()+"'";

		
			filas=st.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return filas;
	}
  
	public List<DatosPersonales> readAll(){
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		ArrayList<DatosPersonales> DatosPersonales = new ArrayList<DatosPersonales>();
		Connection conn = null;
		try {
			conn = DriverManager.getConnection( host+dbName, user , pass);
			Statement st =   conn.createStatement();
			
			ResultSet rs = st.executeQuery(" SELECT DNI, Cuil, Nombre, Apellido, sexo, FK_Nacionalidad, FechaNacimiento,"
					+ " Direccion, Localidad, Provincia, Mail, FK_IdTelefono FROM datospersonales ;");
			
			while(rs.next()){ 
				DatosPersonales DatosPersonalesRs = new DatosPersonales(); 
				Nacionalidad NacionalidadRs = new Nacionalidad(); 
				Telefonos TelefonoRs = new Telefonos(); 
				
				NacionalidadRs.setNacionalidad(rs.getString("FK_Nacionalidad"));
				TelefonoRs.setNumero(rs.getString("FK_IdTelefono"));
				
				DatosPersonalesRs.setDni(rs.getInt("DNI"));
				DatosPersonalesRs.setCuil(rs.getInt("Cuil"));
				DatosPersonalesRs.setNombre(rs.getString("Nombre"));
				DatosPersonalesRs.setApellido(rs.getString("Apellido"));
				DatosPersonalesRs.setSexo(rs.getString("sexo"));
				DatosPersonalesRs.setNacionalidad(NacionalidadRs);
				DatosPersonalesRs.setFechaNacimiento(rs.getDate("FechaNacimiento"));
				DatosPersonalesRs.setDireccion(rs.getString("Direccion"));
				DatosPersonalesRs.setLocalidad(rs.getString("Localidad"));
				DatosPersonalesRs.setProvincia(rs.getString("Provincia"));
				DatosPersonalesRs.setMail(rs.getString("Mail"));
				DatosPersonalesRs.setTelefono(TelefonoRs); 
				
				DatosPersonales.add(DatosPersonalesRs);
				 
			}
			conn.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
		}
		return DatosPersonales;
		
	}
}
