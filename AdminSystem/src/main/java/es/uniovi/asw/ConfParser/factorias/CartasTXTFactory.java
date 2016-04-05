package es.uniovi.asw.ConfParser.factorias;

import es.uniovi.asw.ConfParser.GeneradorCartas;
import es.uniovi.asw.ConfParser.GeneradorCartasTXT;

public class CartasTXTFactory implements CartasFactory {

	@Override
	public GeneradorCartas crearGeneradorCartas() {
		return new GeneradorCartasTXT();
	}

}
