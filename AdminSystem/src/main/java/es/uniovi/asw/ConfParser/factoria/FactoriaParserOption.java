package es.uniovi.asw.confParser.factoria;

import es.uniovi.asw.confParser.Parser.options.ParserOpt;
import es.uniovi.asw.confParser.Parser.options.impl.ParserOptXLS;

public class FactoriaParserOption {

	public static ParserOpt crearParserXLS() {
		return new ParserOptXLS();
	}

}
