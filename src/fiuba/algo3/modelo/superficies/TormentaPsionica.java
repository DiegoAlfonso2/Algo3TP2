package fiuba.algo3.modelo.superficies;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class TormentaPsionica extends Aire {

	@Override
	public Collection<Consecuencia> actuarSobreAlgoformer(AlgoFormer personaje, 
			EstadoVital estado) {
		personaje.atravesarTormentaPsionica();
		// TODO Agregar consecuencias de atravesar una tormenta psionica
		return new ArrayList<Consecuencia>();
	}
	
}
