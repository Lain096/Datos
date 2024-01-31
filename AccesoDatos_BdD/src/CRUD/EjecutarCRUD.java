package CRUD;


import java.sql.SQLException;

public class EjecutarCRUD {
	
	public static void main(String[] args){		
		try {
			Departamento d = new Departamento();
			
			d.setNum_dept(22);
			d.setLocl("Burgos");
			d.setNombre("Brand");
			
			
			CrudDepartamento cd = new CrudDepartamento();
			
			cd.createDepartment(d);
			
			cd.updateDepartamento(d);
			
			cd.deleteDepartamento(d);
			
			Departamento p = cd.readDepartamento(10);
			
			System.out.println(p.getNum_dept() + " = Num_dept");
			System.out.println(p.getNombre() + " = Nombre");
			System.out.println(p.getLocl() + " = Localidad");
			
			cd.cerrarConexion();
			
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
