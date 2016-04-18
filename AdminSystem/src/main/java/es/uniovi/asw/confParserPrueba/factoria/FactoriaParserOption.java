package es.uniovi.asw.confParserPrueba.factoria;

import es.uniovi.asw.confParserPrueba.Parser.options.ParserOpt;
import es.uniovi.asw.confParserPrueba.Parser.options.impl.ParserOptXLS;

public class FactoriaParserOption {

	public static ParserOpt crearParserXLS() {
		return new ParserOptXLS();
	}

}
