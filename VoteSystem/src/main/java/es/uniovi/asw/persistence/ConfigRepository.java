package es.uniovi.asw.persistence;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.Conf;
import es.uniovi.asw.model.Configuracion;

@Repository
public interface ConfigRepository extends CrudRepository<Configuracion, Conf> {
	
	


}
