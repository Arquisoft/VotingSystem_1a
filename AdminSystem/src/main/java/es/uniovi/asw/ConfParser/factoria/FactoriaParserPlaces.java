package es.uniovi.asw.ConfParser.factoria;

import es.uniovi.asw.ConfParser.Parser.places.ParserPlaces;
import es.uniovi.asw.ConfParser.Parser.places.impl.ParserPlacesXLS;

public class FactoriaParserPlaces {
	
	public static ParserPlaces crearParserXLS(){
		return new ParserPlacesXLS();
	}

}
