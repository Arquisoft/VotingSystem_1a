package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.Votante;

@Repository
public interface VotantesRepository extends CrudRepository<Votante, String> { 

	   public Votante findByDni(String dni);
	
}