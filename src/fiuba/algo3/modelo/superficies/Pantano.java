package fiuba.algo3.modelo.superficies;

import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Pantano extends Terreno {

	@Override
	public void actuarSobreAlgoformer(AlgoFormer personaje) {
		personaje.atravesarPantano();
	}

}
