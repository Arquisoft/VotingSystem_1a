package es.uniovi.asw.persistence.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface RowMapper<T> {

	T toObject(ResultSet rs) throws SQLException;
	
}