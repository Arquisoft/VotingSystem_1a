package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.LugarVoto;


@Repository
public interface MesaRepository extends CrudRepository<LugarVoto, Long> { 

	   public LugarVoto findByid(Long id);
	   
}