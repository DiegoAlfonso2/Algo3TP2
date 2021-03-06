package fiuba.algo3.modelo.superficies;

import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Pantano extends Terreno {

	@Override
	public Collection<Consecuencia> actuarSobreAlgoformer(AlgoFormer personaje, EstadoVital estado) {
		return personaje.atravesarPantano(estado);
	}

}
