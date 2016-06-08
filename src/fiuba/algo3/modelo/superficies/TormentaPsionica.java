package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.transformers.AlgoFormer;

public class TormentaPsionica extends Aire {

	@Override
	public void actuarSobreAlgoformer(AlgoFormer personaje) {
		personaje.atravesarTormentaPsionica();
	}
	
}