package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.Ataque;

public class OptimusAlterno extends Modo {

	@Override
	public Modo cambiarModo() {
		return new OptimusHumanoide();
	}

	@Override
	public String avatarModo() {
		return "Peterbilt 379";
	}

	@Override
	public int ataqueModo() {
		return 15;
	}

	@Override
	public int distAtaqueModo() {
		return 4;
	}

	@Override
	public int velocidadModo() {
		return 5;
	}

	@Override
	public int atravesarEspinas(int puntosDeVida) {
		return (int) (puntosDeVida * 0.95);
	}

	@Override
	public int atravesarPantano() {
		return 2;
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
