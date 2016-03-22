package es.uniovi.asw.factorias;

import es.uniovi.asw.parser.GeneradorCartas;
import es.uniovi.asw.parser.GeneradorCartasTXT;

public class CartasTXTFactory implements CartasFactory {

	@Override
	public GeneradorCartas crearGeneradorCartas() {
		return new GeneradorCartasTXT();
	}

}
