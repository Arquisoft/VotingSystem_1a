package es.uniovi.asw.factorias;

import es.uniovi.asw.parser.GeneradorCartas;
import es.uniovi.asw.parser.GeneradorCartasPDF;

public class CartasPDFFactory implements CartasFactory {

	@Override
	public GeneradorCartas crearGeneradorCartas() {
		return new GeneradorCartasPDF();
	}

}
