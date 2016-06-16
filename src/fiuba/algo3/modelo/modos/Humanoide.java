package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;

public abstract class Humanoide extends Terrestre {

	@Override
	public int atravesarPantano() {
		throw new MovimientoInvalidoException();
	}

}
