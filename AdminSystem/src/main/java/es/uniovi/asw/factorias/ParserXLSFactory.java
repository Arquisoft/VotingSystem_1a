package es.uniovi.asw.factorias;

import es.uniovi.asw.parser.Parser;
import es.uniovi.asw.parser.ParserXLS;

public class ParserXLSFactory implements ParserFactory{

	@Override
	public Parser crearParser() {
		return new ParserXLS();
	}

}
