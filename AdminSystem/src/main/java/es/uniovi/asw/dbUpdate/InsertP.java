package es.uniovi.asw.dbUpdate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.model.User;
import es.uniovi.asw.reportWriter.WriteReport;

public class InsertP implements Insert {

	
		
		@SuppressWarnings({ "unchecked", "finally" })
		public boolean insertarUsuarios(List<User> usuarios) {
			boolean result=false;
			WriteReport report = new WreportR();

			EntityManagerFactory emf = null;
			EntityManager em = null;
			EntityTransaction trx = null;
			try {
				emf = Jpa.getEmf();
				em = emf.createEntityManager();
				trx = em.getTransaction();
				trx.begin();
			

				
				for (User usuario : usuarios) {
					List<User> users = em.createNamedQuery("User.findByNameDni").setParameter(1, usuario.getNIF())
							.setParameter(2, usuario.getName()).getResultList();

					if (users.size() == 0)
						em.persist(usuario);
				}
				
				

				trx.commit();
				result=true;
			} catch (PersistenceException e) {
				System.out.println("No se ha podido conectar con la base de datos");
				report.log("No se ha podido conectar con la base de datos");
				
			}
			catch (RuntimeException bex) {
				trx.rollback();
				System.out.println("Ha ocurrido un error al guardar los usuarios en la base de datos");
				report.log("Ha ocurrido un error al guardar los usuarios en la base de datos");
				throw bex;
				
			} finally {
				if (em != null) {
					if (em.isOpen()) {
						em.close();
					}
					
				}
				return result;
			}
		}
}
