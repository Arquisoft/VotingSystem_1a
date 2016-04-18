package es.uniovi.asw.confParser.factoria;

import es.uniovi.asw.confParser.Parser.conf.ParserConf;
import es.uniovi.asw.confParser.Parser.conf.impl.ParserConfXLS;

public class FactoriaParserConf {

	public static ParserConf crearParserXLS() {
		return new ParserConfXLS();
	}
}
