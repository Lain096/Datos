package ejercicios;
import java.sql.*;

/*
 * Realizar un procedimiento en MySQL (o funcion) que reciba un numero de departamento y devuelva 
 * el numero de empleados y el salario medio de dicho departamento
 * 
 * realizar un programa java para usar dicho procedimiento.
 * 
 * 
 * 
 */
public class Ejercicio07_Tarea {

	
	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "ejemplo", "ejemplo");
			
			
			
			
			
			
			
			
			
		}catch(Exception e) {
			
		}
	}
}
