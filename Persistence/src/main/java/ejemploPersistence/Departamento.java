package ejemploPersistence;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Departamento {

	@Id
	private int dept_no;
	
	private String dnombre;
	private String loc;
	
	
	public Departamento() {
		// TODO Auto-generated constructor stub
	}


	public int getDept_no() {
		return dept_no;
	}


	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}


	public String getNombre() {
		return dnombre;
	}


	public void setNombre(String nombre) {
		this.dnombre = nombre;
	}


	public String getLocalidad() {
		return loc;
	}


	public void setLocalidad(String localidad) {
		this.loc = localidad;
	}
	
	
	
}
