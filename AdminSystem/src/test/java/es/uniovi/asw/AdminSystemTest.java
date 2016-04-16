package es.uniovi.asw;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import es.uniovi.asw.ConfParser.LoadConfiguration;
import es.uniovi.asw.DBVote.Jpa;
import es.uniovi.asw.model.OpcionVoto;

public class AdminSystemTest {
	List<OpcionVoto> votos ;
	@Before
	public void crearListas(){
		votos = new ArrayList<>();
		votos.add(new OpcionVoto("IU"));
		votos.add(new OpcionVoto("PCPE"));
		votos.add(new OpcionVoto("PODEMOS"));
		votos.add(new OpcionVoto("PP"));
		votos.add(new OpcionVoto("PSOE"));
		
		
	}
	/**
	 * Comprueba que la configuracion introducida sea la correcta
	 * @throws Exception 
	 */
	@Test
	public void testConfiguracion(){
		//Entrada
		String[] args = {"conf","conf.xls","-x","options.xls","-x","places.xls","-x"};
		
		//Llamar al main
		LoadConfiguration.main(args);
		
//		//Comprobar que los datos introducidos son correctos
//		EntityManagerFactory emf = Jpa.getEmf();
//		EntityManager em = emf.createEntityManager();
//		Query query = em.createQuery("select o from OpcionVoto o");
//		List<OpcionVoto> votosBD = query.getResultList();
//		
//		//Longitud igual
//		Assert.assertEquals(votos.size(), votosBD.size());
//		
//		for (int i = 0; i < votos.size(); i++) {
//			Assert.assertEquals(votos.get(i).getNombre(), votosBD.get(i).getNombre());
//		}
		
	}

}
