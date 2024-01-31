package ejercicios;

import java.sql.*;

public class Ejercicio06_CrearVista {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		// Cargar el driver
		Class.forName("com.mysql.cj.jdbc.Driver");

		// Establecer la conexion con la BD
		Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "user", "1234");

		// Construir la orden VIEW
		StringBuilder sql = new StringBuilder();
		sql.append("CREATE OR REPLACE VIEW totales ");
		sql.append("(dep, dnombre, nemp, media) AS ");
		sql.append("SELECT d.dept_no, dnombre, COUNT(emp_no), AVG(salario) ");
		sql.append("FROM departamento d LEFT JOIN empleado e " );
		sql.append("ON e.dept_no = d.dept_no ");
		sql.append("GROUP BY d.dept_no, dnombre ");
		System.out.println(sql);
		
		Statement sentencia = conexion.createStatement();
		int filas = sentencia.executeUpdate(sql.toString());
		System.out.printf("Resultado  de la ejecuci�n: %d %n", filas);

		sentencia.close(); // Cerrar Statement
		conexion.close();  // Cerrar conexion

	} // Fin de main
}
