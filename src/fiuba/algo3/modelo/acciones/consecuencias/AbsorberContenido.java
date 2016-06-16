package fiuba.algo3.modelo.acciones.consecuencias;

import fiuba.algo3.modelo.Casillero;
import fiuba.algo3.modelo.Contenido;
import fiuba.algo3.modelo.excepciones.BonusYaAgregadoException;
import fiuba.algo3.modelo.transformers.AlgoFormer;

public class AbsorberContenido implements Consecuencia {
	
	private Contenido contenido;
	private Casillero casillero;

	public AbsorberContenido(Contenido contenido, Casillero casillero) {
		this.contenido = contenido;
		this.casillero = casillero;
	}

	@Override
	public void serAfrontadaPor(AlgoFormer personaje) {
		try {
			personaje.absorber(this.contenido);
			this.casillero.sacarContenido();
		} catch (BonusYaAgregadoException byae) {
			// Podría manejarse un controlador que avise al usuario que no puede agregar 2 bonus iguales.
		}
		
	}
	
}
