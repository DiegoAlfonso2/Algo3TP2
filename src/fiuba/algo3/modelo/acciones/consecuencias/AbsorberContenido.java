package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class AbsorberContenido implements Consecuencia {
	Casillero casillero;

	public AbsorberContenido(Casillero casilleroConContenido) {
		this.casillero = casilleroConContenido;
	}

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		// Workaround por si un AlgoFormer pasa mas de una vez por el mismo 
		// casillero. El contenido debe ser absorbido solamente una vez. De
		// otra forma, al pasar por un modificador, este se duplicaria
		if (!casillero.estaVacio()) {
			personaje.absorber(casillero.obtenerContenido());
			this.casillero.sacarContenido();
		}
	}
	
}
