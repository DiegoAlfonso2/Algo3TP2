package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.elementos.FlagFusion;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class PenalizadorNebulosaAndromeda implements Consecuencia {

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		personaje.absorber(new FlagFusion());
	}

}
