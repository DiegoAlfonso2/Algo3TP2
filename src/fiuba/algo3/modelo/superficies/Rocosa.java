package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Rocosa extends Terreno {

	@Override
	public void actuarSobreAlgoformer(AlgoFormer personaje) {
		personaje.descontarMovimientoPosible(1);
	}

}
