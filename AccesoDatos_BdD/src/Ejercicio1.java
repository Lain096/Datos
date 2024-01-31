import java.sql.*;

public class Ejercicio1 {
	public static void main(String[] args) {
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establecer la conexion con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/ejemplo", "user", "1234");

			// Preparar la consulta
			Statement sentencia = conexion.createStatement();
			String sql = "SELECT * FROM Empleado";
			ResultSet resul = sentencia.executeQuery(sql);

			// Recorrer el resultado para visualizar cada fila
			// Se hace un bucle mientras haya registros y se van visualizando
			while (resul.next()) {
				System.out.printf("Nº: %d, Apellido: %s, Oficio: %s, Fecha_Alta: %tF, Salario: %f, Comision: %f, Nº Departamento: %d, Director: %d  %n", resul.getInt(1), resul.getString(2), 
						resul.getString(3), resul.getDate(4), resul.getFloat(5), resul.getFloat(6), resul.getInt(7), resul.getInt(8) );
			}

			resul.close(); // Cerrar ResultSet
			sentencia.close(); // Cerrar Statement
			conexion.close(); // Cerrar conexi�n

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} // Fin de main
} // Fin de la clase
