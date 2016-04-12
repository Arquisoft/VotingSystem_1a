package es.uniovi.asw.DBVote.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.DBVote.Jpa;
import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.model.LugarVoto;
import es.uniovi.asw.model.OpcionVoto;

public class InsertConfP {

	static Configuracion conf = null;
	static List<LugarVoto> lugares = new ArrayList<>();
	static List<OpcionVoto> opciones = new ArrayList<>();

	public static Configuracion getConf() {
		return conf;
	}

	public static void setConf(Configuracion conf) {
		InsertConfP.conf = conf;
	}

	public static List<LugarVoto> getLugares() {
		return lugares;
	}

	public static void setLugares(List<LugarVoto> lugares) {
		InsertConfP.lugares = lugares;
	}

	public static List<OpcionVoto> getOpciones() {
		return opciones;
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
	public static void insertConfR() throws Exception {
		if (conf == null || lugares.isEmpty() || opciones.isEmpty()) {
			throw new Exception();
		} else {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			EntityTransaction trx = null;
			try {
				emf = Jpa.getEmf();
				em = emf.createEntityManager();
				trx = em.getTransaction();
				trx.begin();
				em.persist(conf);
				for (int i = 0; i < lugares.size(); i++) {
					em.persist(lugares.get(i));
				}
				for (int i = 0; i < opciones.size(); i++) {
					em.persist(opciones.get(i));
				}

				trx.commit();
			} catch (PersistenceException e) {
				System.out.println("No se ha podido conectar con la base de datos");

			} catch (RuntimeException bex) {
				trx.rollback();
				System.out.println("Ha ocurrido un error al guardar los datos en la base de datos");
				throw bex;

			} finally {
				if (em != null) {
					if (em.isOpen()) {
						em.close();
					}

				}
			}
		}
	}
}
