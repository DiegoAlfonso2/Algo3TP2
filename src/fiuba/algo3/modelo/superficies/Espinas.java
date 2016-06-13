package fiuba.algo3.modelo.superficies;

import java.util.ArrayList;
import java.util.Collection;

import fiuba.algo3.modelo.EstadoVital;
import fiuba.algo3.modelo.acciones.consecuencias.AtravesarEspinas;
import fiuba.algo3.modelo.acciones.consecuencias.Consecuencia;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class Espinas extends Terreno {

	@Override
	public Collection<Consecuencia> actuarSobreAlgoformer(AlgoFormer personaje,
			EstadoVital estado) {
		// TODO Suposicion: atravesar las espinas hace danio a TODOS los algoformers,
		// tambien los aereos
//		Consecuencia atravesarEspinas = new AtravesarEspinas();
//		ArrayList<Consecuencia> consecuencias = new ArrayList<Consecuencia>();
//		consecuencias.add(atravesarEspinas);
		Collection<Consecuencia> consecuencias = personaje.atravesarEspinas(estado);
		return consecuencias;
	}

}
