package es.uniovi.asw.countVoteParser.factoria;

import es.uniovi.asw.countVoteParser.parser.ParserVotes;
import es.uniovi.asw.countVoteParser.parser.impl.ParserVotesXLS;

public class FactoriaParserVotes {

	public static ParserVotes crearParserXLS() {
		return new ParserVotesXLS();
	}

}
