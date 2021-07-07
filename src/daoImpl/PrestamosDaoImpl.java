package daoImpl;


import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import dao.PrestamosDao;
import entidad.Prestamos;

public class PrestamosDaoImpl implements PrestamosDao{

	static String host = "localhost";
    static int port = 3306;
    static String db = "TPInt_GRUPO1_V6";
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
			 
			 String query= "Insert into prestamos(cuotaspagas,cuotastotal, importeCuota, importePedido, FK_NumeroCuenta) values ("
			 		 + prestamo.getCuotasPagas()+","
					 + prestamo.getCuotasTotal()+","
					 + prestamo.getImporteCuota()+"," 
					 + prestamo.getImportePedidoTotal()+","
					 + prestamo.getNumeroCuenta()+")";
					 
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
	
}
