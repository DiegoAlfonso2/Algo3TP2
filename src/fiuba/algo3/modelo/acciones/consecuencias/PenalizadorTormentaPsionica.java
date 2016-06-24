package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.elementos.SancionTormentaPsionica;
import fiuba.algo3.modelo.excepciones.BonusYaAgregadoException;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class PenalizadorTormentaPsionica implements Consecuencia {

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		try {
			personaje.absorber(new SancionTormentaPsionica());
		} catch (BonusYaAgregadoException byae) {
			
		}
	}

}
