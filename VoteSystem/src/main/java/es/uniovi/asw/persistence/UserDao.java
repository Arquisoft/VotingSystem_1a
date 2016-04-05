package es.uniovi.asw.persistence;

import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.util.GenericDao;

public interface UserDao extends GenericDao<User, Long>{

	User findByLogin(String login);

}
