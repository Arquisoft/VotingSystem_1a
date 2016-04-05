package es.uniovi.asw.ConfParser.factorias;

import es.uniovi.asw.ConfParser.Parser;
import es.uniovi.asw.ConfParser.ParserXLS;

public class ParserXLSFactory implements ParserFactory{

	@Override
	public Parser crearParser() {
		return new ParserXLS();
	}

}
