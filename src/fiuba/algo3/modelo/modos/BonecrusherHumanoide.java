package fiuba.algo3.modelo.modos;

import fiuba.algo3.modelo.excepciones.MovimientoInvalidoException;

public class BonecrusherHumanoide extends Modo {

	@Override
	public Modo cambiarModo() {
		return new BonecrusherAlterno();
	}

	@Override
	public String avatarModo() {
		return "Bonecrusher Humanoide";
	}

	@Override
	public int ataqueModo() {
		return 30;
	}

	@Override
	public int distAtaqueModo() {
		return 3;
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
		// TODO Auto-generated method stub
	}

	@Override
	public void atravesarTormentaPsionica() {
		// TODO Auto-generated method stub
	}

}
