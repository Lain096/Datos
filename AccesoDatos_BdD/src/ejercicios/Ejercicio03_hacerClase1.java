package ejercicios;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// Visualizar informacion de las claves primarias y ajenas de la tabla departamentos y empleados
public class Ejercicio03_hacerClase1 {
	public static void main(String[] args) {

		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establecer la conexi�n con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "user", "1234");
			// Crear el objeto DatabaseMetaData
			DatabaseMetaData dbmd = conexion.getMetaData();

			ResultSet resul = null;

			String nombre = dbmd.getDatabaseProductName();
			String driver = dbmd.getDriverName();
			String url = dbmd.getURL();
			String usuario = dbmd.getUserName();

			System.out.println("INFORMACI�N SOBRE LA BASE DE DATOS");
			System.out.println("==================================");
			System.out.printf("Nombre : %s %n", nombre);
			System.out.printf("Driver : %s %n", driver);
			System.out.printf("URL    : %s %n", url);
			System.out.printf("Usuario: %s %n", usuario);

			// Obtener informaci�n de las tablas y vistas que haya en la BD
			resul = dbmd.getExportedKeys(null, null, "Departamento");

			while (resul.next()) {

				System.out.println("Nombre de la columna de clave primaria de Departamento: " + resul.getString(4));
				System.out.println("Nombre de la columna de clave donde es exportada: " + resul.getString(8));
			}
			
			resul = dbmd.getExportedKeys(null, null, "Empleado");

			while (resul.next()) {

				System.out.println("Nombre de la columna de clave primaria de Empleado: " + resul.getString(4));
				System.out.println("Nombre de la columna de clave donde es exportada: " + resul.getString(8));
			}
			
			resul = dbmd.getImportedKeys(null, null, "Departamento");

			while (resul.next()) {

				System.out.println("Nombre de la columna de clave primaria de asdasd: " + resul.getString(4));
				System.out.println("Nombre de la columna de clave secundaria de Deasdasdpartamento: " + resul.getString(8));
			}
			
			resul = dbmd.getImportedKeys(null, null, "Empleado");

			while (resul.next()) {

				System.out.println("Nombre de la columna de clave primaria de Empleado: " + resul.getString(4));
				System.out.println("Nombre de la columna de clave secundaria de Empleado: " + resul.getString(8));
			}
			
			// Cerrar conexion
			conexion.close();
		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // Fin de main

}
