package es.uniovi.asw.persistence.util;

public interface GenericDao<T,K> {
	
	T findById(K id);
}
