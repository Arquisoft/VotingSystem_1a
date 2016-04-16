package es.uniovi.asw.ConfParser.factoria;

import es.uniovi.asw.ConfParser.Parser.conf.ParserConf;
import es.uniovi.asw.ConfParser.Parser.conf.impl.ParserConfXLS;

public class FactoriaParserConf {

	public static ParserConf crearParserXLS() {
		return new ParserConfXLS();
	}
}
