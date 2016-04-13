package es.uniovi.asw.persistence;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import es.uniovi.asw.model.OpcionVoto;

@Repository
public interface OptionsRepository extends CrudRepository<OpcionVoto, String> {

	   public List<OpcionVoto> findAll();
}
