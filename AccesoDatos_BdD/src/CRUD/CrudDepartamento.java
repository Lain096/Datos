package CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CrudDepartamento {

	private Connection conexion;
	private Statement sentencia;

	public CrudDepartamento() throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "root", "bollicao");

	}

	public void cerrarConexion() throws SQLException {
		conexion.close();
	}

	public void createDepartment(Departamento dpt) throws SQLException {

		String sql = "INSERT INTO Departamento VALUES (?,?,?)";

		try (PreparedStatement pStatement = conexion.prepareStatement(sql)) {
			pStatement.setInt(1, dpt.getNum_dept());
			pStatement.setString(2, dpt.getNombre());
			pStatement.setString(3, dpt.getLocl());

			int filasAfectadas = pStatement.executeUpdate();

			// Verificar si se realizaron actualizaciones
			if (filasAfectadas > 0) {
				System.out.println("Inserción exitosa. Filas afectadas: " + filasAfectadas);
			} else {
				System.out.println("No se encontró el departamento para añadir.");
			}
		}
	}

	public void updateDepartamento(Departamento dpt) throws SQLException {

		String sql = "UPDATE Departamento " + "SET dnombre = ?," + " loc = ?" + " WHERE dept_no = ? ";

		try (PreparedStatement pStatement = conexion.prepareStatement(sql)) {
			pStatement.setString(1, dpt.getNombre());
			pStatement.setString(2, dpt.getLocl());
			pStatement.setInt(3, dpt.getNum_dept());

			// Ejecutar la actualización
			int filasAfectadas = pStatement.executeUpdate();

			// Verificar si se realizaron actualizaciones
			if (filasAfectadas > 0) {
				System.out.println("Actualización exitosa. Filas afectadas: " + filasAfectadas);
			} else {
				System.out.println("No se encontró el departamento para actualizar.");
			}
		}
	}

	public void deleteDepartamento(Departamento dpt) throws SQLException {

		String sql = "DELETE FROM Departamento WHERE dept_no = ?";

		try (PreparedStatement pStatement = conexion.prepareStatement(sql)) {
			pStatement.setInt(1, dpt.getNum_dept());

			int filasAfectadas = pStatement.executeUpdate();

			// Verificar si se realizaron actualizaciones
			if (filasAfectadas > 0) {
				System.out.println("Actualización exitosa. Filas afectadas: " + filasAfectadas);
			} else {
				System.out.println("No se encontró el departamento para actualizar.");
			}
		}
	}

	
	public Departamento readDepartamento(int num_dept) throws SQLException {

		String sql = "SELECT * FROM Departamento WHERE dept_no = ?";

		try (PreparedStatement pStatement = conexion.prepareStatement(sql)) {
			
			pStatement.setInt(1, num_dept);

			try (ResultSet rs = pStatement.executeQuery()) {

				Departamento dpt = new Departamento();

				while (rs.next()) {

					dpt.setNum_dept(num_dept);
					dpt.setNombre(rs.getString(2));
					dpt.setLocl(rs.getString(3));

				}

				return dpt;

			} catch (SQLException e) {

				throw new SQLException("No hay ningún departamento con ese número");
			}

		} catch (SQLException e) {
			
			throw new SQLException("No se ha podido ejecutar la sentencia");
		}

	}

}
