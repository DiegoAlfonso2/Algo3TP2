package fiuba.algo3.modelo.superficies;

import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.transformers.AlgoFormer;

//TODO Si no se le agregan metodos o estado, convertir en Interface
public abstract class Superficie {
	
	public abstract Collection<Consecuencia> actuarSobreAlgoformer(
			AlgoFormer personaje, EstadoVital estado);

}
