package es.uniovi.asw.confParser.factoria;

import es.uniovi.asw.confParser.Parser.places.ParserPlaces;
import es.uniovi.asw.confParser.Parser.places.impl.ParserPlacesXLS;

public class FactoriaParserPlaces {

	public static ParserPlaces crearParserXLS() {
		return new ParserPlacesXLS();
	}

}
