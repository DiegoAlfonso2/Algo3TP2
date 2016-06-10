package fiuba.algo3.modelo.superficies;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Nube extends Aire {

	@Override
	public Collection<Consecuencia> actuarSobreAlgoformer(AlgoFormer personaje, 
			EstadoVital estado) {
		// Por los supuestos decididos para implementar el trabajo, la Nube no hace NADA.
		return new ArrayList<Consecuencia>();
	}
	
}
