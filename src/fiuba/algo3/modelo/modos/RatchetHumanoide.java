package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.Ataque;
import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;

public class RatchetHumanoide extends Modo {

	@Override
	public Modo cambiarModo() {
		return new RatchetAlterno();
	}

	@Override
	public String avatarModo() {
		return "Ratchet Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 5;
	}

	@Override
	public int distAtaqueModo() {
		return 5;
	}

	@Override
	public int velocidadModo() {
		return 1;
	}

	@Override
	public int atravesarEspinas(int puntosDeVida) {
		return (int) (puntosDeVida * 0.95);
	}

	@Override
	public int atravesarPantano() {
		throw new MovimientoInvalidoException();
	}

	@Override
	public void atravesarNebulosaAndromeda() {
		// No le ocurre nada al atravesar la Nebulosa de Andr�meda.
	}

	@Override
	public void atravesarTormentaPsionica(Ataque ataque) {
		// No le ocurre nada al atravesar la Tormenta Psi�nica.
	}

}
