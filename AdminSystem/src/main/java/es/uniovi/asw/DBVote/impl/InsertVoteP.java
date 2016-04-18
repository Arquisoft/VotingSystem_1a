package es.uniovi.asw.dbVote.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceException;

import es.uniovi.asw.dbVote.InsertVote;
import es.uniovi.asw.dbVote.Jpa;
import es.uniovi.asw.model.Voto;
import es.uniovi.asw.util.AdminException;

public class InsertVoteP implements InsertVote {

	private static List<Voto> votos = new ArrayList<>();

	public static void setVotos(List<Voto> votos) {
		InsertVoteP.votos = votos;
	}

	public void insertVoteR() throws AdminException {
		if (votos.isEmpty()) {
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
				for (int i = 0; i < votos.size(); i++) {
					if (votos.get(i).getOpcion() != "" && votos.get(i).getOpcion() != null){
						Voto voto = votos.get(i);
						
						List<Voto> votosBD = em.createNamedQuery("Voto.FindByOpcionLugar",Voto.class).setParameter(1, voto.getOpcion()).setParameter(2, voto.getLugar()).getResultList();
						if(!votosBD.isEmpty()){
							Voto votoBD =votosBD.get(0); 
							votoBD.setNumero(votoBD.getNumero() + voto.getNumero());
						}
						else{
							em.persist(voto);
						}
					}
				}

				trx.commit();
			} catch (PersistenceException e) {
				throw new AdminException("Ha ocurrido un error. Hay una opcion que no existe, o un lugar que no existe");
			} catch (RuntimeException bex) {
				bex.printStackTrace();
				trx.rollback();
				throw new AdminException("Ha ocurrido un error al guardar los datos en la base de datos");

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
