package es.uniovi.asw.infraestructure;

import es.uniovi.asw.business.ServicesFactory;
import es.uniovi.asw.business.impl.SimpleServicesFactory;
import es.uniovi.asw.persistence.PersistenceFactory;
import es.uniovi.asw.persistence.impl.SimplePersistenceFactory;

public class Factories {

	public static ServicesFactory services = new SimpleServicesFactory();
	public static PersistenceFactory persistence = new SimplePersistenceFactory();

}