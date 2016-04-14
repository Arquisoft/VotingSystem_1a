package es.uniovi.asw.DBVote.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.DBVote.InsertVote;
import es.uniovi.asw.DBVote.Jpa;
import es.uniovi.asw.model.Voto;

public class InsertVoteP implements InsertVote{
	
	private static List<Voto> votos = new ArrayList<>();
	
	
	
	public static List<Voto> getVotos() {
		return votos;
	}

	public static void setVotos(List<Voto> votos) {
		InsertVoteP.votos = votos;
	}

	public void insertVoteR() throws Exception{
		if (votos.isEmpty()) {
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
				for (int i = 0; i < votos.size(); i++) {
					if(votos.get(i).getOpcion() != "" && votos.get(i).getOpcion() != null)
						em.persist(votos.get(i));
				}

				trx.commit();
			} catch (PersistenceException e) {
				System.out.println("Error en los datos");
				e.printStackTrace();
			} catch (RuntimeException bex) {
				bex.printStackTrace();
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
