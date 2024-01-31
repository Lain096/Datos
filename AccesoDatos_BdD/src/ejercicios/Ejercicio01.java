package ejercicios;

import java.sql.*;


/**
 * Obtener el apellido, oficio y salario de todos los empleados del departamento 10
 * 
 */
public class Ejercicio01 {

	public static void main(String[] args) {
		
		try {
			// Cargar el Driver, SIEMPRE lo primero
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// establecer la conexion a la base de Datos
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "user", "1234");
			
			// Preparar la consulta
			Statement sentencia = connection.createStatement();
			String sql = "SELECT apellido, oficio, salario FROM EMPLEADO WHERE dept_no = 10";
			ResultSet result = sentencia.executeQuery(sql);
			
			// Leemos las sentencias
			while(result.next()) {
				System.out.printf("Apellido: %s, Oficio: %s, Salario: %f %n", result.getString(1), result.getString(2), result.getFloat(3));
			}
			
			result.close();
			sentencia.close();
			connection.close();
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
}
