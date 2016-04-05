package es.uniovi.asw.ConfParser.factorias;

import es.uniovi.asw.ConfParser.GeneradorCartas;
import es.uniovi.asw.ConfParser.GeneradorCartasPDF;

public class CartasPDFFactory implements CartasFactory {

	@Override
	public GeneradorCartas crearGeneradorCartas() {
		return new GeneradorCartasPDF();
	}

}
