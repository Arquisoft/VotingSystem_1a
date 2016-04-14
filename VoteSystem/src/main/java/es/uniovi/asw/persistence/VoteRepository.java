package es.uniovi.asw.persistence;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import es.uniovi.asw.model.Voto;

@Transactional(readOnly=true)
@Repository
public interface VoteRepository extends CrudRepository<Voto,String> {
	
	@Query("select v from Voto v where v.opcion=:opcion and v.lugar=:lugar")
	public Voto findByOptPlace(@Param("opcion")String opcion,@Param("lugar")long lugar);
	
	
	@Modifying
	@Transactional
	@Query("update Voto v set v.numero=v.numero + 1 where v.opcion=:opcion and v.lugar=:lugar")
	public void updateVote(@Param("opcion")String opcion,@Param("lugar")long lugar);
	
	@Modifying
	@Transactional
	@Query("insert into Voto (opcion,lugar,numero)"+"select :opcion,:lugar,1 from Voto")
	public void insertVote(@Param("opcion")String opcion,@Param("lugar")long lugar);

}
