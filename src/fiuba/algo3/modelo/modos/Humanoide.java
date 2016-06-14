package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;

public abstract class Humanoide extends UnidadTerrestre {

	protected Humanoide(int ptosAtaque, int distAtaque, int velocidad) {
		super(ptosAtaque, distAtaque, velocidad);
	}

	@Override
	public int atravesarPantano() {
		throw new MovimientoInvalidoException(
				"Un Humanoide no puede atravesar un pantano");
	}

}
