package es.uniovi.asw.dbVotePetar.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.dbVotePetar.InsertConf;
import es.uniovi.asw.dbVotePetar.Jpa;
import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.model.OpcionVoto;
import es.uniovi.asw.util.AdminException;

public class InsertConfP implements InsertConf {

	private static final String PLACES_DELETE = "delete from LugarVoto";
	private static final String CONFIG_DELETE = "delete from Configuracion";
	private static final String OPTIONS_DELETE = "delete from OpcionVoto";
	private static final String VOTES_DELETE = "delete from Voto";

	static Configuracion conf = null;
	static List<LugarVoto> lugares = new ArrayList<>();
	static List<OpcionVoto> opciones = new ArrayList<>();

	public static void setConf(Configuracion conf) {
		InsertConfP.conf = conf;
	}

	public static void setLugares(List<LugarVoto> lugares) {
		InsertConfP.lugares = lugares;
	}

	public static void setOpciones(List<OpcionVoto> opciones) {
		InsertConfP.opciones = opciones;
	}

	/**
	 * Almacena toda la informacion de configuracion , junto con los lugares de
	 * voto y las opciones de voto en la BD
	 * 
	 * @throws Exception
	 */
	public void insertConfR() throws AdminException {
		if (conf == null || lugares.isEmpty() || opciones.isEmpty()) {
			throw new AdminException("El fichero de votos esta vacio");
		} else {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			EntityTransaction trx = null;
			try {
				try{
					emf = Jpa.getEmf();
					}
					catch(Exception e){
						throw new AdminException("Ha ocurrido un error al conectar a la base de datos");
					}
				em = emf.createEntityManager();
				trx = em.getTransaction();
				trx.begin();
				vaciarBD(em);
				em.persist(conf);
				for (int i = 0; i < lugares.size(); i++) {
					if (lugares.get(i).getNombre() != "" && lugares.get(i).getNombre() != null)
						em.persist(lugares.get(i));
				}
				for (int i = 0; i < opciones.size(); i++) {
					if (opciones.get(i).getNombre() != "" && opciones.get(i).getNombre() != null)
						em.persist(opciones.get(i));
				}
				trx.commit();

			} catch (PersistenceException e) {
				throw new AdminException("No se ha podido conectar con la base de datos");

			} catch (RuntimeException bex) {
//				bex.printStackTrace();
				trx.rollback();
				throw new AdminException("Ha ocurrido un error al guardar los datos en la base de datos");
//				throw bex;

			} finally {
				if (em != null) {
					if (em.isOpen()) {
						em.close();
					}

				}
			}
		}
	}

	/**
	 * Vacia la base de datos. Recibe un EntityManager para evitar reabrir la
	 * conexion
	 * 
	 * @param trx
	 */
	private static void vaciarBD(EntityManager em) {
		em.createQuery(VOTES_DELETE).executeUpdate();
		em.createQuery(PLACES_DELETE).executeUpdate();
		em.createQuery(OPTIONS_DELETE).executeUpdate();
		em.createQuery(CONFIG_DELETE).executeUpdate();

	}

}
