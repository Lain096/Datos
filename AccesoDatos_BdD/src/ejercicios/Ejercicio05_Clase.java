package ejercicios;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Crear un programa java que inserte un empleado en la tabla empleados, para
 * ello recibira desde la linea de argumentos, los valores a insertar Empleado
 * numero, apellido, oficio, director, salario, comision y num_dept
 * 
 * Antes de insertar, comprobar: - num de empleado no existe - El num de
 * departamento existe - el salario es >0 (no puede ser ni 0 ni negativo) - el
 * director existe - el apellido y el oficio no pueden ser nulos.
 * 
 * Visualizar un mensaje si se ha insertado correctamente o no. Si no se ha
 * insertado correctamente, avisar el por que
 */
public class Ejercicio05_Clase {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		Boolean correcto = false;
		Boolean salir = true;

		Integer num_emp = null;
		String ape = null;
		String ofi = null;
		Integer dir = null;
		Float salar = null;
		Float comis = null;
		Integer num_dept = null;
		try {
			// Cargar el driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Establecer la conexi�n con la BD
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/ejemplo", "user", "1234");
		
			
	
		

			do {
				try {
					
					
					System.out.println("Inserte el número del empleado");

					// Recuperar argumentos de "main"
					String num = sc.next();
					num_emp = Integer.parseInt(num); // num de empleado
					comprobarNumEmpleado(conexion, num_emp);

					System.out.println("Inserte el apellido del empleado");
					ape = sc.next(); // Nombre

					System.out.println("Inserte el oficio del empleado");
					ofi = sc.next(); // oficina
					comprobarApeYOfi(ape, ofi);

					System.out.println("Inserte el director del empleado");
					dir = sc.nextInt(); // num director
					comprobarDir(conexion, dir);

					System.out.println("Inserte el salario del empleado");
					salar = sc.nextFloat(); // flaot salario
					comprobarSalario(salar);
					
					
					System.out.println("Inserte la comision del empleado");
					comis = sc.nextFloat(); // float comis

					System.out.println("Inserte el número de departamento del empleado");
					num_dept = sc.nextInt();// num de departamento
					comprobarNumDept(conexion, num_dept);
					
					
					correcto = true;
					
					

				} catch (SQLException e) {
					System.out.println(e.getMessage());
					
					System.out.println("¿Deseas salir?");
					System.out.println("Si | No");
					
					String respuesta = sc.next();
					
					if(respuesta.toLowerCase().equals("si")) {
						correcto = true;
						salir = true;
					}

				} catch (InputMismatchException e) {
					
					System.out.println("Datos introducido inválidos");
					System.out.println("¿Deseas salir?");
					System.out.println("Si | No");
					
					String respuesta = sc.next();
					
					if(respuesta.toLowerCase().equals("si")) {
						correcto = true;
						salir = true;
					}

				} catch(NumberFormatException e) {
					System.out.println("Datos introducido inválidos");
					System.out.println("¿Deseas salir?");
					System.out.println("Si | No");
					
					String respuesta = sc.next();
					
					if(respuesta.toLowerCase().equals("si")) {
						correcto = true;
						salir = true;
					}
				}
			} while (!correcto);

			if (correcto && !salir) {

				String sqlp = "INSET INTO EMPLEADO VALUES (?,?,?,?,?,?,?,?)";
				
				
				
				
				try (PreparedStatement pstmt = conexion.prepareStatement(sqlp)) {
				    pstmt.setInt(1, num_emp);
				    pstmt.setString(2, ape);
				    pstmt.setString(3, ofi);
				    pstmt.setDate(4, Date.valueOf(LocalDate.now())); // Utilizando la fecha actual
				    pstmt.setFloat(5, salar);
				    pstmt.setFloat(6, comis);
				    pstmt.setInt(7, num_dept);
				    pstmt.setInt(8, dir);
				//    pstmt.setNull(1, java.sql.Types.BOOLEAN);
				    
				    System.out.println("Empelado añadido correctamente");
				    
				   
				}  catch (SQLException e) {
					// e.printStackTrace();
					System.out.printf("HA OCURRIDO UNA EXCEPCI�N:%n");
					System.out.printf("Mensaje   : %s %n", e.getMessage());
					System.out.printf("SQL estado: %s %n", e.getSQLState());
					System.out.printf("C�d error : %s %n", e.getErrorCode());
				}

				
				conexion.close(); // Cerrar conexion
			} 

		} catch (ClassNotFoundException cn) {
			cn.printStackTrace();
		} catch (SQLException e) {
			e.getMessage();
		} finally {
			
			System.out.println("Saliendo del programa");
			
		}

	} // Fin de main
	
	public static SQLException comprobarNumEmpleado(Connection conexion, Integer num) throws SQLException {

		Statement sentencia = conexion.createStatement();
		String sql = String.format("SELECT emp_no FROM EMPLEADO WHERE emp_no = '%d'", num);

		ResultSet rs = sentencia.executeQuery(sql);

		if (rs.next()) {
			throw new SQLException("El numero de empleado no es válido por que ya existe");
		}

		return null;
	}

	public static SQLException comprobarNumDept(Connection conexion, Integer num) throws SQLException {

		Statement sentencia = conexion.createStatement();

		String sql = String.format("SELECT * FROM EMPLEADO WHERE dept_no = '%d'", num);

		ResultSet rs = sentencia.executeQuery(sql);

		if (!rs.next()) {
			throw new SQLException("El numero de departamento ya existe");
			
		}
		return null;
	}

	public static void comprobarSalario(Float salario) throws SQLException {

		if (salario <= 0) {
			throw new SQLException("El salario no es válido");
		}

	}

	public static SQLException comprobarDir(Connection conexion, Integer dir) throws SQLException {

		Statement sentencia = conexion.createStatement();

		String sql = String.format("SELECT * FROM EMPLEADO WHERE dir = '%d'", dir);
		ResultSet rs = sentencia.executeQuery(sql);

		if (rs.next()) {
			return null;
		}

		throw new SQLException("El director no existe");
	}

	public static SQLException comprobarApeYOfi(String ape, String ofi) throws SQLException {

		if (ape == null) {
			throw new SQLException("El apellido no es válido");
		}

		if (ofi == null) {
			throw new SQLException("El oficio no es válido");
		}

		return null;
	}

}
