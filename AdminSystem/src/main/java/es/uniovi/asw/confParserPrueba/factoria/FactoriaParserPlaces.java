package es.uniovi.asw.confParserPrueba.factoria;

import es.uniovi.asw.confParserPrueba.Parser.places.ParserPlaces;
import es.uniovi.asw.confParserPrueba.Parser.places.impl.ParserPlacesXLS;

public class FactoriaParserPlaces {

	public static ParserPlaces crearParserXLS() {
		return new ParserPlacesXLS();
	}

}
