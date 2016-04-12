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
			
			res.setCodigoMesa(	Integer.parseInt(rs.getString("CODIGOMESA")));
			res.setName(  		rs.getString("name") );
			res.setEmail(  		rs.getString("email") );
			res.setPassword(  		rs.getString("contraseña") );
			
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
	public User findByDni(String login) {
		return jdbcTemplate.queryForObject(
				"USER_FIND_BY_DNI", 
				new UserMapper(), 
				login
			);
	}

}