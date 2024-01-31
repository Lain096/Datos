package ejercicios;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * El apellido, el salario y el Nombre del departamento del empleado que mas cobre dentro de la empresa 
 */
public class Ejercicio02 {
public static void main(String[] args) {

		
		try {
			// Cargar el Driver, SIEMPRE lo primero
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establecer la conexion a la base de Datos
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "user", "1234");
			
			// Preparar la consulta
			Statement sentencia = connection.createStatement();
			String sql = "SELECT e.apellido, e.salario, d.dnombre FROM EMPLEADO e, Departamento d WHERE e.dept_no = d.dept_no AND e.salario = (SELECT MAX(salario) FROM Empleado)";
			ResultSet result = sentencia.executeQuery(sql);
			
			// Leemos las sentencias
			while(result.next()) {
				System.out.printf("Apellido: %s, Salario: %f, Nombre_Dept: %s %n", result.getString(1),  result.getFloat(2), result.getString(3));
			}
			
			result.close();
			sentencia.close();
			connection.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}