package ejemploPersistence;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Empleado {

	@Id
	private int emp_no;
	private String apellido;
	private String oficio;
	private Date fecha_alt;
	private Float comision;
	private int dept_no;
	private int dir;
	
	
	
	public Empleado() {
		super();
		// TODO Auto-generated constructor stub
	}



	public int getEmp_no() {
		return emp_no;
	}



	public void setEmp_no(int emp_no) {
		this.emp_no = emp_no;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getOficio() {
		return oficio;
	}



	public void setOficio(String oficio) {
		this.oficio = oficio;
	}



	public Date getFecha_alt() {
		return fecha_alt;
	}



	public void setFecha_alt(Date fecha_alt) {
		this.fecha_alt = fecha_alt;
	}



	public Float getComision() {
		return comision;
	}



	public void setComision(Float comision) {
		this.comision = comision;
	}



	public int getDept_no() {
		return dept_no;
	}



	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}



	public int getDir() {
		return dir;
	}



	public void setDir(int dir) {
		this.dir = dir;
	}

	@Override
	public String toString() {
		
		return "Empleado " + apellido;
	}
	
	
}
