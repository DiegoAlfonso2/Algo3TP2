package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Espinas extends Terreno {

	@Override
	public void actuarSobreAlgoformer(AlgoFormer personaje) {
		personaje.atravesarEspinas();
		personaje.descontarMovimientoPosible(1);
	}

}
