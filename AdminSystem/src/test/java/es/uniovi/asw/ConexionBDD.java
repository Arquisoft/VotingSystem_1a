package es.uniovi.asw;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.dbUpdate.Jpa;
import es.uniovi.asw.model.User;


public class ConexionBDD {
	
	private static ConexionBDD conexion;
	
	private ConexionBDD(){
		
	}

	private EntityManager conexion() {
		
		EntityManagerFactory emf = null;
		EntityManager em = null;

		try {
			emf = Jpa.getEmf();
			em = emf.createEntityManager();


		} catch (PersistenceException e) {
			System.out.println("No se ha podido conectar con la base de datos");
		}
		
		return em;

	}
	
	public void cerrarConexion(EntityManager em){
		if (em != null) {
			if (em.isOpen()) {
				em.close();
			}
		}
	}
	
	public List<User> obtenerUsuarios(){
		
		EntityManager em = conexion();

	
		@SuppressWarnings("unchecked")
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		
		cerrarConexion(em);
		
		return users;
	
	}
	
	public void eliminarDB()
	{
		EntityManager em = conexion();

		EntityTransaction trx=em.getTransaction();
		trx.begin();
		@SuppressWarnings("unchecked")
		List<User> users = em.createNamedQuery("User.findAll").getResultList();
		
		for(User u:users)
		{
			User user=em.find(User.class,u.getId());
			em.remove(user);
		}
		trx.commit();
		
	
		
		cerrarConexion(em);
	}
	

	
	
	public static ConexionBDD getConexion(){
		if(conexion==null){
			conexion = new ConexionBDD();
		}
		
		return conexion;
	}

}
