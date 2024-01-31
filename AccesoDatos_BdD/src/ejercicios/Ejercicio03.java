package ejercicios;
import java.sql.*;

public class Ejercicio03 {
	public static void main(String[] args) {
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establecer la conexi�n con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "user", "1234");   
			// Crear el objeto DatabaseMetaData
			DatabaseMetaData dbmd = conexion.getMetaData();
			
			ResultSet resul = null;
		 
			String nombre   = dbmd.getDatabaseProductName();
			String driver   = dbmd.getDriverName();
			String url      = dbmd.getURL(); 
			String usuario  = dbmd.getUserName();
		 		 
			System.out.println("INFORMACI�N SOBRE LA BASE DE DATOS");
			System.out.println("==================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL    : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener informaci�n de las tablas y vistas que haya en la BD 		       
			resul = dbmd.getTables(null, "ejemplo", null, null);
		 
			while (resul.next()) {			   
				String catalogo = resul.getString(1); // Columna 1 
			    String esquema  = resul.getString(2); // Columna 2
			    String tabla    = resul.getString(3); // Columna 3
			    String tipo     = resul.getString(4); // Columna 4
  			    System.out.printf("%s - Cat�logo: %s, Esquema: %s, Nombre: %s %n", tipo, catalogo, esquema, tabla);
			}   				
			// Cerrar conexion   
			conexion.close();
		} 
		catch (ClassNotFoundException cn) {cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}		
	} // Fin de main
}
