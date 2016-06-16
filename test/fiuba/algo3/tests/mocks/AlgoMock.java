package fiuba.algo3.tests.mocks;

import fiuba.algo3.modelo.modos.Modo;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class AlgoMock extends AlgoFormer {

	protected AlgoMock(String nombre, int puntosDeVida, Modo modoHumanoide,
			Modo modoAlterno) {
		super(nombre, puntosDeVida, modoHumanoide, modoAlterno);
	}

}
