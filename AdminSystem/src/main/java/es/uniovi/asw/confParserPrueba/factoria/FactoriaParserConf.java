package es.uniovi.asw.confParserPrueba.factoria;

import es.uniovi.asw.confParserPrueba.Parser.conf.ParserConf;
import es.uniovi.asw.confParserPrueba.Parser.conf.impl.ParserConfXLS;

public class FactoriaParserConf {

	public static ParserConf crearParserXLS() {
		return new ParserConfXLS();
	}
}
