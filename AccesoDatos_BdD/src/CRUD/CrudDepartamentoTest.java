package CRUD;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;


import java.sql.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class CrudDepartamentoTest {

	private CrudDepartamento crud;

	
	
	//private static HikariDataSource hikari;
	
	
    @Before
    public void setUp() {
        try {
            crud = new CrudDepartamento();
        } catch (ClassNotFoundException | SQLException e) {
            fail("Error al inicializar la conexión: " + e.getMessage());
        }
    }

    @After
    public void tearDown() {
        try {
            crud.cerrarConexion();
        } catch (SQLException e) {
            fail("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    
    @Test
    void crearDepartamento() throws ClassNotFoundException, SQLException {
    	
    	Departamento nuevoDep = new Departamento();
    	
    	nuevoDep.setNum_dept(99);
    	nuevoDep.setNombre("PATATA");
    	nuevoDep.setLocl("HUERTO");
    	
    	CrudDepartamento crud = new CrudDepartamento();
    	
    	crud.createDepartment(nuevoDep);
    	
    	var dep = crud.readDepartamento(99);
    	assertNotNull(dep);
    	assertEquals("PATATA", dep.getNombre());
    	
    		
    	
    }
    
    
    @Test
    void borrarDepartamento() throws ClassNotFoundException, SQLException {
    	
    	Departamento nuevoDep = new Departamento();
    	
    	nuevoDep.setNum_dept(99);
    	nuevoDep.setNombre("PATATA");
    	nuevoDep.setLocl("HUERTO");
    	
    	CrudDepartamento crud = new CrudDepartamento();
    	
    	crud.deleteDepartamento(nuevoDep);
    	
    	var dep = crud.readDepartamento(99);
    	assertNotNull(dep);
    	assertNotEquals("PATATA", dep.getNombre());
    	
    		
    	
    }

      

}
