package ejemploPersistence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Main {

	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("unidad");

		EntityManager em = emf.createEntityManager();

		Empleado employer = new Empleado();

		// empezamso transacción
		em.getTransaction().begin();
		try {

//			// em.persist(employer);
			Empleado e = new Empleado();
			
			e = em.find(Empleado.class, 10);
			
//			if(e.getApellido() != "Martínez") {
//				throw new Exception ("No existe ese empleado");
//			}
			
			e.setApellido("Diaz");
			
			
			
			if ((e = em.getReference(Empleado.class, 11)) != null) {
				System.out.println("Se ha remoovido, no agitado");
				em.remove(e);
			} else {
				System.out.println("No se ha removido, se ha agitado");
				throw new Exception("Rollback");
			}

			// Commiteamos la transaccon
			em.getTransaction().commit();
			
		} catch (Exception e) {
			
			em.getTransaction().rollback();
			//em.flush();
			System.out.println(e.getMessage());
			
		} finally {
			em.close();
			emf.close();
		}
	}
}
