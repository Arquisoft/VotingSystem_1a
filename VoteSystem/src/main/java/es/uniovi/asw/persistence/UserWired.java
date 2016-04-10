package es.uniovi.asw.persistence;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import es.uniovi.asw.model.User;


@RestController
public class UserWired {
	
		@Autowired
		private UserDao daoUsuarios;

		public User findBynif(String dni){
			return daoUsuarios.findBynif(dni);
		}

}
