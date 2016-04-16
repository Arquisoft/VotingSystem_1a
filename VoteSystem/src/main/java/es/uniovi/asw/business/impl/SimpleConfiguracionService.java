package es.uniovi.asw.business.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.uniovi.asw.business.ConfiguracionService;
import es.uniovi.asw.model.Configuracion;
import es.uniovi.asw.persistence.ConfigRepository;

@Component
public class SimpleConfiguracionService implements ConfiguracionService {

	@Autowired
	private ConfigRepository config;
	
	@Override
	public Configuracion getConf() {
		while(config.findAll().iterator().next() != null) {
			return config.findAll().iterator().next();
		}
		return null;
	}

}
