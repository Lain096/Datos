package ejercicios;
import java.sql.*;

// Visualizar informacion de todas las columnas de la tabla departamentos
public class Ejercicio03_HacerClase {
	
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
			resul = dbmd.getColumns(null, null, "Departamento", null);
		 
			while (resul.next()) {			   
			  
  			System.out.println("Tabla: " + resul.getString(3) + "Nombre Col: " + resul.getString(4) + " Long: " + resul.getString(5));
			}   				
			// Cerrar conexion   
			conexion.close();
		} 
		catch (ClassNotFoundException cn) {cn.printStackTrace();} 
		catch (SQLException e) {e.printStackTrace();}		
	} // Fin de main

}
