package fiuba.algo3.modelo.superficies;

import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public abstract class Superficie {
	
	public abstract Collection<Consecuencia> actuarSobreAlgoformer(
			AlgoFormer personaje, EstadoVital estado);

}
