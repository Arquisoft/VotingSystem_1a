package es.uniovi.asw.persistence;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.asw.model.Voto;
import es.uniovi.asw.model.VotoId;

@Transactional(readOnly = true)
@Repository
public interface VoteRepository extends CrudRepository<Voto, VotoId> {

	@Query("select v from Voto v where v.opcion=:opcion and v.lugar=:lugar")
	public Voto findByOptPlace(@Param("opcion") String opcion, @Param("lugar") long lugar);

}
