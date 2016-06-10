package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class AbsorberContenido implements Consecuencia {
	Contenido contenido;

	public AbsorberContenido(Contenido contenido) {
		this.contenido = contenido;
	}

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		personaje.absorber(contenido);
	}
	
}
