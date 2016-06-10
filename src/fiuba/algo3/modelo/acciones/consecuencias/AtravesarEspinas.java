package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.transformers.AlgoFormer;

public class AtravesarEspinas implements Consecuencia {

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		personaje.atravesarEspinas();
	}

}
