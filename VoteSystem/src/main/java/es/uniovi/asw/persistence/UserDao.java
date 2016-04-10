package es.uniovi.asw.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.uniovi.asw.model.User;


@Repository
public interface UserDao extends CrudRepository<User, Long> { 

	   public User findBynif(String nif);
}