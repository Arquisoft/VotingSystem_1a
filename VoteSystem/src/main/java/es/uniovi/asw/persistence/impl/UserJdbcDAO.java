package es.uniovi.asw.persistence.impl;



import java.sql.ResultSet;
import java.sql.SQLException;

import es.uniovi.asw.model.User;
import es.uniovi.asw.persistence.UserDao;
import es.uniovi.asw.persistence.util.JdbcTemplate;
import es.uniovi.asw.persistence.util.RowMapper;



public class UserJdbcDAO implements UserDao {

	public class UserMapper implements RowMapper<User> {

		@Override
		public User toObject(ResultSet rs) throws SQLException {
			User res = new User();
			
			res.setId(  		rs.getLong("id") );
			res.setLogin(  		rs.getString("login") );
			res.setPassword(  	rs.getString("password") );
			res.setName(  		rs.getString("name") );
			res.setSurname(  	rs.getString("surname") );
			res.setEmail(  		rs.getString("email") );
			
			return res;
		}

	}
	
	private	JdbcTemplate jdbcTemplate = new JdbcTemplate();


	@Override
	public User findById(Long id) {
		return jdbcTemplate.queryForObject(
				"USER_FIND_BY_ID", 
				new UserMapper(), 
				id
			);
	}


	@Override
	public User findByLogin(String login) {
		return jdbcTemplate.queryForObject(
				"USER_FIND_BY_LOGIN", 
				new UserMapper(), 
				login
			);
	}

}