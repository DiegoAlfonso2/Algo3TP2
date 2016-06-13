package fiuba.algo3.modelo.transformers;

import fiuba.algo3.modelo.modos.Modo;

/**
 * Created by Julian Garate on 6/4/16.
 */
abstract class Autobot extends AlgoFormer{

	protected Autobot(String nombre, int puntosDeVida, Modo modoHumanoide, Modo modoAlterno) {
		super(nombre, puntosDeVida, modoHumanoide, modoAlterno);
	}
}
