package es.uniovi.asw.ConfParser.factoria;

import es.uniovi.asw.ConfParser.Parser.options.ParserOpt;
import es.uniovi.asw.ConfParser.Parser.options.impl.ParserOptXLS;

public class FactoriaParserOption {
	
	public static ParserOpt crearParserXLS(){
		return new ParserOptXLS();
	}

}
